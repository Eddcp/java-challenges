package exercises;

import exercises.equilibriumproblem.EquilibriumLinearSolution;
import exercises.equilibriumproblem.EquilibriumSolution;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EquilibriumTest {

    @InjectMocks
    EquilibriumSolution equilibriumSolution;

    @InjectMocks
    EquilibriumLinearSolution equilibriumLinearSolution;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEquilibriumEmptyList() {
        List<Integer> list = Collections.emptyList();
        var result = equilibriumSolution.solution(list);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testEquilibrium() {
        List<Integer> list = Arrays.asList(3, 1, 2, 4, 3);
        var result = equilibriumSolution.solution(list);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testEquilibriumBigList() {
        List<Integer> list = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
        long startTime = System.currentTimeMillis();
        var result = equilibriumSolution.solution(list);
        long estimatedTime = System.currentTimeMillis() - startTime;
        MatcherAssert.assertThat(estimatedTime, greaterThan(200L));
    }

    @Test
    void testEquilibriumBigListOnLinearSolution() {
        List<Integer> list = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
        long startTime = System.currentTimeMillis();
        var result = equilibriumLinearSolution.solution(list);
        long estimatedTime = System.currentTimeMillis() - startTime;
        MatcherAssert.assertThat(estimatedTime, lessThan(100L));
    }


}
