package vn.edu.vnu.uet.banksystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Lớp kiểm thử (Unit Test) cho các nghiệp vụ của BankAccount.
 */
public class BankAccountTest {

  @Test
  void testDepositValidAmount() {
    BankAccount account = new BankAccount("ACC001", 1000.0);
    account.deposit(500.0);
    // Kiểm tra xem số dư có đúng là 1500 sau khi nạp 500 không
    assertEquals(1500.0, account.getBalance(), "Số dư phải là 1500 sau khi nạp 500");
  }

  @Test
  void testDepositInvalidAmount() {
    BankAccount account = new BankAccount("ACC002", 1000.0);
    // Kiểm tra xem hệ thống có ném ra lỗi khi nạp tiền âm không
    assertThrows(IllegalArgumentException.class, () -> {
      account.deposit(-200.0);
    });
  }

  @Test
  void testWithdrawValidAmount() {
    BankAccount account = new BankAccount("ACC003", 2000.0);
    account.withdraw(500.0);
    // Kiểm tra xem số dư có đúng là 1500 sau khi rút 500 không
    assertEquals(1500.0, account.getBalance(), "Số dư phải là 1500 sau khi rút 500");
  }

  @Test
  void testWithdrawInvalidAmount() {
    BankAccount account = new BankAccount("ACC004", 1000.0);
    // Kiểm tra xem hệ thống có chặn rút tiền âm không
    assertThrows(IllegalArgumentException.class, () -> {
      account.withdraw(-100.0);
    });
  }

  @Test
  void testWithdrawInsufficientBalance() {
    BankAccount account = new BankAccount("ACC005", 1000.0);
    // Kiểm tra xem hệ thống có chặn rút lố số dư không (có 1000 nhưng rút 2000)
    assertThrows(IllegalArgumentException.class, () -> {
      account.withdraw(2000.0);
    });
  }
}