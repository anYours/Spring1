package com.springboot.demo.application.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.GsonBuilder;
import com.springboot.demo.application.mod.Book;
import com.springboot.demo.application.service.BookRepository;
import com.springboot.demo.application.service.IBookService;
import com.springboot.demo.application.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@Component
@ConfigurationProperties(prefix = "test")
public class BookController {

    @Resource
    BookRepository bookRepository;

    @Resource
    BookServiceImpl bookService;

    private String myName;

    public void setMyName(String myName){
        this.myName = myName;
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String getAllBook(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        System.out.println("model = [" + myName + "]");
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

    @RequestMapping(value = "findOne/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String findBookOne(@PathVariable Long id){
        Optional<Book> book = bookRepository.findById(id);
        String s = new GsonBuilder().create().toJson(book);
        return s;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    @CrossOrigin
    public String findAll(){
        List<Book> books = bookRepository.findAll();
        String s = new GsonBuilder().create().toJson(books);
        return s;
    }

    @RequestMapping("/list/{name}")
    public List<Book> queryBookByName(@PathVariable String name){
        List<Book> list = bookService.quereyBookByName(name);
        return list;
    }

    @RequestMapping("/page/{page}/{rows}")
    @ResponseBody
    public String queryUserAll(@PathVariable Integer page, @PathVariable Integer rows){
        List<Book> books = bookService.queryUserByPage(page, rows);
        String s = new GsonBuilder().disableHtmlEscaping().create().toJson(books);
        return s;
    }

    @GetMapping("/getAllBook")
    public String getAllBooks(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        List<Book> books = bookService.queryUserByPage(pageNum, 5);
        PageInfo<Book> pageInfo = new PageInfo<Book>(books);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("apiName","getAllBook");
        return "bookList";
    }
}
