class Solution {
    public int minimumSwap(String s1, String s2) {
        int n1 = s1.length();

        int xy=0, yx =0;

        for(int i=0; i<n1; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(ch1 == 'x' && ch2 == 'y'){
                xy++;
            }
            else if (ch1=='y' && ch2=='x'){
                yx++;
            }

            //a pair of xy and yx mistake ccan be solved in one move, remaining either xy/yx mistake needs 2 moves each
            
        }

        int cnt = 0;
        if((xy+yx) % 2 != 0){
            return -1;
        }
        // else if(xy > yx){
        //     // int rem = (xy-yx) * 2;
        //     // xy -= yx;
        //     // cnt += xy + rem;
        //     cnt += xy/2;
        //     cnt += yx/2;
        //     cnt += xy%2;
        //     cnt += yx%2;

        // }
        else{
            cnt += xy/2;
            cnt += yx/2;
            cnt += xy%2;
            cnt += yx%2;
        }
        return cnt;





        //extremley wrong approach
        //firstly i create two hashmaps to compare are they same or not
        // HashMap<Character, Integer> map = new HashMap<>();
        // int n2 = s2.length();
        // for(int i=0; i<n1; i++){
        //     char ch = s1.charAt(i);
        //     map.put(ch, map.getOrDefault(ch,0)+1);
        // }

        // HashMap<Character, Integer> map2 = new HashMap<>();
        
        // for(int i=0; i<n2; i++){
        //     char ch = s2.charAt(i);
        //     map2.put(ch, map2.getOrDefault(ch,0)+1);
        // }

        // if(!map.equals(map2)){
        //     return -1;
        // }

        /**Hint : Identify positions where s1[i] and s2[i] differ.

    Count the number of xy mismatches (s1[i] == 'x', s2[i] == 'y').
    Count the number of yx mismatches (s1[i] == 'y', s2[i] == 'x').

Swapping strategy:

    Each pair of (xy and yx) can be resolved in 1 swap.
    If there are leftover xy or yx mismatches, they must be in pairs (xy, xy or yx, yx), requiring 2 swaps each. */

        // int cnt = 0; //btw i forgot they both have the same string size
        
        // int cnt_x = 0, cnt_y = 0;
        
        // for(int i=0; i<n1; i++)
        // {
        //     char ch1 = s1.charAt(i);
        //     char ch2 = s2.charAt(i);
        //     if(ch1!=ch2) cnt++;
        //     if(ch1 == 'x')cnt_x++;
        //     else cnt_y++;
        // }

        // if(cnt_x != cnt_y) return -1;






    }
}