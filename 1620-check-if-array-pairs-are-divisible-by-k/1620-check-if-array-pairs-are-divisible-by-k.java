// // Approaches : 
// // Approach 1: Hashing / Counting ==> Not done
// // Approach 2: Sorting and Two-Pointers ==> Not done
// //Approach -3 : Brute force ==> Done but gives TLE ==> O(N^2)

//App-1 again
class Solution {

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        // Store the count of remainders in a map.
        for (int i : arr) {
            int rem = ((i % k) + k) % k;
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }

        for (int i : arr) {
            int rem = ((i % k) + k) % k;

            // If the remainder for an element is 0, then the count
            // of numbers that give this remainder must be even.
            if (rem == 0) {
                if (remainderCount.get(rem) % 2 == 1) return false;
            }
            // If the remainder rem and k-rem do not have the
            // same count then pairs can not be made.
            else if (
                !Objects.equals(
                    remainderCount.get(rem),
                    remainderCount.get(k - rem)
                )
            ) return false;
        }
        return true;
    }
}

// //App-1
// //logic : store modulus of each element in map and e=check for each iscount even
// class Solution{
//     public boolean canArrange(int[] arr, int k){
//         HashMap<Integer, Integer> cnt = new HashMap<>();
//         int n = arr.length;

//         for(int i = 0 ; i<n; i++){
//             int a = arr[i];
//             // int mod = a%k;
//             // The expression ((x % k) + k) % k is used to handle negative numbers properly when calculating the remainder

//             int mod = (((a % k) + k) % k);

//             cnt.put(mod, cnt.getOrDefault(mod, 0)+1);
//         }

//         // if(cnt.getOrDefault(0) % 2 !=0 ){
//         //     return false;
//         // }

//         for(int i=0 ; i<n; i++){
//             int rem = ((arr[i] % k) + k) % k;
            
//             if(rem==0){
//                 if(cnt.get(rem)%2!=0){
//                     return false;
//                 }
//             }
//             else if(cnt.get(rem) != cnt.get((k - rem))){
//                 return false;
//             }
//         }
//         return true;

//     }
// }

// // //Gives TLE : Since constraints too big
// // //BRUTE FORCE
// // class Solution {
// //     public boolean canArrange(int[] arr, int k) {
// //         int used = Integer.MIN_VALUE;
// //         int n = arr.length;
// //         //brute force
// //         for(int i=0; i<n; i++){
// //             for(int j=i+1; j<n; j++){
// //                 if(arr[i]!=used && arr[j]!=used){
// //                     if((arr[i]+arr[j])%k == 0){
// //                         arr[i] = used;
// //                         arr[j] = used;
// //                     }
// //                 }
            // }
// //         }

// //         //now check fot the same
// //         for(int i=0; i<n; i++){
// //             if(arr[i]!=used){
// //                 return false;
// //             }
// //         }
// //         return true;
// //     }
// }