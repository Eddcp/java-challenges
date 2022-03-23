package exercises.palindromeproblem;

public class PalindromeLinearSolution {
    public boolean solution(String inputString) {
        int i = 0;
        int length = inputString.length();
        while (i < length / 2) {
            if (inputString.charAt(i) != inputString.charAt(length - i - 1)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
