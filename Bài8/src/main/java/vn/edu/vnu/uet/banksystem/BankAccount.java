package vn.edu.vnu.uet.banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp đại diện cho tài khoản ngân hàng của người dùng.
 * Quản lý các nghiệp vụ nạp tiền, rút tiền và ghi log trạng thái.
 */
public class BankAccount {

  private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

  private final String accountId;
  private double balance;

  /**
   * Khởi tạo tài khoản ngân hàng mới.
   *
   * @param accountId Mã tài khoản.
   * @param initialBalance Số dư ban đầu.
   */
  public BankAccount(String accountId, double initialBalance) {
    this.accountId = accountId;
    this.balance = initialBalance;
    logger.info("Khởi tạo tài khoản accountId={} với số dư ban đầu={}", accountId, initialBalance);
  }

  /**
   * Thực hiện nạp tiền vào tài khoản.
   *
   * @param amount Số tiền cần nạp.
   */
  public void deposit(double amount) {
    if (amount <= 0) {
      logger.warn("Giao dịch nạp tiền bị từ chối (accountId={}): Số tiền ({}) <= 0",
          accountId, amount);
      throw new IllegalArgumentException("Số tiền nạp phải lớn hơn 0");
    }
    balance += amount;
    logger.info("Nạp tiền thành công (accountId={}). Số tiền: {}. Số dư mới: {}",
        accountId, amount, balance);
  }

  /**
   * Thực hiện rút tiền khỏi tài khoản.
   *
   * @param amount Số tiền cần rút.
   */
  public void withdraw(double amount) {
    if (amount <= 0) {
      logger.warn("Giao dịch rút tiền bị từ chối (accountId={}): Số tiền ({}) <= 0",
          accountId, amount);
      throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0");
    }
    if (amount > balance) {
      logger.warn("Giao dịch rút tiền bị từ chối (accountId={}): Số dư ({}) không đủ rút ({})",
          accountId, balance, amount);
      throw new IllegalArgumentException("Số dư không đủ");
    }
    balance -= amount;
    logger.info("Rút tiền thành công (accountId={}). Số tiền: {}. Số dư mới: {}",
        accountId, amount, balance);
  }

  /**
   * Lấy số dư hiện tại của tài khoản.
   *
   * @return Số dư tài khoản.
   */
  public double getBalance() {
    return balance;
  }
}