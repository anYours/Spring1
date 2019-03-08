package com.springboot.demo.application.service.impl;

import com.github.pagehelper.PageHelper;
import com.springboot.demo.application.mod.Book;
import com.springboot.demo.application.service.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.demo.application.service.BookRepository;
import com.springboot.demo.application.service.IBookService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> quereyBookByName(String name) {
        return bookMapper.queryBookByName(name);
    }

    @Override
    public List<Book> queryUserByPage(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        return this.bookMapper.select(null);
    }


}
