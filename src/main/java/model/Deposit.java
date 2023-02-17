package model;

public class Deposit extends Operation {

    public Deposit(Money amount) {
        super(amount);
    }

    @Override
    public String toString() {
        return "DEPOSIT    | " + this.date + " | " + this.amount + MONEY;
    }


    @Override
    public Money amount() {
        return this.amount;
    }
}
