package model;

import java.time.LocalDate;

public abstract class Operation implements IOperation{
    protected LocalDate date;
    protected Money amount;
    public static final String MONEY = "€";
    public static final String SEPARATOR = " | ";

    public abstract String toString();
    public void execute(Account account){
        account.transaction(this);
    }

    protected Operation(Money amount) {
        this.amount = amount;
        this.date = LocalDate.now();
    }
}
