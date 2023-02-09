package model;

import java.util.Objects;

public class Account {
    float balance;

    public Account(float balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Float.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    public void addAmount(float balance) {
        this.balance += balance;
    }
}
