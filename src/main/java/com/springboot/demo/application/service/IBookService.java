package com.springboot.demo.application.service;

import com.springboot.demo.application.mod.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {

    List<Book> findAll();
    List<Book> quereyBookByName(String name);

    List<Book> queryUserByPage(Integer page, Integer rows);
}
