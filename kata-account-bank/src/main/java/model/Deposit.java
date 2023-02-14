package model;

import java.math.BigDecimal;

public class Deposit extends Operation {

    public Deposit(BigDecimal amount) {
        super(amount);
    }

    public void saveMoney(Account account){
        account.addAmount(this.amount);
        account.addOperations(this);
    }

    @Override
    public String print() {
        return TypeOperation.DEPOSIT + "   " + SEPARATOR + this.date + SEPARATOR + this.amount + MONEY;
    }
}
