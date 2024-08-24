class Solution {
    public boolean areNumbersAscending(String s) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        
        // Iterate through the string
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // Check if the current character is a digit
            if (ch >= '0' && ch <= '9') {
                int num = 0;
                // Extract the entire number (handles multi-digit numbers)
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                list.add(num); // Add the extracted number to the list
            }
        }

        // Check if the numbers in the list are in strictly ascending order
        boolean flag = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}


// class Solution {

//     public boolean isAscending(List<Integer> list){
//         boolean flag = true;
//         for(int i=0; i<list.size(); i++){
//             for(int j=i+1; j<list.size(); j++){
//                 if(list.get(i) >= list.get(j)){
//                     flag=false;
//                     break;
//                 }
//             }
//         }
//         return flag;
//     }

//     public boolean isDigit(char ch){
//         if(ch>='0' && ch<='9'){
//             return true;
//         }
//         return false;
//     }

//     public int getNum(char ch, String s, int i){
//         String ans = "";
//         ans+=ch;
//         for(int j=i+1; j<s.length(); j++){
//             //here we are sure that s[i] == digit
//             //we just have to make sure the next rnge till when it still a digit
//             char ch1 = s.charAt(j);
//             if(ch1>='0' && ch1<='9'){
//                 ans += ch1;
//             }
//         }
//         return Integer.parseInt(ans);
//     }

//     public void AddElementsInList(List<Integer> list, String s, int n){
//         for(int i=0; i<n; i++){
//             char ch = s.charAt(i);
//             if(isDigit(ch)){
//                 int getNum = getNum(ch, s, n);
//                 list.add(getNum);
//             }
//         }
//     }

//     public boolean areNumbersAscending(String s) {
//         List<Integer> list = new ArrayList<>();
//         int n = s.length();
        
//         AddElementsInList(list, s, n);

//         return isAscending(list);

//     }
// }