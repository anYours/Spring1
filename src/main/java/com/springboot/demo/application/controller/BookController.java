package com.springboot.demo.application.controller;

import com.springboot.demo.application.mod.Book;
import com.springboot.demo.application.service.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return "redirect:/all";
    }
    @RequestMapping(value="edit")
    public String saveBook(Book book){
        bookRepository.save(book);
        return "redirect:/all";
    }

    @RequestMapping(value = "findOne/{id}")
    public String findBookOne(@PathVariable Long id, Model model){
        Optional<Book> book = bookRepository.findById(id);
        model.addAttribute("Book", book);
        return "redirect:/all";
    }
}
