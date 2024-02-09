package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class Installment {
  private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private LocalDate dualDate;
  private Double amount;

  public Installment(){
  }

  public Installment(LocalDate dualDate, Double amount) {
    this.dualDate = dualDate;
    this.amount = amount;
  }

  public LocalDate getDualDate() {
    return dualDate;
  }

  public void setDualDate(LocalDate dualDate) {
    this.dualDate = dualDate;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return
             dualDate.format(fmt)+
            " - " +String.format("%.2f",amount);
  }
}
