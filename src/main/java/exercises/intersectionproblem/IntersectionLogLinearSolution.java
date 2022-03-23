package exercises.intersectionproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionLogLinearSolution {

    public List<Integer> solution(List<Integer> firstList, List<Integer> secondList) {

        var sortedFirstList = firstList.stream().sorted().collect(Collectors.toList());
        var sortedSecondList = secondList.stream().sorted().collect(Collectors.toList());

        return processIntersection(sortedFirstList, sortedSecondList);
    }

    private List<Integer> processIntersection(List<Integer> firstList, List<Integer> secondList) {
        var firstPointer = 0;
        var secondPointer = 0;

        List<Integer> resultList = new ArrayList<>();
        while (firstPointer < firstList.size() && secondPointer < secondList.size()) {
            if (firstList.get(firstPointer) < secondList.get(secondPointer)) {
                firstPointer++;
            } else if (firstList.get(firstPointer) > secondList.get(secondPointer)) {
                secondPointer++;
            } else {
                resultList.add(firstList.get(firstPointer));
                firstPointer++;
                secondPointer++;
            }
        }
        return resultList;
    }
}
