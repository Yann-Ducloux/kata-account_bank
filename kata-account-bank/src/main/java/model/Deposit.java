package model;

import java.math.BigDecimal;

public class Deposit implements IOperation {
    public void saveMoney(Account account, BigDecimal amount){
        account.addAmount(amount);
    }
}