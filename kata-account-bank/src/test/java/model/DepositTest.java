package model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DepositTest {
  @Test
  void SingleDepositInAccountEmptyTest() {
    //GIVEN
    Account account = new Account(0f);
    Deposit deposit = new Deposit();

    //WHEN
    deposit.saveMoney(account,907.23f);

    //THEN
    assertThat(account, is(account(907.23f)));
  }
  @Test
  void MultipleDepositInAccountEmptyTest() {
    //GIVEN
    Account account = new Account(0f);
    Deposit deposit = new Deposit();

    //WHEN
    deposit.saveMoney(account,146.19f);
    deposit.saveMoney(account,147.30f);

    //THEN
    assertThat(account, is(account(293.49f)));
  }

  @Test
  void SingleDepositInAccountFillTest() {
    //GIVEN
    Account account = new Account(393.12f);
    Deposit deposit = new Deposit();

    //WHEN
    deposit.saveMoney(account, 80.00f);

    //THEN
    assertThat(account, is(account(473.12f)));
  }
  @Test
  void MultipleDepositInAccountFillTest() {
    //GIVEN
    Account account = new Account(182.91f);
    Deposit deposit = new Deposit();

    //WHEN
    deposit.saveMoney(account, 62.07f);
    deposit.saveMoney(account, 47.00f);

    //THEN
    assertThat(account, is(account(291.98f)));
  }
  private Account account(float amount) {
    return new Account(amount);
  }
}