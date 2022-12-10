package org.agoncal.fascicle.beanvalidation.advanced.ex02;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
@ChronologicalDates(groups = Delivery.class)
public class Order {

  @NotNull
  private Long id;
  private Double totalAmount;
  @NotNull @Past
  private LocalDate creationDate;
  @NotNull(groups = Payment.class) @Past(groups = Payment.class)
  private LocalDate paymentDate;
  @NotNull(groups = Delivery.class) @Future(groups = Delivery.class)
  private LocalDate deliveryDate;
  private List<OrderLine> orderLines;

  // Constructors, getters, setters
  // tag::adocSkip[]
  // @formatter:on

  public Order() {
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Order id(Long id) {
    this.id = id;
    return this;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Order totalAmount(Double itotalAmountd) {
    this.totalAmount = totalAmount;
    return this;
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

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
