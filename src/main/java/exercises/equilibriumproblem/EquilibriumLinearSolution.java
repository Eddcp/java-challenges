package exercises.equilibriumproblem;

import java.util.List;

public class EquilibriumLinearSolution {
    public int solution(List<Integer> list) {
        var pivot = 1;
        var listSize = list.size();
        var minimum = Integer.MAX_VALUE;
        var leftSum = list.get(0);
        var rightSum = 0;

        /* O(n) */
        for (int i = pivot; i < listSize; i++) {
            rightSum += list.get(i);
        }

        /* O(n) */
        while (pivot < listSize) {
            var absoluteValue = Math.abs(leftSum - rightSum);
            if (absoluteValue < minimum) {
                minimum = absoluteValue;
            }

            leftSum += list.get(pivot);
            rightSum -= list.get(pivot);

            pivot++;
        }

        return minimum;

    }

}
