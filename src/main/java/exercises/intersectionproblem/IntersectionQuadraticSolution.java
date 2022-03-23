package exercises.intersectionproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IntersectionQuadraticSolution {
    public List<Integer> solution(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> resultList = new ArrayList<>();

        firstList.forEach(item -> secondList.forEach(
                secondItem -> {
                    if (Objects.equals(item, secondItem)) {
                        resultList.add(item);
                    }
                }
        ));


        return resultList;
    }
}
