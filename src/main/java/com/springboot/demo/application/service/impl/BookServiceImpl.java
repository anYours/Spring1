package com.springboot.demo.application.service.impl;

import com.springboot.demo.application.mod.Book;
import org.springframework.stereotype.Service;
import com.springboot.demo.application.service.BookRepository;
import com.springboot.demo.application.service.IBookService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Resource
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
