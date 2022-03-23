package exercises;

import exercises.intersectionproblem.IntersectionLogLinearSolution;
import exercises.intersectionproblem.IntersectionQuadraticSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntersectionSolutionTest {

    @InjectMocks
    IntersectionQuadraticSolution intersectionQuadraticSolution;

    @InjectMocks
    IntersectionLogLinearSolution intersectionLogLinearSolution;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListEmptyQuadraticSolution() {
        List<Integer> firstList = Collections.emptyList();
        List<Integer> secondList = Collections.emptyList();
        var result = intersectionQuadraticSolution.solution(firstList, secondList);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void testListQuadraticSolution() {
        List<Integer> firstList = Arrays.asList(3, 7, 2, 4, 1);
        List<Integer> secondList = Arrays.asList(5, 4, 2, 6, 8);
        List<Integer> intersectionList = Arrays.asList(2, 4);
        var result = intersectionQuadraticSolution.solution(firstList, secondList);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(result, intersectionList);
    }


    @Test
    void testListLogLinearSolution() {
        List<Integer> firstList = Arrays.asList(3, 7, 2, 4, 1);
        List<Integer> secondList = Arrays.asList(5, 4, 2, 6, 8);
        List<Integer> intersectionList = Arrays.asList(2, 4);
        var result = intersectionLogLinearSolution.solution(firstList, secondList);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(result, intersectionList);

    }

}
