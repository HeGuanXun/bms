package com.szhn.hegx.bms.dao;

import com.szhn.hegx.bms.modle.Book;
import com.szhn.hegx.bms.utils.Pagination;
import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author 何冠勋
 * @since 2020/7/13
 **/
public interface BookDao {

    int insert(Book book);

    void insertBatch(List<Book> books);

    int update(Book book);

    void deleteById(Integer id);

    Book getBook(Book Book);

    /**
     * 分页查询
     * @param book
     * @return
     */
    Pagination<Book> getBookByPage(Pagination<Book> book);

}
