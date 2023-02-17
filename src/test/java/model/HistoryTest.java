package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class HistoryTest {
    private static final String LINE_BREAK = System.getProperty("line.separator");

    @Test
    void SingleDepositTest() {
        //GIVEN
        Account account = new Account();
        deposit(amount(907.23f)).execute(account);

        //WHEN
        String history = account.history();

        //THEN
        assertThat(history,is(
                "The balance 907.23€" + LINE_BREAK +
                        "operation  | date       | amount" + LINE_BREAK +
                        "DEPOSIT    | " + LocalDate.now() +  " | 907.23€"));
    }

    @Test
    void MultipleDepositTest() {
        //GIVEN
        Account account = new Account();
        deposit(amount(146.18f)).execute(account);
        deposit(amount(147.30f)).execute(account);

        //WHEN
        String history = account.history();

        //THEN
        assertThat(history, is(
                "The balance 293.48€" + LINE_BREAK +
                        "operation  | date       | amount" + LINE_BREAK +
                        "DEPOSIT    | " + LocalDate.now()+ " | 146.18€" + LINE_BREAK +
                        "DEPOSIT    | " + LocalDate.now()+ " | 147.3€"));
    }
    @Test
    void SingleWithdrawalTest() {
        //GIVEN
        Account account = new Account();
        deposit(amount(561.22f)).execute(account);
        withdrawal(amount( 12.30f)).execute(account);

        //WHEN
        String history = account.history();

        //THEN
        assertThat(history, is(
                "The balance 548.92€" + LINE_BREAK +
                        "operation  | date       | amount" + LINE_BREAK +
                        "DEPOSIT    | " + LocalDate.now()+ " | 561.22€" + LINE_BREAK +
                        "WITHDRAWAL | " + LocalDate.now()+ " | 12.3€"));
    }
    @Test
    void MultipleWithdrawalTest() {
        //GIVEN
        Account account = new Account();
        deposit(amount(383.76f)).execute(account);
        withdrawal(amount(63.79f)).execute(account);
        withdrawal(amount( 265.28f)).execute(account);

        //WHEN
        String history = account.history();

        //THEN
        assertThat(history, is(
                "The balance 54.69€" + LINE_BREAK +
                        "operation  | date       | amount" + LINE_BREAK +
                        "DEPOSIT    | " + LocalDate.now()+ " | 383.76€" + LINE_BREAK +
                        "WITHDRAWAL | " + LocalDate.now()+ " | 63.79€" + LINE_BREAK +
                        "WITHDRAWAL | " + LocalDate.now()+ " | 265.28€"));
    }

    @Test
    void MultipleDepositAndWithdrawalTest() {
        //GIVEN
        Account account = new Account();
        deposit(amount(383.76f)).execute(account);
        deposit(amount(146.18f)).execute(account);
        withdrawal(amount(63.79f)).execute(account);
        deposit(amount(147.30f)).execute(account);
        withdrawal(amount(265.28f)).execute(account);

        //WHEN
        String history = account.history();

        //THEN
        assertThat(history, is(
                "The balance 348.17€" + LINE_BREAK +
                        "operation  | date       | amount" + LINE_BREAK +
                        "DEPOSIT    | " + LocalDate.now() + " | 383.76€" + LINE_BREAK +
                        "DEPOSIT    | " + LocalDate.now() + " | 146.18€" + LINE_BREAK +
                        "WITHDRAWAL | " + LocalDate.now() + " | 63.79€" + LINE_BREAK +
                        "DEPOSIT    | " + LocalDate.now() + " | 147.3€" + LINE_BREAK +
                        "WITHDRAWAL | " + LocalDate.now() + " | 265.28€"));
    }

    private Deposit deposit(Money amount) {
        return new Deposit(amount);
    }

    private Withdrawal withdrawal(Money amount) {
        return new Withdrawal(amount);
    }
    private Money amount(float amount) {
        return new Money(amount);
    }
}
