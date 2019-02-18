package com.springboot.demo.application.service;

import com.springboot.demo.application.mod.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookService {

    List<Book> findAll();
}
