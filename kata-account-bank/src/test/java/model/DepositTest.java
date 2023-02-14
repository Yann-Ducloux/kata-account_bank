package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DepositTest {
  @Test
  void SingleDepositInAccountEmptyTest() {
    //GIVEN
    Account account = new Account(initialBalance(0f));
    Operation deposit = new Deposit(amount(907.23f));

    //WHEN
    deposit.execute(account);

    //THEN
    assertThat(account, is(account(907.23f)));
  }
  @Test
  void MultipleDepositInAccountEmptyTest() {
    //GIVEN
    Account account = new Account(initialBalance(0f));
    Operation depositFirst = new Deposit(amount(146.18f));
    Operation depositSecond = new Deposit(amount(147.30f));

    //WHEN
    depositFirst.execute(account);
    depositSecond.execute(account);

    //THEN
    assertThat(account, is(account(293.48f)));
  }

  @Test
  void SingleDepositInAccountFillTest() {
    //GIVEN
    Account account = new Account(initialBalance(393.12f));
    Operation deposit = new Deposit(amount(80.00f));

    //WHEN
    deposit.execute(account);

    //THEN
    assertThat(account, is(account(473.12f)));
  }
  @Test
  void MultipleDepositInAccountFillTest() {
    //GIVEN
    Account account = new Account(initialBalance(182.91f));
    Operation depositFirst = new Deposit(amount(62.07f));
    Operation depositSecond = new Deposit(amount(47.00f));

    //WHEN
    depositFirst.execute(account);
    depositSecond.execute(account);

    //THEN
    assertThat(account, is(account(291.98f)));
  }
  private Account account(float amount) {
    return new Account(new Money(new BigDecimal(String.valueOf(amount))));
  }
  private Money initialBalance(float initialBalance) {
    return new Money(new BigDecimal(String.valueOf(initialBalance)));
  }
  private Money amount(float amount) {
    return new Money(new BigDecimal(String.valueOf(amount)));
  }
}