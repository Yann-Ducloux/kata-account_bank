package model;

public class Deposit{
    public Deposit() {
    }

    public void saveMoney(Account account, float amount){
        account.addAmount(amount);
    }
}
