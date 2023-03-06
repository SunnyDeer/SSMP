package com.qin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qin.pojo.Book;
import com.qin.pojo.R;
import com.qin.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController1 {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());

    }

    @PostMapping
    public R save(@RequestBody Book book) {

//        if(book.getName().equals("qqq")) throw new Exception();
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R Update(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));

    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        boolean flag = bookService.removeById(id);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {
        System.out.println("-------"+book.toString());
        IPage page = bookService.getPage(currentPage, pageSize,book);
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize,book);
        }
        return new R(true, page);
    }

}