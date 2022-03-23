package exercises.adjacentelementproblem;

public class AlmostIncreasingSequenceSolution {
    public boolean solution(int[] sequence) {
        if (sequence.length <= 2) {
            return true;
        }

        int count = 0;
        int i = 0;

        while (i < sequence.length - 1) {
            if (sequence[i] - sequence[i + 1] >= 0) {
                count++;
                boolean checkIndexOutOfBonds = i - 1 >= 0 && i + 2 <= sequence.length - 1;
                if (checkIndexOutOfBonds && sequence[i] - sequence[i + 2] >= 0 && sequence[i - 1] - sequence[i + 1] >= 0) {
                    return false;
                }
            }
            i++;
        }

        return count <= 1;
    }

}
