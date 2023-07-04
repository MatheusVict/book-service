package br.com.erudio.bookservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "author", nullable = false, length = 180)
  private String author;

  @Column(name = "launch_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date launchDate;

  @Column(nullable = false)
  private Double price;

  @Column(nullable = false, length = 250)
  private String title;

  @Transient
  private String currency;

  @Transient
  private String environment;

  public Book() {}

  public Book(
          Long id,
          String author,
          String title,
          Date launchDate,
          Double price,
          String currency,
          String environment
  ) {
    this.id = id;
    this.author = author;
    this.launchDate = launchDate;
    this.price = price;
    this.title = title;
    this.currency = currency;
    this.environment = environment;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(Date launchDate) {
    this.launchDate = launchDate;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (!id.equals(book.id)) return false;
    if (!author.equals(book.author)) return false;
    if (!launchDate.equals(book.launchDate)) return false;
    if (!price.equals(book.price)) return false;
    if (!title.equals(book.title)) return false;
    if (!currency.equals(book.currency)) return false;
    return environment.equals(book.environment);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + author.hashCode();
    result = 31 * result + launchDate.hashCode();
    result = 31 * result + price.hashCode();
    result = 31 * result + title.hashCode();
    result = 31 * result + currency.hashCode();
    result = 31 * result + environment.hashCode();
    return result;
  }
}
