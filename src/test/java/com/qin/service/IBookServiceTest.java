package com.qin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qin.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class IBookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    public void test1() {
        System.out.println(bookService.getById(14));
    }

    @Test
    void update() {
        Book book = new Book();
        book.setName("book3");
        book.setType("type3");
        book.setId(14);
        System.out.println(bookService.updateById(book));
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
        System.out.println(bookService.removeById(15));
    }

    @Test
    void getall() {
        System.out.println(bookService.list());
    }
    @Test
    void testGetPage() {
        IPage page = new Page<Book>(1,2);
        bookService.page(page);

    }

}
