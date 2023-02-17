package model;

public class Withdrawal extends Operation {

    public Withdrawal(Money amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "WITHDRAWAL | " + this.date + " | " + this.amount + MONEY;
    }

    @Override
    public Money amount() {
        return new Money(this.amount.getValue().negate());
    }
}
