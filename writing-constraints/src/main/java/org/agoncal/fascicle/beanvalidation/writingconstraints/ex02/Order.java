package org.agoncal.fascicle.beanvalidation.writingconstraints.ex02;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
// tag::adocclassconstraint[]
@ChronologicalDates
public class Order {

  // tag::adocSkip[]
  @NotNull
  @Pattern(regexp = "[C,D,M][A-Z][0-9]*")
  private String orderId;
  @NotNull
  @Min(1)
  // end::adocSkip[]
  private Double totalAmount;
  private Date creationDate;
  private Date paymentDate;
  private Date deliveryDate;
  private List<OrderLine> orderLines;
  // end::adocclassconstraint[]

  public Order() {
  }

  public Order(@Past Date creationDate) {
    this.creationDate = creationDate;
  }

  @NotNull
  public Double calculateTotalAmount(@GreaterThanZero Double changeRate) {
    return complexCalculation();
  }

  // tag::adocSkipbody[]
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

  public Date getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public List<OrderLine> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }
  // end::adocSkipbody[]
}
// end::adocSnippet[]
