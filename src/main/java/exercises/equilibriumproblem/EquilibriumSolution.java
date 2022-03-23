package exercises.equilibriumproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EquilibriumSolution {
    public int solution(List<Integer> list) {
        var absoluteValuesList = new ArrayList<Integer>();
        var pivot = 1;
        var listSize = list.size();

        /* O(n^2) */
        while (pivot < listSize) {
            var leftSum = 0;
            for (int i = 0; i < pivot; i++) {
                leftSum += list.get(i);
            }
            var rightSum = 0;
            for (int j = pivot; j < listSize; j++) {
                rightSum += list.get(j);
            }

            var absoluteValue = Math.abs(leftSum - rightSum);
            absoluteValuesList.add(absoluteValue);
            pivot++;
        }

        /* O (n logn n) */
        var sortedList = getSortedList(absoluteValuesList);
        return Objects.nonNull(sortedList) && !sortedList.isEmpty() ? sortedList.get(0) : 0;

    }

    /* O (n log n) */
    private List<Integer> getSortedList(List<Integer> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

}
