package model;

import java.math.BigDecimal;

public class Withdrawal extends Operation {

    public Withdrawal(Money amount) {
        super(amount);
    }

    @Override
    public String print() {
        return TypeOperation.WITHDRAWAL + SEPARATOR + this.date + SEPARATOR + this.amount + MONEY;
    }

    @Override
    public Money amount() {
        return new Money(this.amount.getValue().negate());
    }

    @Override
    public Money applyOn(Money money) {
        return this.amount.subtract(money);
    }
}