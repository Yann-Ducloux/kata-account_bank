package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class WithdrawalTest {
    @Test
    void SingleWithdrawalInAccountEmptyTest() {
        //GIVEN
        Account account = new Account(new BigDecimal(String.valueOf(0f)));
        Withdrawal withdrawal = new Withdrawal();

        //WHEN
        withdrawal.saveMoney(account,new BigDecimal(String.valueOf(893.46f)));

        //THEN
        assertThat(account, is(account(-893.46f)));
    }
    @Test
    void MultipleWithdrawalInAccountEmptyTest() {
        //GIVEN
        Account account = new Account(new BigDecimal(String.valueOf(0f)));
        Withdrawal withdrawal = new Withdrawal();

        //WHEN
        withdrawal.saveMoney(account,new BigDecimal(String.valueOf(308.50f)));
        withdrawal.saveMoney(account,new BigDecimal(String.valueOf(972.30f)));

        //THEN
        assertThat(account, is(account(-1280.80f)));
    }

    @Test
    void SingleWithdrawalInAccountFillTest() {
        //GIVEN
        Account account = new Account(new BigDecimal(String.valueOf(561.22f)));
        Withdrawal withdrawal = new Withdrawal();

        //WHEN
        withdrawal.saveMoney(account,new BigDecimal(String.valueOf( 12.30f)));

        //THEN
        assertThat(account, is(account(548.92f)));
    }
    @Test
    void MultipleWithdrawalInAccountFillTest() {
        //GIVEN
        Account account = new Account(new BigDecimal(String.valueOf(383.76f)));
        Withdrawal withdrawal = new Withdrawal();

        //WHEN
        withdrawal.saveMoney(account,new BigDecimal(String.valueOf( 403.79f)));
        withdrawal.saveMoney(account,new BigDecimal(String.valueOf( 465.28f)));

        //THEN
        assertThat(account, is(account(-485.31f)));
    }
    private Account account(float amount) {
        return new Account(new BigDecimal(String.valueOf(amount)));
    }
}
