package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex01;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Order {

  @NotNull @Pattern(regexp = "[CDM][0-9]+")
  private String orderId;
  @NotNull @Min(1)
  private BigDecimal totalAmount;
  @PastOrPresent
  private Instant creationDate;
  @Future
  private LocalDate deliveryDate;

  @NotNull
  private List<OrderLine> orderLines;

  public Order(@PastOrPresent Instant creationDate) {
    this.creationDate = creationDate;
  }

  @NotNull
  public Double calculateTotalAmount(@Positive Double changeRate) {
    return complexCalculation();
  }

  // Constructors, getters, setters
  // tag::adocSkip[]
  public Order() {
  }

  private Double complexCalculation() {
    return 1d;
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

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
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

  public void addOrderLine(OrderLine orderLine) {
    if (this.orderLines == null)
      this.orderLines = new ArrayList<>();

    this.orderLines.add(orderLine);
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
