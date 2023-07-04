package br.com.erudio.bookservice.controller;

import br.com.erudio.bookservice.model.Book;
import br.com.erudio.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/book-service")
public class BookController {

  @Autowired
  Environment environment;
  @Autowired
  BookRepository bookRepository;


  @GetMapping("/{bookId}/{currency}")
  public Book findBook(
          @PathVariable("bookId") Long bookId,
          @PathVariable("currency") String currency
  ) {
    var port = environment.getProperty("local.server.port");

    var book = bookRepository.getById(bookId);
    if (book == null) throw new RuntimeException("Book not found");

    book.setEnvironment(port);

    return book;
  }
}
