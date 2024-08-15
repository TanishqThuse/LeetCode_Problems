class Solution {
    public String removeOuterParentheses(String s) {
        //basically we are recognizing the pattern where :
        //count of '(' == count of ')' is our opening and cloing patter
        //we have to do s = substring(from start to n-1)

        int start=0;
        int n=s.length();
        String result = "";
        int countOpenBracket = 0;
        int countClosedBracket = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                countOpenBracket++;
            }
            else{
                countClosedBracket++;
            }

            if(countOpenBracket==countClosedBracket){
                result += s.substring(start+1, i);
                start = i+1;
                countOpenBracket=0;
                countClosedBracket=0;
            }
        }
        return result;
    }
}