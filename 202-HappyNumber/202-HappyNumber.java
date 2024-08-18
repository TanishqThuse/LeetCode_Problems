//try-2 
class Solution{

    public int sumOfSquare(int n){
        int sum=0;
        while(n>0){
            int digit = n%10;
            sum+=digit*digit;
            n/=10;
        }
        return sum;
    }

    public boolean isHappy(int n){
        HashSet<Integer> set = new HashSet<>();
        boolean flag = false;
        int sum = 0;
        while(!set.contains(n)){
            set.add(n);
            n = sumOfSquare(n);
            // n=n/10;
            if(n==1){
                return true;
            }
        }
        return flag;
    }
}


///try -1
// class Solution {
//     public boolean isHappy(int n) {
//         int sum = 0;
//         boolean flag=false;
//         HashSet<Integer> set = new HashSet<>();
//         set.add(n);
//         while(n>0){
//             int digit = n%10;
//             sum+=digit*digit;
//             //19,1,
//             if(n/10<0){
//                 if(sum==1 ){
//                 flag=true;
//                 break;
//                 }
//                 else if(set.contains(sum)){
//                     break;
//                 }
//                 set.add(sum);
//                 n = sum;
//                 sum=0;
//                 continue;
//             }
//             else{
//                 n/=10;
//             }
//         }
//         return flag;
//     }
// }