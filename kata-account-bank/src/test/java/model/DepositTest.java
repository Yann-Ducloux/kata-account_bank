package model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DepositTest {
  @Test
  void SingleDepositInAccountEmptyTest() {
    //GIVEN
    Account account = new Account(new BigDecimal(String.valueOf(0f)));
    Operation deposit = new Deposit(new BigDecimal(String.valueOf(907.23f)));

    //WHEN
    deposit.saveMoney(account);

    //THEN
    assertThat(account, is(account(907.23f)));
  }
  @Test
  void MultipleDepositInAccountEmptyTest() {
    //GIVEN
    Account account = new Account(new BigDecimal(String.valueOf(0f)));
    Operation depositFirst = new Deposit(new BigDecimal(String.valueOf(146.18f)));
    Operation depositSecond = new Deposit(new BigDecimal(String.valueOf(147.30f)));

    //WHEN
    depositFirst.saveMoney(account);
    depositSecond.saveMoney(account);

    //THEN
    assertThat(account, is(account(293.48f)));
  }

  @Test
  void SingleDepositInAccountFillTest() {
    //GIVEN
    Account account = new Account(new BigDecimal(String.valueOf(393.12f)));
    Operation deposit = new Deposit(new BigDecimal(String.valueOf(80.00f)));

    //WHEN
    deposit.saveMoney(account);

    //THEN
    assertThat(account, is(account(473.12f)));
  }
  @Test
  void MultipleDepositInAccountFillTest() {
    //GIVEN
    Account account = new Account(new BigDecimal(String.valueOf(182.91f)));
    Operation depositFirst = new Deposit(new BigDecimal(String.valueOf(62.07f)));
    Operation depositSecond = new Deposit(new BigDecimal(String.valueOf(47.00f)));

    //WHEN
    depositFirst.saveMoney(account);
    depositSecond.saveMoney(account);

    //THEN
    assertThat(account, is(account(291.98f)));
  }
  private Account account(float amount) {
    return new Account(new BigDecimal(String.valueOf(amount)));
  }
}