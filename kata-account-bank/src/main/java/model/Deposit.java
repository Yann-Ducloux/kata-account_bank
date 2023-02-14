package model;

import java.math.BigDecimal;

public class Deposit extends Operation {

    public Deposit(Money amount) {
        super(amount);
    }

    public void execute(Account account){
        account.addAmount(this.amount);
        account.transaction(this);
    }

    @Override
    public String print() {
        return TypeOperation.DEPOSIT + "   " + SEPARATOR + this.date + SEPARATOR + this.amount + MONEY;
    }
}
