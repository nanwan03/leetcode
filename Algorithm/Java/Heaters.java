public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int index = 0;
        int rst = 0;
        for (int house : houses) {
            while (index < heaters.length - 1 && heaters[index] + heaters[index + 1] <= house * 2) {
                index++;
            }
            rst = Math.max(rst, Math.abs(heaters[index] - house));
        }
        
        return rst;
    }
}