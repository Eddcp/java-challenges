package exercises;

import exercises.shapeareaproblem.ShapeAreaLinearSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShapeAreaSolutionTest {

    @InjectMocks
    ShapeAreaLinearSolution shapeAreaLinearSolution;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShapeAreaOfOne() {
        var result = shapeAreaLinearSolution.solution(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testShapeAreaOfThree() {
        var result = shapeAreaLinearSolution.solution(3);
        Assertions.assertEquals(13, result);
    }


}
