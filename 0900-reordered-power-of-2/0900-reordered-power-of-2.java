import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);
        
        for (int i = 0; i < 31; i++) { // 2^0 to 2^30 fits in int
            int pow = 1 << i; // 2^i
            if (target.equals(sortDigits(pow))) {
                return true;
            }
        }
        return false;
    }

    private String sortDigits(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
