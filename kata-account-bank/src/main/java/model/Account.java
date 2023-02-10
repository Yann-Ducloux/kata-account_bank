package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
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

    public void addAmount(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }
    public void subtractAmount(BigDecimal balance) {
        this.balance = this.balance.subtract(balance);
    }
}
