package Entities;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private int from;
    private int to;
    private BigDecimal amount;
    private Date date;

    public Transaction(){};

    public Transaction(int from, int to, BigDecimal amount, Date date) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
