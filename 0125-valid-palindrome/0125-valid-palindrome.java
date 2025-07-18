class Solution {
    public boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (str.equals(new StringBuilder(str).reverse().toString())) {
            return true;
        }
        return false;


    }
}