package codesignalcontainer;

import exercises.codesignalcontainer.Container;
import exercises.codesignalcontainer.ContainerImpl;
import org.junit.jupiter.api.*;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContainerImplAdvancedTest {

    Container container;

    @BeforeEach
    public void setUp() {
        container = new ContainerImpl();
    }


    /**
     * Add 1, 2, 5, 7, 9 -> [1, 2, 5, 7, 9]
     * Median of [1, 2, 5, 7, 9] is 5
     * Add 3, 4 -> [1, 2, 3, 4, 5, 7, 9]
     * Median of [1, 2, 3, 4, 5, 7, 9] is 4
     */
    @Test
    @Order(1)
    public void test_01_simpleGetOddLength() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            container.add(1);
            container.add(2);
            container.add(5);
            container.add(7);
            container.add(9);
            Assertions.assertEquals(5, container.getMedian());
            container.add(3);
            container.add(4);
            Assertions.assertEquals(4, container.getMedian());
        });
    }

    /**
     * Add 30, 10 -> [10, 30]
     * Median of [10, 30] is 10
     * Add 12, 35 -> [10, 12, 30, 35]
     * Median of [10, 12, 30, 35] is 12
     * Double check of median
     * Add 11, 40, 100, 90 -> [10, 11, 12, 30, 35, 40, 90, 100]
     * Median of [10, 11, 12, 30, 35, 40, 90, 100] is 30
     */
    @Test
    @Order(2)
    public void test_02_simpleGetEvenLength() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            container.add(30);
            container.add(10);
            Assertions.assertEquals(10, container.getMedian());
            container.add(12);
            container.add(35);
            Assertions.assertEquals(12, container.getMedian());
            Assertions.assertEquals(12, container.getMedian());
            container.add(11);
            container.add(40);
            container.add(100);
            container.add(90);
            Assertions.assertEquals(30, container.getMedian());
        });
    }

    /**
     * Median of [] does not exist
     * Double check of median
     * Add 1 -> [1]
     * Median of [1] is 1
     * Add 3, 4, 2, 10, 30 -> [1, 2, 3, 4, 10, 30]
     * Median of [1, 2, 3, 4, 10, 30] is 3
     * Add 52, 53, 54, 55 -> [1, 2, 3, 4, 10, 30, 52, 53, 54, 55]
     * Median of [1, 2, 3, 4, 10, 30, 52, 53, 54, 55] is 10
     * Add 6, 7, 8, 9 -> [1, 2, 3, 4, 6, 7, 8, 9, 10, 30, 52, 53, 54, 55]
     * Median of [1, 2, 3, 4, 6, 7, 8, 9, 10, 30, 52, 53, 54, 55] is 8
     * Add 11 -> [1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 30, 52, 53, 54, 55]
     * Median of [1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 30, 52, 53, 54, 55] is 9
     */
    @Test
    @Order(3)
    public void test_03_simpleMixedAddAndGet() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Assertions.assertThrows(
                    RuntimeException.class,
                    () -> container.getMedian()
            );
            Assertions.assertThrows(
                    RuntimeException.class,
                    () -> container.getMedian()
            );
            container.add(1);
            Assertions.assertEquals(1, container.getMedian());
            container.add(3);
            container.add(4);
            container.add(2);
            container.add(10);
            container.add(30);
            Assertions.assertEquals(3, container.getMedian());
            container.add(52);
            container.add(53);
            container.add(54);
            container.add(55);
            Assertions.assertEquals(10, container.getMedian());
            container.add(6);
            container.add(7);
            container.add(8);
            container.add(9);
            Assertions.assertEquals(8, container.getMedian());
            container.add(11);
            Assertions.assertEquals(9, container.getMedian());
        });
    }

    /**
     * Add 1, 2, 3, 4, 5, 5, 5 -> [1, 2, 3, 4, 5, 5, 5]
     * Median of [1, 2, 3, 4, 5, 5, 5] is 4
     * Add 2 -> [1, 2, 2, 3, 4, 5, 5, 5]
     * Median of [1, 2, 2, 3, 4, 5, 5, 5] is 3
     * Add 3 -> [1, 2, 2, 3, 3, 4, 5, 5, 5]
     * Median of [1, 2, 2, 3, 3, 4, 5, 5, 5] is 3
     * Add 5, 5 -> [1, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5]
     * Median of [1, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5] is 4
     */
    @Test
    @Order(4)
    public void test_04_repetitions1() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            container.add(1);
            container.add(2);
            container.add(3);
            container.add(4);
            container.add(5);
            container.add(5);
            container.add(5);
            Assertions.assertEquals(4, container.getMedian());
            container.add(2);
            Assertions.assertEquals(3, container.getMedian());
            container.add(3);
            Assertions.assertEquals(3, container.getMedian());
            container.add(5);
            container.add(5);
            Assertions.assertEquals(4, container.getMedian());
        });
    }

    /**
     * Add 20 items of 42 -> [42] * 20
     * Median of [42] * 20 is 42
     * Add 0, 1, 2, ..., 29 -> [0, 1, ..., 29] + [42] * 20
     * Median of [0, 1, ..., 29] + [42] * 20 is 24
     * Add 50 items of 130 -> [0, 1, ..., 29] + [42] * 20 + [130] * 50
     * Median of [0, 1, ..., 29] + [42] * 20 + [130] * 50 is 42
     * Add 50 items of 170 -> [0, 1, ..., 29] + [42] * 20 +
     * [130] * 50 + [170] * 50
     * Median of [0, 1, ..., 29] + [42] * 20 + [130] * 50 + [170] * 50 is 130
     */
    @Test
    @Order(5)
    public void test_05_repetitions2() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            for (int i = 0; i < 20; ++i) {
                container.add(42);
            }
            Assertions.assertEquals(42, container.getMedian());
            for (int i = 0; i < 30; ++i) {
                container.add(i);
            }
            Assertions.assertEquals(24, container.getMedian());
            for (int i = 0; i < 50; ++i) {
                container.add(130);
            }
            Assertions.assertEquals(42, container.getMedian());
            for (int i = 0; i < 50; ++i) {
                container.add(170);
            }
            Assertions.assertEquals(130, container.getMedian());
        });
    }

    /**
     * Add 10, 20, 30 -> [10, 20, 30]
     * Delete 20 -> [10, 30]
     * Median of [10, 30] is 10
     * Add 5 -> [5, 10, 30]
     * Median of [5, 10, 30] is 10
     * Delete 30 -> [5, 10]
     * Median of [5, 10] is 5
     */
    @Test
    @Order(6)
    public void test_06_simpleDeletes1() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            container.add(10);
            container.add(20);
            container.add(30);
            Assertions.assertTrue(container.delete(20));
            Assertions.assertEquals(10, container.getMedian());
            container.add(5);
            Assertions.assertEquals(10, container.getMedian());
            Assertions.assertTrue(container.delete(30));
            Assertions.assertEquals(5, container.getMedian());
        });
    }

    /**
     * Median of [] does not exist
     * Delete 5 -> []
     * Median of [] does not exist
     * Delete 5 -> []
     * Add 5 -> [5]
     * Median of [5] is 5
     * Delete 5 -> []
     * Median of [] does not exist
     * Delete 5 -> []
     * Add 5, 4, 3 -> [3, 4, 5]
     * Median of [3, 4, 5] is 4
     * Delete 5 -> [3, 4]
     * Median of [3, 4] is 3
     * Delete 5 -> [3, 4]
     * Delete 3 -> [4]
     * Median of [4] is 4
     */
    @Test
    @Order(7)
    public void test_07_simpleDeletes2() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Assertions.assertThrows(
                    RuntimeException.class,
                    () -> container.getMedian()
            );
            Assertions.assertFalse(container.delete(5));
            Assertions.assertThrows(
                    RuntimeException.class,
                    () -> container.getMedian()
            );
            Assertions.assertFalse(container.delete(5));
            container.add(5);
            Assertions.assertEquals(5, container.getMedian());
            Assertions.assertTrue(container.delete(5));
            Assertions.assertThrows(
                    RuntimeException.class,
                    () -> container.getMedian()
            );
            Assertions.assertFalse(container.delete(5));
            container.add(5);
            container.add(4);
            container.add(3);
            Assertions.assertEquals(4, container.getMedian());
            Assertions.assertTrue(container.delete(5));
            Assertions.assertEquals(3, container.getMedian());
            Assertions.assertFalse(container.delete(5));
            Assertions.assertTrue(container.delete(3));
            Assertions.assertEquals(4, container.getMedian());
        });
    }

    /**
     * Add 3, 30, 30, 15 -> [3, 15, 30, 30]
     * Median of [3, 15, 30, 30] is 15
     * Delete 30 -> [3, 15, 30]
     * Median of [3, 15, 30] is 15
     * Delete 30 -> [3, 15]
     * Median of [3, 15] is 3
     * Add 30, 30, 30 -> [3, 15, 30, 30, 30]
     * Median of [3, 15, 30, 30, 30] is 30
     * Add 15 -> [3, 15, 15, 30, 30, 30]
     * Median of [3, 15, 15, 30, 30, 30] is 15
     * Delete 20 -> [3, 15, 15, 30, 30, 30]
     * Delete 3 -> [15, 15, 30, 30, 30]
     * Median of [15, 15, 30, 30, 30] is 30
     */
    @Test
    @Order(8)
    public void test_08_repetitionsAndDeletes() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            container.add(3);
            container.add(30);
            container.add(30);
            container.add(15);
            Assertions.assertEquals(15, container.getMedian());
            Assertions.assertTrue(container.delete(30));
            Assertions.assertEquals(15, container.getMedian());
            Assertions.assertTrue(container.delete(30));
            Assertions.assertEquals(3, container.getMedian());
            container.add(30);
            container.add(30);
            container.add(30);
            Assertions.assertEquals(30, container.getMedian());
            container.add(15);
            Assertions.assertEquals(15, container.getMedian());
            Assertions.assertFalse(container.delete(20));
            Assertions.assertTrue(container.delete(3));
            Assertions.assertEquals(30, container.getMedian());
        });
    }

    /**
     * Add 5, 3, 5, 7, 8, 9 -> [3, 5, 5, 7, 8, 9]
     * Median of [3, 5, 5, 7, 8, 9] is 5
     * Delete 5, 8 -> [3, 5, 7, 9]
     * Median of [3, 5, 7, 9] is 5
     * Delete 5, 5 -> [3, 7, 9]
     * Median of [3, 7, 9] is 7
     * Add 5 -> [3, 5, 7, 9]
     * Median of [3, 5, 7, 9] is 5
     * Delete 5, 5, 7, 3 -> [9]
     * Median of [9] is 9
     * Delete 9 -> []
     * Median of [] does not exist
     * Delete 9 -> []
     * Median of [] does not exist
     */
    @Test
    @Order(9)
    public void test_09_mixedOperations1() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            container.add(5);
            container.add(3);
            container.add(5);
            container.add(7);
            container.add(8);
            container.add(9);
            Assertions.assertEquals(5, container.getMedian());
            Assertions.assertTrue(container.delete(5));
            Assertions.assertTrue(container.delete(8));
            Assertions.assertEquals(5, container.getMedian());
            Assertions.assertTrue(container.delete(5));
            Assertions.assertFalse(container.delete(5));
            Assertions.assertEquals(7, container.getMedian());
            container.add(5);
            Assertions.assertEquals(5, container.getMedian());
            Assertions.assertTrue(container.delete(5));
            Assertions.assertFalse(container.delete(5));
            Assertions.assertTrue(container.delete(7));
            Assertions.assertTrue(container.delete(3));
            Assertions.assertEquals(9, container.getMedian());
            Assertions.assertTrue(container.delete(9));
            Assertions.assertThrows(
                    RuntimeException.class,
                    () -> container.getMedian()
            );
            Assertions.assertFalse(container.delete(9));
            Assertions.assertThrows(
                    RuntimeException.class,
                    () -> container.getMedian()
            );
        });
    }

    /**
     * Add 0, 0, 1, 1, 2, 2, ..., 99, 99 -> [0, 0, 1, 1, ..., 99, 99]
     * Median of [0, 0, 1, 1, ..., 99, 99] is 49
     * Delete 3 items of i, median is 50 + i / 2, i in [0, 1, ..., 49]
     * Container's integers are [50, 50, 51, 51, ..., 99, 99] now
     * Delete 0, 1, 2, ..., 99 -> [50, 51, ..., 99]
     * Median of [50, 51, ..., 99] is 74
     */
    @Test
    @Order(10)
    public void test_10_mixedOperations2() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            for (int i = 0; i < 100; ++i) {
                container.add(i);
                container.add(i);
            }
            Assertions.assertEquals(49, container.getMedian());
            int[] answers = {
                    50, 50, 51, 51, 52, 52, 53, 53, 54, 54, 55, 55, 56,
                    56, 57, 57, 58, 58, 59, 59, 60, 60, 61, 61, 62, 62,
                    63, 63, 64, 64, 65, 65, 66, 66, 67, 67, 68, 68, 69,
                    69, 70, 70, 71, 71, 72, 72, 73, 73, 74, 74
            };
            for (int i = 0; i < 50; ++i) {
                Assertions.assertTrue(container.delete(i));
                Assertions.assertTrue(container.delete(i));
                Assertions.assertFalse(container.delete(i));
                Assertions.assertEquals(answers[i], container.getMedian());
            }

            for (int i = 0; i < 100; ++i) {
                Assertions.assertEquals(container.delete(i), i >= 50);
            }
            Assertions.assertEquals(74, container.getMedian());
        });
    }
}
