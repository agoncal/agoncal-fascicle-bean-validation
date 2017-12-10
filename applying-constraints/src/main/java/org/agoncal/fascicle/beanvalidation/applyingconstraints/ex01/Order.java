package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex01;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// @formatter:off
// tag::adocSnippet[]
public class Order {

  @NotNull
  @Pattern(regexp = "[C,D,M][A-Z][0-9]*")
  private String orderId;
  @NotNull @Min(1)
  private Double totalAmount;
  @PastOrPresent
  private Date creationDate;
  @Future
  private Date deliveryDate;
  @Email
  private String customerEmail;

  @NotNull
  private List<OrderLine> orderLines;

  public Order(@Past Date creationDate) {
    this.creationDate = creationDate;
  }

  @NotNull
  public Double calculateTotalAmount(@Positive Double changeRate) {
    return complexCalculation();
  }

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

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getCustomerEmail() {
    return customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
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
