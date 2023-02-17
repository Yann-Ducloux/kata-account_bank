package model;

public interface IOperation {
    void execute(Account account);
    String toString();

    Money amount();
}
