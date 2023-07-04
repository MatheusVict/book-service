package br.com.erudio.bookservice.response;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
public class Cambio implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String from;

  private String to;

  private Double conversionFactor;

  private Double convertedValue;

  private String environment;

  public Cambio() {}


  public Cambio(
    Long id,
    String from,
    String to,
    Double conversionFactor,
    Double convertedValue,
    String environment
  ) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionFactor = conversionFactor;
    this.convertedValue = convertedValue;
    this.environment = environment;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Double getConversionFactor() {
    return conversionFactor;
  }

  public void setConversionFactor(Double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public Double getConvertedValue() {
    return convertedValue;
  }

  public void setConvertedValue(Double convertedValue) {
    this.convertedValue = convertedValue;
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

    Cambio cambio = (Cambio) o;

    if (!id.equals(cambio.id)) return false;
    if (!from.equals(cambio.from)) return false;
    if (!to.equals(cambio.to)) return false;
    if (!conversionFactor.equals(cambio.conversionFactor)) return false;
    if (!convertedValue.equals(cambio.convertedValue)) return false;
    return environment.equals(cambio.environment);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + from.hashCode();
    result = 31 * result + to.hashCode();
    result = 31 * result + conversionFactor.hashCode();
    result = 31 * result + convertedValue.hashCode();
    result = 31 * result + environment.hashCode();
    return result;
  }
}
