package com.springboot.demo.application.controller;

import com.springboot.demo.application.mod.Book;
import com.springboot.demo.application.service.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BookController {

    @Resource
    BookRepository bookRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String getAllBook(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "list";
    }
}
