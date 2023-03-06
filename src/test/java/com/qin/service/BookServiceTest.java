package com.qin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qin.pojo.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void test1() {
        System.out.println(bookService.getById(13));
    }

    @Test
    void update() {
        Book book = new Book();
        book.setName("book77");
        book.setType("type77");
        book.setId(14);
        System.out.println(bookService.update(book));
    }

    @Test
    void insert() {
        Book book1 = new Book();
        book1.setName("book1");
        book1.setType("type1");
        System.out.println(bookService.save(book1));
    }

    @Test
    void delete() {
        System.out.println(bookService.delete(18));
    }

    @Test
    void getall() {
        System.out.println(bookService.getAll());
    }
    @Test
    void testGetPage() {
        bookService.getPage(1, 2);
    }
}
