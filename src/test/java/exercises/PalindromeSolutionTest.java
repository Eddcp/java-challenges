package exercises;

import exercises.palindromeproblem.PalindromeLinearSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PalindromeSolutionTest {

    @InjectMocks
    PalindromeLinearSolution palindromeLinearSolution;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPalindrome() {
        String palindrome = "tenet";
        var result = palindromeLinearSolution.solution(palindrome);
        Assertions.assertTrue(result);
    }

}
