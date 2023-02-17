package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Account {
    List<IOperation> operations;

    private static final String LINE_BREAK = System.getProperty("line.separator");
    private static final String MONEY = "€";

    public Account() {
        this.operations = new ArrayList<>();
    }

    public Money calculateBalance() {
        return this.operations.stream()
                .map(IOperation::amount)
                .reduce(new Money(0f), Money::add);
    }

    public void transaction(IOperation operations) {
        this.operations.add(operations);
    }

    public String history() {
        String historique = "The balance " + this.calculateBalance().toString() + MONEY + LINE_BREAK;
        historique += "operation  | date       | amount";
        historique += this.operations.stream()
                .map(IOperation::print)
                .reduce("", (s, s2) -> {
                    s += LINE_BREAK + s2;
                    return s;
                });
        return historique;
    }
}
