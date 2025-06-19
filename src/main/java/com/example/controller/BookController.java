package com.example.controller;

import com.example.dto.BookDto;
import com.example.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getBooks(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) LocalDate createdAt,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title
            ) {
        return bookService.getBooks(status, createdAt, author, title);
    }
//
//    // 2. 도서 등록
//    @PostMapping
//    public void addBook(@RequestBody BookDto bookDto) {
//        bookService.addBook(bookDto);
//    }
//
//    // 3. 단일 도서 삭제
//    @DeleteMapping("/{bookId}")
//    public void deleteBook(@PathVariable Long bookId) {
//        bookService.deleteBook(bookId);
//    }
//
//    // 4. 여러 도서 삭제 (체크박스 선택 삭제용)
//    @PostMapping("/delete-batch")
//    public void deleteBooks(@RequestBody List<Long> bookIds) {
//        bookService.deleteBooks(bookIds);
//    }
//
//    // 5. 도서 예약
//    @PostMapping("/{bookId}/reserve")
//    public void reserveBook(@PathVariable Long bookId, @RequestBody ReservationDto dto) {
//        bookService.reserveBook(bookId, dto.getReserveDate());
//    }
}
