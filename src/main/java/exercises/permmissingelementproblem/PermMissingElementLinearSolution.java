package exercises.permmissingelementproblem;

import java.util.Comparator;
import java.util.List;

public class PermMissingElementLinearSolution {

    /* Linear solution but poor memory performance */
    public int solution(List<Integer> list) {
        int n = list.size();
        int sizeOfNewArray = n + 2;
        int[] newArray = new int[sizeOfNewArray];

        for (Integer index : list) {
            newArray[index] = index;
        }
        for (int i = 0; i < sizeOfNewArray; i++) {
            if (i != 0 && newArray[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    static class Sorting implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
}