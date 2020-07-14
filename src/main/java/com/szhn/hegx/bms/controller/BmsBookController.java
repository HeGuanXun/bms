package com.szhn.hegx.bms.controller;

import com.szhn.hegx.bms.modle.Book;
import com.szhn.hegx.bms.service.BookService;
import com.szhn.hegx.bms.utils.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>TODO</p>
 *
 * @author 何冠勋
 * @since 2020/7/13
 **/
@RestController
@RequestMapping("/book")
@Api(value = "/book",tags = {"图书管理增删改查接口"})
public class BmsBookController {

    private final static Logger LOG = LoggerFactory.getLogger(BmsBookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping("/insert")
    @ApiOperation(value = "/insert",httpMethod = "POST",notes = "新增")
    public ApiResponse insert(Book book){
        bookService.insert(book);
        return new ApiResponse();
    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "/deleteById",httpMethod = "GET",notes = "根据id删除图书")
    public ApiResponse deleteById(Integer bid){
        try {
            bookService.deleteById(bid);
        } catch (Exception e) {
            LOG.error("删除失败，请联系管理员",e);
            return new ApiResponse(ApiResponse.Status.INTERNAL_SERVER_ERROR.getCode(),ApiResponse.Status.INTERNAL_SERVER_ERROR.getStandardMessage(),null);
        }
        return new ApiResponse();
    }
    @PostMapping("/update")
    @ApiOperation(value = "/update",httpMethod = "POST",notes = "更新接口")
    public ApiResponse update(Book book){
        bookService.update(book);
        return new ApiResponse();
    }
    @GetMapping("/getBook")
    @ApiOperation(value = "/getBook",httpMethod = "GET",notes = "查询图书")
    public ApiResponse getBook(Book book){
        Book resultBook = bookService.getBook(book);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(resultBook);
        return apiResponse;
    }
}
