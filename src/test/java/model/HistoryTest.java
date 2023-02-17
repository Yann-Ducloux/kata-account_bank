package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HistoryTest {
    private static final String LINE_BREAK = System.getProperty("line.separator");

    @Test
    void SingleDepositTest() {
        //GIVEN
        Account account = new Account();
        Operation deposit = new Deposit(amount(907.23f));

        //WHEN
        deposit.execute(account);
        String history = account.history();

        //THEN
        assertThat(history,is(
                "The balance 907.23€" + LINE_BREAK +
                        "operation  | date       | amount" + LINE_BREAK +
                        TypeOperation.DEPOSIT + "    | " + LocalDate.now()+ " | 907.23€"));
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
        assertThat(history, is(
                "The balance 293.48€" + LINE_BREAK +
                        "operation  | date       | amount" + LINE_BREAK +
                        TypeOperation.DEPOSIT + "    | " + LocalDate.now()+ " | 146.18€" + LINE_BREAK +
                        TypeOperation.DEPOSIT + "    | " + LocalDate.now()+ " | 147.3€"));
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
        assertThat(history, is(
                "The balance 548.92€" + LINE_BREAK +
                        "operation  | date       | amount" + LINE_BREAK +
                        TypeOperation.DEPOSIT + "    | " + LocalDate.now()+ " | 561.22€" + LINE_BREAK +
                        TypeOperation.WITHDRAWAL + " | " + LocalDate.now()+ " | 12.3€"));
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
        assertThat(history, is(
                "The balance 54.69€" + LINE_BREAK +
                        "operation  | date       | amount" + LINE_BREAK +
                        TypeOperation.DEPOSIT + "    | " + LocalDate.now()+ " | 383.76€" + LINE_BREAK +
                        TypeOperation.WITHDRAWAL + " | " + LocalDate.now()+ " | 63.79€" + LINE_BREAK +
                        TypeOperation.WITHDRAWAL + " | " + LocalDate.now()+ " | 265.28€"));
    }

    @Test
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
        assertThat(history, is(
                "The balance 348.17€" + LINE_BREAK +
                        "operation  | date       | amount" + LINE_BREAK +
                        "DEPOSIT    | 2023-02-17 | 383.76€" + LINE_BREAK +
                        "DEPOSIT    | " + LocalDate.now() + " | 146.18€" + LINE_BREAK +
                        "WITHDRAWAL | " + LocalDate.now() + " | 63.79€" + LINE_BREAK +
                        "DEPOSIT    | " + LocalDate.now() + " | 147.3€" + LINE_BREAK +
                        "WITHDRAWAL | " + LocalDate.now() + " | 265.28€"));
    }


    private Money amount(float amount) {
        return new Money(amount);
    }
}
