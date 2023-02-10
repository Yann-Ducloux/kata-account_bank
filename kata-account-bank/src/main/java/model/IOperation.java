package model;

import java.math.BigDecimal;

public interface IOperation {
    void saveMoney(Account account, BigDecimal amount);
}
