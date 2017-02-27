package io.ordermanagement.model;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * Money Value Object
 */
@Embeddable
public class Money implements ValueObject {

    private BigDecimal amount;
    private String currency;

    private Money() {
    }

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money(Money money) {
        this.amount = money.amount;
        this.currency = money.currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (amount != null ? !amount.equals(money.amount) : money.amount != null) return false;
        return currency != null ? currency.equals(money.currency) : money.currency == null;
    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
