package exercises;

import exercises.adjacentelementproblem.AdjacentElementProductLinearSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdjacentElementProductSolutionTest {

    @InjectMocks
    AdjacentElementProductLinearSolution adjacentElementProductLinearSolution;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLargestProduct() {
        int[] array = {3, 6, -2, -5, 7, 3};
        var result = adjacentElementProductLinearSolution.solution(array);
        Assertions.assertEquals(21, result);
    }

}
