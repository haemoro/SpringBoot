package com.exam.haemo.controller;

import com.exam.haemo.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaemoController {
    @GetMapping("/book/{id}")
    public Book getABook(@PathVariable Integer id) {
        Book book = new Book();
        book.setId(id);
        book.setTitle("spring rest docs in spring boot");
        book.setAuthor("haemo");
        return book;
    }
}
