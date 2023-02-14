package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class WithdrawalTest {
    @Test
    void SingleWithdrawalInAccountFillTest() {
        //GIVEN
        Account account = new Account(new BigDecimal(String.valueOf(561.22f)));
        Operation withdrawal = new Withdrawal(new BigDecimal(String.valueOf( 12.30f)));

        //WHEN
        withdrawal.saveMoney(account);

        //THEN
        assertThat(account, is(account(548.92f)));
    }
    @Test
    void MultipleWithdrawalInAccountFillTest() {
        //GIVEN
        Account account = new Account(new BigDecimal(String.valueOf(383.76f)));
        Operation withdrawalFirst = new Withdrawal(new BigDecimal(String.valueOf( 63.79f)));
        Operation withdrawalSecond = new Withdrawal(new BigDecimal(String.valueOf( 265.28f)));

        //WHEN
        withdrawalFirst.saveMoney(account);
        withdrawalSecond.saveMoney(account);

        //THEN
        assertThat(account, is(account(54.69f)));
    }
    private Account account(float amount) {
        return new Account(new BigDecimal(String.valueOf(amount)));
    }
}
