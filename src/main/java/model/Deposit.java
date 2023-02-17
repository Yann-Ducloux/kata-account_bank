package model;

public class Deposit extends Operation {

    public Deposit(Money amount) {
        super(amount);
    }

    @Override
    public String print() {
        return TypeOperation.DEPOSIT + "   " + SEPARATOR + this.date + SEPARATOR + this.amount + MONEY;
    }


    @Override
    public Money amount() {
        return this.amount;
    }
}
