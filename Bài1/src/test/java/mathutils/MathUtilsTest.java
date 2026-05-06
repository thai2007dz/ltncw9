package mathutils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    void testFactorial() {
        assertEquals(120, MathUtils.factorial(5));
        assertEquals(1, MathUtils.factorial(0));
    }

    @Test
    void testNegativeFactorial() {
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.factorial(-1);
        });
    }
}