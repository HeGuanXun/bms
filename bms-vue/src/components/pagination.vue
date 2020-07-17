<template>
    <div>
    <!-- pages -->
        <div style="display:flex;justify-content: center;align-items:center;">
        <el-pagination style="margin-top: 15px"
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="pagination.currentPage"
                :page-sizes="[5,10, 20, 50,100]"
                :page-size="pagination.pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="pagination.total"
        ></el-pagination>
    </div>
    </div>
</template>

<script>
    import Moment from "moment";
    import Vue from "vue";
    import { eventBus } from "scripts/utils/BUS";
    import qs from 'qs';
    export default {
        components: {},
        data () {
            return {
                pagination: {
                    pageSize: 10,
                    total: 0,
                    currentPage: 1
                },
                bus:null,
                url:null,
                searchForm:null
            };
        },
        computed: {},

        mounted(){},

        methods: {

            /*
            All paging queries use this method
            * url:
            * searchForm:
            * bus:
            * */
            $query(url,searchForm,bus,nest) {
                this.url = url;
                this.bus = bus;
                this.searchForm = JSON.parse(JSON.stringify(searchForm));
                if (this.searchForm.times != undefined) {
                    let time1 = this.searchForm.times[0];
                    let time2 = this.searchForm.times[1];
                    this.searchForm.startTime = Moment(time1).format("YYYY-MM-DD HH:mm:ss");
                    this.searchForm.endTime = Moment(time2).format("YYYY-MM-DD HH:mm:ss");
                     Vue.delete(this.searchForm, 'times' );
                }
                this.searchForm.pageSize = this.pagination.pageSize;
                if (nest==true){
                    this.searchForm.currentPage = this.pagination.currentPage;
                }else {
                    this.searchForm.currentPage = 1;
                }
                let data = qs.stringify(this.searchForm, {indices: false});
                this.$axios.post(url,data).then(res => {
                    let tableData = res.data.data;
                    let myTaleData=[];
                    let data = res.data.data;
                    for(let key  in data){
                        if (key.indexOf('List')!=-1){
                            if (tableData[key]==null || tableData[key].length==0){
                                continue;
                            }
                            myTaleData =  data[key];
                            break;
                        }
                    }
                    this.pagination.currentPage = data.currentPage;
                    this.pagination.pageSize = data.pageSize;
                    this.pagination.total = data.total;
                    //to bus
                    eventBus.$emit(bus,myTaleData);
                }).catch((e) => {
                    console.log("e",e);
                });
            },

            handleSizeChange(val) {
                this.pagination.pageSize = val;
                this.$query(this.url,this.searchForm,this.bus,true);
            },

            handleCurrentChange(val) {
                this.pagination.currentPage = val;
                this.$query(this.url,this.searchForm,this.bus,true);
            },
        }
    }

</script>
<style scoped lang="sass">
</style>
