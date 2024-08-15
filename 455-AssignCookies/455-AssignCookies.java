//I am no sure if this is the optimal solutoin but i guess we apply he 
//greedy approach where we make kid with less candy demands done first then go to kids who have higher demans

class Solution{
    public int findContentChildren(int[] g,  int[] s){
        int gl = g.length;
        int sl = s.length;
        
        //sort both
        Arrays.sort(g);
        Arrays.sort(s);

        int count=0;

        
        //two pointer approach
        int i=0; //g
        int j=0; //s

        while(i<gl && j<sl){
            if(g[i]<=s[j]){
                count++;
                i++;
                j++;
            }
            else if(g[i]>s[j]){
                j++;
            }
        }
        return count;


    }
}


// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//         // HashMap<Integer, Integer> map = new HashMap<>();
//         //maps : size of cookie to no. of such cookies
//         int count=0;
//         // Arrays.sort(s); 
//         // for(int i=0; i<s.length; i++){
//         //     map.put(s[i],map.getOrDefault(s[i],0)+1);
//         // }
//         // Sorting g is a good deicisoin here
//         // Arrays.sort(g);
//         //now since g is sorted we can blindly write the below code knowing that each value we get is shortest atleast from right sie
//         // int count=0;
//         for(int i=0; i<g.length; i++){
//             for(int j=0; j<s.length;j++){
//                 if(s[j]>=g[i]){
//                     count++;
//                     s[i]=-1;
//                     break;
//                 }
//             }
//         }
//         return count;

//     }
// }