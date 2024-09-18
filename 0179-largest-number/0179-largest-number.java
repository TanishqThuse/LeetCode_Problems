class Solution {
    public String largestNumber(int[] nums) {
        String[] array =  new String[nums.length];
        for(int i=0; i<nums.length; i++){
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array,(a,b)-> (b+a).compareTo(a+b));
        if(array[0].equals("0")){
            return "0";
        }
        StringBuilder largest = new StringBuilder();
        for(int i=0; i<array.length; i++){
            largest.append(array[i]);
        }
        return largest.toString();
    }
}

//Fails when we compare for "30" amd "3" , give more proi to 30
// class Solution {
//     public String largestNumber(int[] nums) {
//         //The best way of solving it is to convert the nums array to string array and then sort in lexiographical order
//         int n = nums.length;;
//         String[] str = new String[n];
//         for(int i=0; i<n; i++){
//             str[i] = String.valueOf(nums[i]);
//         } 

//         //now sort str will be leixiograpphical
//         Arrays.sort(str);

//         //manually replace 3 and 30
        
//         String s = "";
//         for(int i=n-1 ; i>=0; i--){
//             s += str[i];
//         }

//         // int res  = Integer.parseInt(s);
//         // return Integer.parseInt(s);
//         return s;
//     }
// }