package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex08;

import jakarta.validation.constraints.Pattern;
import java.time.Instant;
import java.time.LocalDate;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class Order {

  @Pattern(regexp = "[CDM][A-Z][0-9]*")
  @Pattern(regexp = ".[A-Z].*?")
  private String orderId;
  private Instant creationDate;
  private Double totalAmount;
  private LocalDate paymentDate;
  private LocalDate deliveryDate;

  // Constructors, getters, setters
  // tag::adocSkip[]

  // ======================================
  // =            Constructors            =
  // ======================================

  public Order() {
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Instant getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Instant creationDate) {
    this.creationDate = creationDate;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public LocalDate getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(LocalDate paymentDate) {
    this.paymentDate = paymentDate;
  }

  public LocalDate getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(LocalDate deliveryDate) {
    this.deliveryDate = deliveryDate;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
