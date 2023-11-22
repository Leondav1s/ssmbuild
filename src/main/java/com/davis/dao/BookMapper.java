package com.davis.dao;

import org.apache.ibatis.annotations.Param;
import com.davis.pojo.Books;

import java.util.List;

/**
 * @Author: Leondav1s
 * @Date: 11/21/23 9:42 AM
 */
public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookID") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookID") int id);

    //查询全部的书
    List<Books> queryAllBook();

    //根据id查询,返回一个Book
    Books queryBookByName(String bookName);
}
