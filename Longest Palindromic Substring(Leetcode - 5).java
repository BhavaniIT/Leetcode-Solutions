class Solution {
    private int resultStart;
    private int resultLength;
    public String longestPalindrome(String s) {
        int strLen = s.length();
        if(strLen < 2) return s;

        for(int i=0; i<strLen; ++i){
            expandRange(s, i, i);
            expandRange(s, i, i+1);
        }

        return s.substring(resultStart, resultStart+resultLength);
    }
    private void expandRange(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }

        if(resultLength < end-start-1){
            resultStart = start+1;
            resultLength = end-start-1;
        }
    }
}