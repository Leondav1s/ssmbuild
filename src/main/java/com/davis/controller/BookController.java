package com.davis.controller;

import com.davis.pojo.Books;
import com.davis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Leondav1s
 * @Date: 11/22/23 8:45 AM
 */

@Controller
@RequestMapping("/book")
public class BookController {

    //controller调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;


    //查询全部的书籍，返回一个书籍展示页面

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();

        model.addAttribute("list",list);
        return "allBook";
    }

    //添加数据页面
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";   //回到首页 直接重定向到allBook方法
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id){
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }



    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        System.out.println("要查询的书籍:"+queryBookName); //如果查询的数据存在空格，则优化
        Books books =
                bookService.queryBookByName(queryBookName.trim()); List<Books> list = new ArrayList<Books>(); list.add(books); //如果没有查出来书籍，则返回全部书籍列表
        if (books==null){
            list = bookService.queryAllBook(); model.addAttribute("error", "没有找到本书!");
        }
        model.addAttribute("list", list);
        return "allBook";
    }


}
