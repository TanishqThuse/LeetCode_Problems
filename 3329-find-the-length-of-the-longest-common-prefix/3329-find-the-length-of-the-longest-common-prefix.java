class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<String, Integer> prefixMap = new HashMap<>();
        
        // Step 1: Build the prefix map for arr1
        for (int num : arr1) {
            String strNum = Integer.toString(num);
            String prefix = "";
            for (char ch : strNum.toCharArray()) {
                prefix += ch;
                prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + 1);
            }
        }
        
        int maxLength = 0;
        
        // Step 2: Check for common prefixes in arr2
        for (int num : arr2) {
            String strNum = Integer.toString(num);
            String prefix = "";
            for (char ch : strNum.toCharArray()) {
                prefix += ch;
                if (prefixMap.containsKey(prefix)) {
                    maxLength = Math.max(maxLength, prefix.length());
                }
            }
        }
        
        return maxLength;
    }
}

// class Solution {
//     public int longestCommonPrefix(int[] arr1, int[] arr2) {
//         int n1 = arr1.length;
//         int n2 = arr2.length;
        
//         int longest = 0;

//         for(int i=0; i<n1; i++){
//             int num1 = arr1[i];
//             int num2 = arr2[i];

//             longest = Math.max(comparePrefix(num1, num2));
//         }
//     }
//     public int comparePrefix(int num1,int num2){
//         List<Integer> digit1 = new List<>();
//         List<Integer> digit2 = new List<>();
//         while(num1>0 && num2>0){
//             digit1.add(num1%10);
//             digit1.add(num2%10);
//         }

//         int i = digit1.size()-1;
//         int j = digit2.size()-1;

//         if(i>j){
//             for(int k=j; k>=0; k--){
                
//             }
//         }

        

//     }
// }