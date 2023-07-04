package br.com.erudio.bookservice.controller;

import br.com.erudio.bookservice.model.Book;
import br.com.erudio.bookservice.repository.BookRepository;
import br.com.erudio.bookservice.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/book-service")
public class BookController {

  private final Environment environment;
  private final BookRepository bookRepository;

  @Autowired
  public BookController(Environment environment, BookRepository bookRepository) {
    this.environment = environment;
    this.bookRepository = bookRepository;
  }


  @GetMapping("/{bookId}/{currency}")
  public Book findBook(@PathVariable("bookId") Long bookId, @PathVariable("currency") String currency) {
    String port = environment.getProperty("local.server.port");

    Book book = bookRepository.getById(bookId);

    if (book == null) throw new RuntimeException("Book not found");

    HashMap<String, String> params = createCambioParams(book.getPrice().toString(), currency);
    Cambio cambio = retrieveCambio(params);

    book.setEnvironment(port);

    book.setPrice(cambio.getConvertedValue());

    return book;
  }

  private HashMap<String, String> createCambioParams (String amount, String currency) {
    HashMap<String, String> params = new HashMap<>();

    params.put("amount", amount);
    params.put("from", "USD");
    params.put("to", currency);
    return params;
  }

  private Cambio retrieveCambio(HashMap<String, String> params) {
    String url = "http://localhost:8000/cambio-service/{amount}/{from}/{to}";
    return new RestTemplate().getForEntity(url, Cambio.class, params).getBody();
  }
}
