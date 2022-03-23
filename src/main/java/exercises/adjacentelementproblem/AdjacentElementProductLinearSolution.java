package exercises.adjacentelementproblem;

public class AdjacentElementProductLinearSolution {
    public int solution(int[] inputArray) {
        int i = 0;
        int length = inputArray.length;
        int largestProduct = Integer.MIN_VALUE;

        while (i < length - 1) {
            int product = inputArray[i] * inputArray[i + 1];
            if (largestProduct < product) {
                largestProduct = product;
            }

            i++;
        }

        return largestProduct;
    }

}
