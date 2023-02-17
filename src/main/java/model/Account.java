package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    List<IOperation> operations;

    private static final String LINE_BREAK = System.getProperty("line.separator");
    private static final String MONEY = "€";

    public Account() {
        this.operations = new ArrayList<>();
    }

    public Money balance() {
        return this.operations.stream()
                .map(IOperation::amount)
                .reduce(new Money(0f), Money::add);
    }

    public void transaction(IOperation operations) {
        this.operations.add(operations);
    }

    public String history() {
        String historique = "The balance " + this.balance().toString() + MONEY + LINE_BREAK;
        historique += "operation  | date       | amount";
        historique += this.operations.stream()
                .map(IOperation::toString)
                .reduce("", (s, s2) -> {
                    s += LINE_BREAK + s2;
                    return s;
                });
        return historique;
    }
}
