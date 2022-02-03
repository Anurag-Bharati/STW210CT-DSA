package main.java.week1;

import java.util.ArrayList;
import java.util.List;

public class EvalExpression {
    
    public List<String> getExpression(List<Integer> integerList, int k) {
        List<String> result = new ArrayList<>();
        evaluate(integerList, "", k, 0, 0, 0, result);
        return result;
    }

    /**
     * <H1>RECURSIVE DFS APPROACH</H1>
     * <H2>Time Complexity: O(4^N)</H2>
     * <H2>Space Complexity: O(N)</H2>
     * @param integerList - list of integer
     * @param path - expression path that is generated so far
     * @param k - target value
     * @param position - keeps tracks of index
     * @param initialResult - individual result so far
     * @param prevNum - prev num
     * @param result - a list of string containing all possible solution
     */
    private void evaluate(List<Integer> integerList, String path,
                          int k, int position, int initialResult,
                          int prevNum, List<String> result) {
        
        // add when complete
        if (position == integerList.size()) {
            if (initialResult == k)
                result.add(path);
        }
        for (int i = position; i < integerList.size(); i++) {
            // Base case
            if (i != position && integerList.get(position) == '0') break;
            int current = integerList.get(position);
            // initially no evaluation
            if (position == 0) {
                evaluate(integerList, path + current, k, i + 1, current, current, result);
            } else {
                // Addition
                evaluate(integerList, path + "+" + current, k, i + 1, initialResult + current, +current, result);
                // Subtraction
                evaluate(integerList, path + "-" + current, k, i + 1, initialResult - current, -current, result);
                // Multiplication
                evaluate(integerList, path + "*" + current, k, i + 1, initialResult - prevNum + prevNum * current, prevNum * current, result);
            }
        }
    }
}

