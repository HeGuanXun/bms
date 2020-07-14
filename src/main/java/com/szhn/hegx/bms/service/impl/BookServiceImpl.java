package com.szhn.hegx.bms.service.impl;

import com.szhn.hegx.bms.dao.BookDao;
import com.szhn.hegx.bms.modle.Book;
import com.szhn.hegx.bms.service.BookService;
import com.szhn.hegx.bms.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author 何冠勋
 * @since 2020/7/13
 **/
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public int insert(Book book) {
        return bookDao.insert(book);
    }

    @Override
    public void insertBatch(List<Book> books) {
        bookDao.insertBatch(books);
    }

    @Override
    public int update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public Book getBook(Book Book) {
        return bookDao.getBook(Book);
    }

    @Override
    public Pagination<Book> getBookByPage(Pagination<Book> book) {
        return bookDao.getBookByPage(book);
    }
}
