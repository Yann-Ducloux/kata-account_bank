package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class WithdrawalTest {
    @Test
    void SingleWithdrawalInAccountFillTest() {
        //GIVEN
        Account account = new Account(initialBalance(561.22f));
        Operation withdrawal = new Withdrawal(amount( 12.30f));

        //WHEN
        withdrawal.execute(account);

        //THEN
        assertThat(account, is(account(548.92f)));
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

        //THEN
        assertThat(account, is(account(54.69f)));
    }
    private Account account(float amount) {
        return new Account(new BigDecimal(String.valueOf(amount)));
    }

    private BigDecimal initialBalance(float initialBalance) {
        return new BigDecimal(String.valueOf(initialBalance));
    }
    private BigDecimal amount(float amount) {
        return new BigDecimal(String.valueOf(amount));
    }
}
