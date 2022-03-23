package exercises;

import exercises.permmissingelementproblem.PermMissingElementLinearSolution;
import exercises.permmissingelementproblem.PermMissingElementLinearTimeAndConstantMemorySolution;
import exercises.permmissingelementproblem.PermMissingElementQuadraticSolution;
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
class PermMissingElementTest {

    @InjectMocks
    PermMissingElementQuadraticSolution permMissingElement;

    @InjectMocks
    PermMissingElementLinearSolution permMissingElementLinearSolution;

    @InjectMocks
    PermMissingElementLinearTimeAndConstantMemorySolution permMissingElementLinearTimeAndConstantMemorySolution;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPermMissingElementEmptyArray() {
        List<Integer> list = Collections.emptyList();
        var result = permMissingElement.solution(list);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testPermMissingElement() {
        List<Integer> list = Arrays.asList(1, 2, 5, 6, 7, 4);
        var result = permMissingElement.solution(list);
        Assertions.assertEquals(3, result);
    }

    @Test
    void testPermMissingElementLinearSolution() {
        List<Integer> list = Arrays.asList(2, 3, 1, 5);
        var result = permMissingElementLinearSolution.solution(list);
        Assertions.assertEquals(4, result);
    }

    @Test
    void testPermMissingElementLinearTimeAndConstantMemorySolution() {
        List<Integer> list = Arrays.asList(2, 3, 1, 5);
        var result = permMissingElementLinearTimeAndConstantMemorySolution.solution(list);
        Assertions.assertEquals(4, result);
    }


}
