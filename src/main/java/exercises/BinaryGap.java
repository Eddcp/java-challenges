package exercises;

public class BinaryGap {

    public int solution(int N) {
        String binaryInteger = Integer.toBinaryString(N);
        String [] parts = binaryInteger.replaceAll("0+$", "").split("1");

        int greatest = 0;
        for (String part : parts) {
            if (part.length() > 0 && part.length() > greatest) {
                greatest = part.length();
            }
        }
        return greatest;
    }
}
