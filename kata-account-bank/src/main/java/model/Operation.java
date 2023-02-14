package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Operation implements IOperation{
    LocalDate date;
    BigDecimal amount;
    public static final String MONEY = "€";
    public static final String SEPARATOR = " | ";

    public abstract String print();

    public Operation(BigDecimal amount) {
        this.amount = amount;
        this.date = LocalDate.now();
    }
}
