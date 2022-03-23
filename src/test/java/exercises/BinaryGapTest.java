package exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinaryGapTest {

    @InjectMocks
    BinaryGap binaryGap;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test_max_integer() {
        int result = binaryGap.solution(Integer.MAX_VALUE);
        Assertions.assertEquals(0, result);
    }

    @Test
    void test_power_of_two() {
        int result = binaryGap.solution(1024);
        Assertions.assertEquals(0, result);
        int nextResult = binaryGap.solution(16);
        Assertions.assertEquals(0, nextResult);
    }

    @Test
    void sample_tests() {
        int example1 = binaryGap.solution(1041);
        Assertions.assertEquals(5, example1);
        int example2 = binaryGap.solution(15);
        Assertions.assertEquals(0, example2);
        int example3 = binaryGap.solution(32);
        Assertions.assertEquals(0, example3);
        int example4 = binaryGap.solution(42);
        Assertions.assertEquals(1, example4);
        int example5 = binaryGap.solution(1073741825);
        Assertions.assertEquals(29, example5);
    }
    @Test
    void medium() {
        int example1 = binaryGap.solution(1162);
        Assertions.assertEquals(3, example1);
        int example2 = binaryGap.solution(51712);
        Assertions.assertEquals(2, example2);
    }

}
