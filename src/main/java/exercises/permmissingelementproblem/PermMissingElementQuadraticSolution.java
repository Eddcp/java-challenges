package exercises.permmissingelementproblem;

import java.util.List;
import java.util.Objects;

public class PermMissingElementQuadraticSolution {

    public int solution(List<Integer> list) {
        int n = list.size();

        for (int i = 1; i < n + 1; i++) {
            if (isNumberNotOnList(list, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isNumberNotOnList(List<Integer> list, int number) {
        boolean found = false;
        var itemFound = list.stream().filter(item -> item.equals(number)).findFirst().orElse(null);
        return Objects.isNull(itemFound);
    }
}