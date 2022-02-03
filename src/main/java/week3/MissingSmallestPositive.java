package main.java.week3;

public class MissingSmallestPositive {

    /**
     * <H1>MISSING SMALLEST POSITIVE</H1>
     * <H2>Time Complexity: O(N)</H2>
     * <H2>Space Complexity: O(1)</H2>
     *
     * @param number collection of number in string
     * @return missing smallest positive number from a given set of numbers
     */
    public static int getMissingSmallestPositive(String number) {
        int length = number.length();
        if (length == 0) return 1;
        boolean hasOne = false;
        int[] comparator = new int[length];

        // parse all int into a int array
        for (int i = 0; i < length; i++) {
            comparator[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        // check for 1, negatives and overflows.
        for (int i = 0; i < length; i++) {
            if (comparator[i] == 1) hasOne = true;
            else if (comparator[i] <= 0 || comparator[i] > length) comparator[i] = 1;
        }
        // in the absence of 1 return 1
        if (!hasOne) return 1;

        for (int i = 0; i < length; i++) {
            // parse the index
            int index = Math.abs(comparator[i]) - 1;
            // inverse the number
            if (comparator[index] > 0) comparator[index] *= -1;
        }

        for (int i = 0; i < length; i++) {
            //return the non-negative
            if (comparator[i] > 0) return i + 1;
        }
        // else return last + 1
        return length + 1;
    }
}
