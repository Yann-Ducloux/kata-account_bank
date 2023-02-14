package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MainTest {
    private static final String LINE_BREAK = System.getProperty("line.separator");
    private static final String MONEY = "€";
    private static final String SEPARATOR = " | ";

    @Test
    void SingleDepositInAccountEmptyTest() {
        //GIVEN
        Account account = new Account(initialBalance(0f));
        Operation deposit = new Deposit(amount(907.23f));

        //WHEN
        deposit.execute(account);
        String historique = account.history();

        //THEN
        assertThat(historique, is(historique(balance(907.23f),deposit(907.23f))));
    }

    @Test
    void MultipleDepositInAccountEmptyTest() {
        //GIVEN
        Account account = new Account(initialBalance(0f));
        Operation depositFirst = new Deposit(amount(146.18f));
        Operation depositSecond = new Deposit(amount(147.30f));

        //WHEN
        depositFirst.execute(account);
        depositSecond.execute(account);
        String historique = account.history();

        //THEN
        assertThat(historique, is(historique(balance(293.48f),deposit(146.18f), deposit(147.30f))));
    }

    @Test
    void SingleDepositInAccountFillTest() {
        //GIVEN
        Account account = new Account(initialBalance(393.12f));
        Operation deposit = new Deposit(amount(80.00f));

        //WHEN
        deposit.execute(account);
        String historique = account.history();

        //THEN
        assertThat(historique, is(historique(balance(473.12f),deposit(80.00f))));
    }

    @Test
    void MultipleDepositInAccountFillTest() {
        //GIVEN
        Account account = new Account(initialBalance(182.91f));
        Operation depositFirst = new Deposit(amount(62.07f));
        Operation depositSecond = new Deposit(amount(47.00f));

        //WHEN
        depositFirst.execute(account);
        depositSecond.execute(account);
        String historique = account.history();

        //THEN
        assertThat(historique, is(historique(balance(291.98f),deposit(62.07f), deposit(47.00f))));
    }
    @Test
    void SingleWithdrawalInAccountFillTest() {
        //GIVEN
        Account account = new Account(initialBalance(561.22f));
        Operation withdrawal = new Withdrawal(amount( 12.30f));

        //WHEN
        withdrawal.execute(account);
        String historique = account.history();

        //THEN
        assertThat(historique, is(historique(balance(548.92f),withdrawal(12.30f))));
    }
    @Test
    void MultipleWithdrawalInAccountFillTest() {
        //GIVEN
        Account account = new Account(initialBalance(383.76f));
        Operation withdrawalFirst = new Withdrawal(amount( 63.79f));
        Operation withdrawalSecond = new Withdrawal(amount( 265.28f));

        //WHEN
        withdrawalFirst.execute(account);
        withdrawalSecond.execute(account);
        String historique = account.history();

        //THEN
        assertThat(historique, is(historique(balance(54.69f),withdrawal(63.79f),withdrawal(265.28f))));

    }


    private String deposit(float deposit) {
        return LINE_BREAK + TypeOperation.DEPOSIT + "   " + SEPARATOR + LocalDate.now().toString() + SEPARATOR + deposit + MONEY;
    }

    private String withdrawal(float withdrawal) {
        return LINE_BREAK + TypeOperation.WITHDRAWAL + SEPARATOR + LocalDate.now().toString() + SEPARATOR + withdrawal + MONEY;
    }

    private float balance(float balance) {
        return balance;
    }

    private String historique(float balance, String ... lineHistorique) {
        String historique = "The balance " + balance + MONEY + LINE_BREAK +
                "operation " + SEPARATOR + "date      " + SEPARATOR +
                "amount";
        for (String line: lineHistorique) {
            historique += line.toString();
        }
        return historique;
    }
    private BigDecimal initialBalance(float initialBalance) {
        return new BigDecimal(String.valueOf(initialBalance));
    }
    private BigDecimal amount(float amount) {
        return new BigDecimal(String.valueOf(amount));
    }
}
