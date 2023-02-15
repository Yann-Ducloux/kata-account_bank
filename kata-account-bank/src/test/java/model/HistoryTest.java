package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HistoryTest {
    private static final String LINE_BREAK = System.getProperty("line.separator");
    private static final String MONEY = "€";
    private static final String SEPARATOR = " | ";

    @Test
    void SingleDepositTest() {
        //GIVEN
        Account account = new Account();
        Operation deposit = new Deposit(amount(907.23f));

        //WHEN
        deposit.execute(account);
        String history = account.history();

        //THEN
        assertThat(history, is(historique(balance(907.23f),deposit(907.23f))));
    }

    @Test
    void MultipleDepositTest() {
        //GIVEN
        Account account = new Account();
        Operation depositFirst = new Deposit(amount(146.18f));
        Operation depositSecond = new Deposit(amount(147.30f));

        //WHEN
        depositFirst.execute(account);
        depositSecond.execute(account);
        String history = account.history();

        //THEN
        assertThat(history, is(historique(balance(293.48f),deposit(146.18f), deposit(147.30f))));
    }
    @Test
    void SingleWithdrawalTest() {
        //GIVEN
        Account account = new Account();
        Operation deposit = new Deposit(amount(561.22f));
        Operation withdrawal = new Withdrawal(amount( 12.30f));

        //WHEN
        deposit.execute(account);
        withdrawal.execute(account);
        String history = account.history();

        //THEN
        assertThat(history, is(historique(balance(548.92f),
                deposit(561.22f),withdrawal(12.30f))));
    }
    @Test
    void MultipleWithdrawalTest() {
        //GIVEN
        Account account = new Account();
        Operation deposit = new Deposit(amount(383.76f));
        Operation withdrawalFirst = new Withdrawal(amount( 63.79f));
        Operation withdrawalSecond = new Withdrawal(amount( 265.28f));

        //WHEN
        deposit.execute(account);
        withdrawalFirst.execute(account);
        withdrawalSecond.execute(account);
        String history = account.history();

        //THEN
        assertThat(history, is(historique(balance(54.69f),deposit(383.76f),
                withdrawal(63.79f),withdrawal(265.28f))));

    }    @Test
    void MultipleDepositAndWithdrawalTest() {
        //GIVEN
        Account account = new Account();
        Operation depositInitial = new Deposit(amount(383.76f));
        Operation depositFirst = new Deposit(amount(146.18f));
        Operation withdrawalFirst = new Withdrawal(amount(63.79f));
        Operation depositSecond = new Deposit(amount(147.30f));
        Operation withdrawalSecond = new Withdrawal(amount(265.28f));

        //WHEN
        depositInitial.execute(account);
        depositFirst.execute(account);
        withdrawalFirst.execute(account);
        depositSecond.execute(account);
        withdrawalSecond.execute(account);
        String history = account.history();

        //THEN
        assertThat(history, is(historique(balance(348.17f),deposit(383.76f),
                deposit(146.18f),withdrawal(63.79f),
                deposit(147.30f), withdrawal(265.28f))));

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

    private Money amount(float amount) {
        return new Money(new BigDecimal(String.valueOf(amount)));
    }
}
