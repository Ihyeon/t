package com.example.service;

import com.example.dto.BookDto;
import org.springframework.stereotype.Service;
import repository.BookRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    final private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getBooks(String status, LocalDate createdAt, String author, String title) {

        return bookRepository
                .searchBooks(status, createdAt, author, title)
                .stream()
                .map(book -> new BookDto(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getCreatedAt(),
                        book.getStatus()
                ))
                .collect(Collectors.toList());
    }
}
