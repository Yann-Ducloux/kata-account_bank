package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class WithdrawalTest {
    @Test
    void SingleWithdrawalTest() {
        //GIVEN
        Account account = new Account();
        Operation deposit = new Deposit(amount(561.22f));
        Operation withdrawal = new Withdrawal(amount( 12.30f));

        //WHEN
        deposit.execute(account);
        withdrawal.execute(account);

        //THEN
        assertThat(account.calculateBalance(), is(amount(548.92f)));
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

        //THEN
        assertThat(account.calculateBalance(), is(amount(54.69f)));
    }

    private Money amount(float amount) {
        return new Money(amount);
    }
}
