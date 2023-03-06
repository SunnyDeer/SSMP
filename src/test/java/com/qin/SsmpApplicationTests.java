package com.qin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qin.mapper.BookMapper;
import com.qin.pojo.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SsmpApplicationTests {


    @Autowired
    private BookMapper bookMapper;

    @Test
    void select() {
        System.out.println(bookMapper.selectById(13));

    }

    @Test
    void update() {
        Book book = new Book();
        book.setName("book3");
        book.setType("type3");
        book.setId(14);
        System.out.println(bookMapper.updateById(book));
    }

    @Test
    void insert() {
        Book book1 = new Book();
        book1.setName("book1");
        book1.setType("type1");
        System.out.println(bookMapper.insert(book1));
    }

    @Test
    void delete() {
        System.out.println(bookMapper.deleteById(15));
    }

    @Test
    void getall() {
        System.out.println(bookMapper.selectList(null));

    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 1);
        bookMapper.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy() {
//       "select * from tbl_book where name like %name%"
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "spring");
        bookMapper.selectList(qw);
    }

    @Test
    void testGetBy2() {
        String name = null;
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<>();
        qw.like(Strings.isNotEmpty(name),Book::getName, "spring");
        bookMapper.selectList(qw);
    }
}
