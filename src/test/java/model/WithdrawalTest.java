package model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class WithdrawalTest {
    @Test
    void SingleWithdrawalTest() {
        //GIVEN
        Account account = new Account();
        deposit(amount(561.22f)).execute(account);

        //WHEN
        withdrawal(amount( 12.30f)).execute(account);

        //THEN
        assertThat(account.balance(), is(amount(548.92f)));
    }
    @Test
    void MultipleWithdrawalTest() {
        //GIVEN
        Account account = new Account();
        deposit(amount(383.76f)).execute(account);

        //WHEN
        withdrawal(amount( 63.79f)).execute(account);
        withdrawal(amount( 265.28f)).execute(account);

        //THEN
        assertThat(account.balance(), is(amount(54.69f)));
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
