package com.szhn.hegx.bms.controller;

import com.szhn.hegx.bms.modle.Book;
import com.szhn.hegx.bms.service.BookService;
import com.szhn.hegx.bms.utils.ResultBody;
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
    public ResultBody insert(Book book){
        bookService.insert(book);
        return new ResultBody();
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "/deleteById",httpMethod = "GET",notes = "根据id删除图书")
    public ResultBody deleteById(Integer bid){
        LOG.info("正在删除图书，删除id:",bid);
        bookService.deleteById(bid);
        return ResultBody.success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "/update",httpMethod = "POST",notes = "更新接口")
    public ResultBody update(Book book){
        bookService.update(book);
        return ResultBody.success();
    }

    @GetMapping("/getBook")
    @ApiOperation(value = "/getBook",httpMethod = "GET",notes = "查询图书")
    public ResultBody getBook(Book book){
        Book resultBook = bookService.getBook(book);
        return ResultBody.success(resultBook);
    }
}
