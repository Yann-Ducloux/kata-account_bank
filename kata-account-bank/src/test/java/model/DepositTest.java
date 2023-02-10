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
    Deposit deposit = new Deposit();

    //WHEN
    deposit.saveMoney(account,new BigDecimal(String.valueOf(907.23f)));

    //THEN
    assertThat(account, is(account(907.23f)));
  }
  @Test
  void MultipleDepositInAccountEmptyTest() {
    //GIVEN
    Account account = new Account(new BigDecimal(String.valueOf(0f)));
    Deposit deposit = new Deposit();

    //WHEN
    deposit.saveMoney(account,new BigDecimal(String.valueOf(146.18f)));
    deposit.saveMoney(account,new BigDecimal(String.valueOf(147.30f)));

    //THEN
    assertThat(account, is(account(293.48f)));
  }

  @Test
  void SingleDepositInAccountFillTest() {
    //GIVEN
    Account account = new Account(new BigDecimal(String.valueOf(393.12f)));
    Deposit deposit = new Deposit();

    //WHEN
    deposit.saveMoney(account, new BigDecimal(String.valueOf(80.00f)));

    //THEN
    assertThat(account, is(account(473.12f)));
  }
  @Test
  void MultipleDepositInAccountFillTest() {
    //GIVEN
    Account account = new Account(new BigDecimal(String.valueOf(182.91f)));
    Deposit deposit = new Deposit();

    //WHEN
    deposit.saveMoney(account, new BigDecimal(String.valueOf(62.07f)));
    deposit.saveMoney(account, new BigDecimal(String.valueOf(47.00f)));

    //THEN
    assertThat(account, is(account(291.98f)));
  }
  private Account account(float amount) {
    return new Account(new BigDecimal(String.valueOf(amount)));
  }
}