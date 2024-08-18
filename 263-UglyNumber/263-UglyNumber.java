class Solution{
    public boolean isUgly(int n){
        if(n<=0){
            return false;
        }

        int[] primes = {2, 3, 5};
        for(int p : primes){
            while(n%p==0){
                n = n/p;
            }
        } 
        return n==1;
    }
}



// class Solution {

//     public boolean isPrime(int n){
//         for(int i=2; i<n ;i++){
//             if(n%i==0){
//                 return false;
//             }
//         }
//         return true;
//     }

//     public boolean isUgly(int n) {
//         boolean flag = true;
//         if(n<=0 || (isPrime(n)&&n>0)){
//             return false;
//         }

//         for(int i=2; i<n; i++){
//             if(isPrime(i)){
//                 if((n%i==0 && i!=2 && i!=3 && i!=5)){
//                     flag = false;
//                     return flag;
//                 }
//             }
//         }
//         return flag;

//     }
// }