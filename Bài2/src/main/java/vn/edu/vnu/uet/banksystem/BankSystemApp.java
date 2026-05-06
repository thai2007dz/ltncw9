package vn.edu.vnu.uet.banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp chính để chạy mô phỏng ứng dụng hệ thống ngân hàng.
 */
public class BankSystemApp {

  private static final Logger logger = LoggerFactory.getLogger(BankSystemApp.class);

  /**
   * Hàm main để khởi chạy ứng dụng.
   *
   * @param args Tham số dòng lệnh.
   */
  public static void main(String[] args) {
    logger.info("Hệ thống ngân hàng đang khởi động...");

    try {
      BankAccount account = new BankAccount("ACC12345", 5000.0);
      
      account.deposit(2000.0); // Test nạp tiền
      account.withdraw(1500.0); // Test rút tiền hợp lệ

      // Cố tình rút quá số dư để test cảnh báo (WARN) và lỗi (ERROR)
      account.withdraw(10000.0);

    } catch (IllegalArgumentException e) {
      logger.error("Lỗi hệ thống: Xảy ra ngoại lệ trong quá trình giao dịch - {}", 
          e.getMessage());
    }

    logger.info("Hệ thống ngân hàng đã tắt.");
  }
}

// nhớ dùng mvn checkstyle:check