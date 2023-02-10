package model;

import java.math.BigDecimal;

public class Withdrawal {
    public void saveMoney(Account account, BigDecimal amount){
        account.subtractAmount(amount);
    }
}
