package model;

public interface IOperation {
    void execute(Account account);
    String print();
    Money applyOn(Money money);

    Money amount();
}
