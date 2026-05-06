package vn.edu.vnu.uet.banksystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

/**
 * Lớp kiểm thử đường dẫn tệp tin tương thích đa hệ điều hành.
 */
public class FilePathTest {

  @Test
  void testCrossPlatformPath() {
    // TÁI CẤU TRÚC 1: Dùng thư viện Paths của Java
    // Thư viện này đủ thông minh để tự động chèn dấu \ nếu chạy trên Windows 
    // và dấu / nếu chạy trên Linux/macOS
    Path path = Paths.get("logs", "app.log");
    
    // TÁI CẤU TRÚC 2: Dùng biến môi trường File.separator thay vì viết cứng một dấu
    String expectedPath = "logs" + File.separator + "app.log";
    
    // So sánh: Bài test này sẽ Pass 100% trên mọi nền tảng
    assertEquals(expectedPath, path.toString(), "Đường dẫn phải tương thích đa hệ điều hành");
  }
}

//chạy CI/CD lần 2
