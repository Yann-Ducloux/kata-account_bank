package model;

import java.math.BigDecimal;

public class Withdrawal extends Operation {

    public Withdrawal(BigDecimal amount) {
        super(amount);
    }

    public void execute(Account account){
        account.subtractAmount(this.amount);
        account.addOperations(this);
    }

    @Override
    public String print() {
        return TypeOperation.WITHDRAWAL + SEPARATOR + this.date + SEPARATOR + this.amount + MONEY;
    }
}
