package br.com.erudio.bookservice.controller;

import br.com.erudio.bookservice.model.Book;
import br.com.erudio.bookservice.proxy.CambioProxy;
import br.com.erudio.bookservice.repository.BookRepository;
import br.com.erudio.bookservice.response.Cambio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("/book-service")
public class BookController {

  private final Environment environment;
  private final BookRepository bookRepository;
  private final CambioProxy cambioProxy;

  @Autowired
  public BookController(Environment environment, BookRepository bookRepository, CambioProxy cambioProxy) {
    this.environment = environment;
    this.bookRepository = bookRepository;
    this.cambioProxy = cambioProxy;
  }


  @Operation(summary = "Find a specific book by your ID")
  @GetMapping("/{bookId}/{currency}")
  public Book findBook(@PathVariable("bookId") Long bookId, @PathVariable("currency") String currency) {
    String port = environment.getProperty("local.server.port");

    Book book = bookRepository.getById(bookId);

    if (book == null) throw new RuntimeException("Book not found");

    Cambio cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);

    book.setEnvironment("Book port:" + port + "Cambio port:" + cambio.getEnvironment());

    book.setPrice(cambio.getConvertedValue());

    return book;
  }
}
