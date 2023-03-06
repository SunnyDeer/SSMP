package com.qin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qin.pojo.Book;
import com.qin.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping
    public List<Book> getAll(){
       return bookService.list();
    }
    @PostMapping
    public Boolean save(@RequestBody  Book book){
        return bookService.save(book);
    }
    @PutMapping
    public Boolean Update(@RequestBody Book book){
        return bookService.updateById(book);
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return  bookService.removeById(id);
    }
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return bookService.getPage(currentPage,pageSize);

    }
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        return bookService.getPage(currentPage,pageSize, book);

    }
}