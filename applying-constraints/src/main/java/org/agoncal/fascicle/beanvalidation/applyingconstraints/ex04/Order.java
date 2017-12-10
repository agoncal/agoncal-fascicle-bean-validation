package org.agoncal.fascicle.beanvalidation.applyingconstraints.ex04;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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

  private String orderId;
  private Double totalAmount;

  @NotEmpty
  private List<@Email @NotEmpty String> emails;

  @NotEmpty
  private List<OrderLine> orderLines;

  // tag::adocSkip[]
  // @formatter:on
  public Order() {
  }

  public Order(String orderId, Double totalAmount) {
    this.orderId = orderId;
    this.totalAmount = totalAmount;
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

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }

  public void addEmail(String email) {
    if (this.emails == null)
      this.emails = new ArrayList<>();

    this.emails.add(email);
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
