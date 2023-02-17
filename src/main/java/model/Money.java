package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private BigDecimal value;
    public Money(float value) {
        this.value = new BigDecimal(String.valueOf(value));
    }
    public Money(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Money add(Money money) {
        return new Money(value.add(money.value));
    }
    public Money subtract(Money money) {
        return new Money(value.subtract(money.value));
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value.equals(money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
