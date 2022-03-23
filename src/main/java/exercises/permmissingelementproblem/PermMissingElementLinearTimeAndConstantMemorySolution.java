package exercises.permmissingelementproblem;

import java.util.List;

public class PermMissingElementLinearTimeAndConstantMemorySolution {

    /* Linear solution but poor memory performance */
    public int solution(List<Integer> list) {
        int n = list.size();
        int totalSumFromOneToNSequence = 0;
        for (int i = 1; i <= n + 1; i++) {
            totalSumFromOneToNSequence += i;
        }

        int sumOfItemsOnList = 0;
        for (Integer itemValue : list) {
            sumOfItemsOnList += itemValue;
        }

        return totalSumFromOneToNSequence - sumOfItemsOnList;
    }
}