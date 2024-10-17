class Solution {
    public int maximumSwap(int num) {
        // hashmap will hold right most indecies of each value
        HashMap<Integer, Integer> rightMost = new HashMap<>();
        StringBuilder s = new StringBuilder(String.valueOf(num));
        // place the right most indecies in our map
        for(int i = 0; i < s.length(); i++) {
            rightMost.put(Character.getNumericValue(s.charAt(i)), i);
        }
        // left is the pointer to where we are in our input parameter
        int left = 0;
        while(left < s.length()) {
            int leftval = Character.getNumericValue(s.charAt(left));
            int index = 9;
            // find the right most value present that is larger then the given value
            while(index > leftval) {
                // if found, swap the values
                if(rightMost.containsKey(index) && rightMost.get(index) > left) {
                    s.setCharAt(left, (char)(index + '0'));
                    s.setCharAt(rightMost.get(index), (char)(leftval + '0'));
                    return Integer.valueOf(s.toString());
                }
                index--;
            }
            left++;
        }

        return num;
    }
}

//so many tries

// //String builder is mutable by this exmaple i have changed its value at several places
// class Solution {
//     public int maximumSwap(int num) {
//         // Convert the number to StringBuilder for easy modification
//         StringBuilder sb = new StringBuilder(String.valueOf(num));
//         boolean flag = false;
//         for (int i = 0; i < sb.length(); i++) {
//             char ch = sb.charAt(i);
//             char max = ch;
//             int maxIdx = i;
//             for (int j = i + 1; j < sb.length(); j++) {
//                 char curr = sb.charAt(j);
                
//                 // Perform the swap if a larger digit is found
//                 if (ch < curr) {
//                     // Swap characters at positions i and j
//                     // sb.setCharAt(i, curr);  // Set i-th character to curr
//                     // sb.setCharAt(j, ch);    // Set j-th character to ch
//                     // flag = true;
//                     // max = Math.max((int)max, (int)curr);
//                     if(curr > max){
//                         max = curr;
//                         maxIdx = j;
//                     }
//                 }
//                 // else if(ch )


//                 // if(flag){
//                 //     break;
//                 // }
//             }
//             if(max != ch){
//                 // Swap characters at positions i and j
//                 sb.setCharAt(i, max);  // Set i-th character to curr
//                 sb.setCharAt(maxIdx, ch);    // Set j-th character to ch
//                 flag = true;
//             }
//             if(flag){
//                 break;
//             }
//         }

//         // Convert StringBuilder back to an integer
//         return Integer.parseInt(sb.toString());
//     }
// }


// // //New lesson :: Srings in java are mutabble so i cant use
// // //s.cahrAt(i) = ch ;  or somethign
// // //so i used string builder above

// // class Solution{
// //     public int maximumSwap(int num){
// //         //brute force
// //         // String s = num.toString();
// //         //above is wrong
// //         String s = String.valueOf(num);
// //         String str = s;
// //         for(int i=0; i<s.length(); i++){
// //             char ch = s.charAt(i);
// //             for(int j=i+1; j<s.length(); j++){
// //                 char curr = s.charAt(j);
// //                 if(ch < curr){
// //                     if(i>0)
// //                     str = s.substring(0,i-1);
// //                     str += curr;
// //                     str += s.substring(i+1,j);
// //                     str += ch;
// //                     str += s.substring(j); 
                    
// //                     //i am not sure why i cant do this
// //                     // s.charAt(i) = curr;
// //                     // s.charAt(j) = ch;
// //                     break;
// //                 }
// //             }
// //         }
// //         int numss = Integer.parseInt(str);
// //         return numss;
// //     }
// // }


// // // //Didn'y read question properly wasted 6 min og code
// // // // class Solution {
// // // //     public int maximumSwap(int num) {
// // // //         List<Integer> list = new ArrayList<>();
// // // //         int n = num;
// // // //         while(num > 0){
// // // //             int digit = num % 10;
// // // //             list.add(digit);
// // // //             num /= 10;
// // // //         }

// // // //         //now simply sort the list and keep on apeending the number to new nums
// // // //         //but i realised i need to reverse sort it
// // // //         // Collections.sort(list);

// // // //         // Reverse sorting the ArrayList
// // // //         Collections.sort(list, Collections.reverseOrder());
        
// // // //         int idx = 0;
// // // //         int size = list.size();
// // // //         int sum = 0;
// // // //         for(int i=size-1; i>=0; i--){
// // // //             int digit = list.get(i);
// // // //             digit *= (int)Math.pow(10,idx++);
// // // //             sum += digit;
// // // //         }
// // // //         return sum;
// // // //     }
// // // // }