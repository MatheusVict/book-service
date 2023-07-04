package br.com.erudio.bookservice.model;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

  private Long id;

  private String author;

  private Date launchDate;

  private Double price;

  private String title;

  private String currency;

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
