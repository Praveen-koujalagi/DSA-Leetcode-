class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x<y){
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }
        int aCount = 0, bCount = 0, totalPoints = 0;
        for(int i=0;i<s.length();i++){
            char curChar = s.charAt(i);
            if(curChar == 'a'){
                aCount++;
            }
            else if(curChar == 'b'){
                if(aCount > 0){
                    aCount--;
                    totalPoints += x;
                }
                else{
                    bCount++;
                }
            }
            else{
                totalPoints += Math.min(aCount,bCount)*y;
                aCount = bCount = 0;
            }
        }
        totalPoints += Math.min(aCount,bCount)*y;
        return totalPoints;
    }
}