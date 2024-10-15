import java.util.HashMap;

class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Build the frequency map for each index and digit
        for(int i = 0; i < n; i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            map.put(i, digit);
        }

        // Step 2: Count the occurrences of each digit in the string
        int[] count = new int[10];  // Array to store counts of digits 0 to 9
        for(int i = 0; i < n; i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            count[digit]++;
        }

        // Step 3: Verify if the count matches the map values
        for(int i = 0; i < n; i++) {
            int expectedCount = Character.getNumericValue(num.charAt(i));
            if(count[i] != expectedCount) {
                return false;
            }
        }

        return true;
    }
}

//slight errors
// class Solution {
//     public boolean digitCount(String num) {
//         int n = num.length();
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int i=0; i<n; i++){
//             int nums  = Integer.parseInt(num.charAt(i));
//             // map.put(i, (int)(num.charAt(i)));
//             map.put(i, nums);
//         }

//         int[] count = new int[n];
//         for(int i=0; i<n; i++){
//             int ch = Integer.parseInt(s.charAt(i));

//             count[ch] += 1;
//         }

//         for(int i=0; i<n; i++){
//             int ch = Integer.parseInt(s.charAt(i));
//             if(count[ch] != map.get(ch)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }