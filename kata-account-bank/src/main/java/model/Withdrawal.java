package model;

import java.math.BigDecimal;

public class Withdrawal extends Operation {

    public Withdrawal(Money amount) {
        super(amount);
    }

    public void execute(Account account){
        account.subtractAmount(this.amount);
        account.transaction(this);
    }

    @Override
    public String print() {
        return TypeOperation.WITHDRAWAL + SEPARATOR + this.date + SEPARATOR + this.amount + MONEY;
    }
}
