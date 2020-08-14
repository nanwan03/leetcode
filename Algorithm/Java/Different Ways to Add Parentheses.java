public class Solution {
     public List<Integer> diffWaysToCompute(String input) {
        Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
        return helper(input,map);
    }
    private static List<Integer> helper(String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        String operator = "+-*";
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); ++i) {
            if (operator.indexOf(input.charAt(i)) != -1) {
                List<Integer> left = helper(input.substring(0, i), map);
                List<Integer> right = helper(input.substring(i + 1), map);
                for (int l : left) {
                    for (int r : right) {
                        list.add(cal(l, r, input.charAt(i)));
                    }
                }
            }
        }
        if (list.size() == 0 && input.length() != 0) {
            list.add(Integer.parseInt(input));
        }
        map.put(input, list);
        return list;
    }
    private static int cal(int left, int right, char operator) {
        if (operator == '+') {
            return left + right;
        } else if (operator == '-') {
            return left - right;
        } else {
            return left * right;
        }
    }
}