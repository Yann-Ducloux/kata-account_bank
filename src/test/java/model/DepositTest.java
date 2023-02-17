package model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DepositTest {
  @Test
  void SingleDepositTest() {
    //GIVEN
    Account account = new Account();

    //WHEN
    deposit(amount(907.23f)).execute(account);

    //THEN
    assertThat(account.balance(), is(amount(907.23f)));
  }

  @Test
  void MultipleDepositTest() {
    //GIVEN
    Account account = new Account();

    //WHEN
    deposit(amount(146.18f)).execute(account);
    deposit(amount(147.30f)).execute(account);

    //THEN
    assertThat(account.balance(), is(amount(293.48f)));
  }

  private Deposit deposit(Money amount) {
    return new Deposit(amount);
  }

  private Money amount(float amount) {
    return new Money(amount);
  }
}