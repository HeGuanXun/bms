package com.szhn.hegx.bms.controller;

import com.szhn.hegx.bms.modle.Book;
import com.szhn.hegx.bms.service.BookService;
import com.szhn.hegx.bms.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>TODO</p>
 *
 * @author 何冠勋
 * @since 2020/7/13
 **/
@RestController
public class BmsController {

    @Autowired
    private BookService bookService;

    @GetMapping("/hello")
    public ApiResponse hello(){
        System.out.println("test hello world");
        return new ApiResponse();
    }

    @GetMapping("/getBook")
    public ApiResponse getBook(Book book){
        ApiResponse apiResponse = new ApiResponse();
        Book resultBook = bookService.getBook(book);
        apiResponse.setData(resultBook);
        return apiResponse;
    }
}
