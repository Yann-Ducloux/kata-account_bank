package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    Money balance;
    List<IOperation> operations;

    private static final String LINE_BREAK = System.getProperty("line.separator");
    private static final String MONEY = "€";

    public Account(Money balance) {
        this.balance = balance;
        this.operations = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return balance != null ? balance.hashCode() : 0;
    }

    public void addAmount(Money balance) {
        this.balance.add(balance);
    }
    public void subtractAmount(Money balance) {
        this.balance.subtract(balance);
    }

    public void transaction(IOperation operations) {
        this.operations.add(operations);
    }

    public String history() {
        String historique = "The balance " + this.balance.toString() + MONEY + LINE_BREAK;
        historique += "operation  | date       | amount";
        for (IOperation operation : operations) {
            historique += LINE_BREAK + operation.print();
        }
        return historique;
    }
}
