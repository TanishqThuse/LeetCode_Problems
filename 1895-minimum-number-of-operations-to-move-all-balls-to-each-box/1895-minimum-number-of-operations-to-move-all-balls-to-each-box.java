class Solution {
    public int[] minOperations(String boxes) {
        int n= boxes.length();
        int[] answer = new int[n];

        for(int currBox = 0; currBox < boxes.length(); currBox++){
            if(boxes.charAt(currBox) == '1'){
                for(
                    int newPos = 0;
                    newPos < boxes.length();
                    newPos++
                )
                {
                    answer[newPos] += Math.abs(newPos - currBox);
                }
            }
        }
        return answer;        
    }
}