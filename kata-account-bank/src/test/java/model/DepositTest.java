package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DepositTest {
  @Test
  void SingleDepositTest() {
    //GIVEN
    Account account = new Account();
    Operation deposit = new Deposit(amount(907.23f));

    //WHEN
    deposit.execute(account);

    //THEN
    assertThat(account.calculateBalance(), is(amount(907.23f)));
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

    //THEN
    assertThat(account.calculateBalance(), is(amount(293.48f)));
  }

  private Money amount(float amount) {
    return new Money(amount);
  }
}