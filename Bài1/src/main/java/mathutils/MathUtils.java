package mathutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {
    // Thay thế System.out bằng Logger
    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public static long factorial(int n) {
        if (n < 0) {
            logger.error("Lỗi: Không thể tính giai thừa cho số âm ({})", n);
            throw new IllegalArgumentException("Số phải >= 0");
        }
        logger.info("Đang tính giai thừa cho số: {}", n);
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        logger.info("Ứng dụng MathUtils đã khởi động.");
        System.out.println("Giai thừa của 5 là: " + factorial(5));
    }
}