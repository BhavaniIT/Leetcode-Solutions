class Solution {
    List<String> validIPs = new ArrayList<>();
    List<String> currSegment = new ArrayList<>();
    String input;
    int len;
    public List<String> restoreIpAddresses(String s) {
        input = s;
        len = s.length();
        validateByDfs(0);
        return validIPs;
    }

    private void validateByDfs(int index){
        if(index >= len && currSegment.size() == 4){
            validIPs.add(String.join(".",currSegment));
            return;
        }
        
        if(index >= len || currSegment.size() == 4) return;

        int segmentValue = 0;

        for(int i = index; i<Math.min(index+3, len); ++i){
            segmentValue = segmentValue * 10 + input.charAt(i) - '0';

            if(segmentValue > 255 || (input.charAt(index) == '0' && i != index)) break;

            currSegment.add(input.substring(index, i+1));
            validateByDfs(i+1);
            currSegment.remove(currSegment.size()-1);
        } 

    }
}