package com.davis.service;

import com.davis.pojo.Books;


import java.util.List;

/**
 * @Author: Leondav1s
 * @Date: 11/21/23 10:18 AM
 */
public interface BookService {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();

    //根据id查询,返回一个Book
    Books queryBookByName(String bookName);
}
