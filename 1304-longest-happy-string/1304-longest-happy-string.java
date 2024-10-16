
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Priority queue to store the characters and their counts.
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if (a > 0) pq.offer(new int[]{a, 'a'});
        if (b > 0) pq.offer(new int[]{b, 'b'});
        if (c > 0) pq.offer(new int[]{c, 'c'});

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();

            // Check if last two characters are the same.
            if (result.length() >= 2 && result.charAt(result.length() - 1) == first[1] &&
                result.charAt(result.length() - 2) == first[1]) {

                if (pq.isEmpty()) break;  // No more valid characters.

                // Pick the second character.
                int[] second = pq.poll();
                result.append((char) second[1]);
                second[0]--;

                if (second[0] > 0) pq.offer(second);
                pq.offer(first);
            } else {
                result.append((char) first[1]);
                first[0]--;

                if (first[0] > 0) pq.offer(first);
            }
        }

        return result.toString();
    }
}

//bth approaches failed

// /**New change
// Before appending a letter, check the last two characters of the string.

// If the last two characters are the same as the letter you want to append, skip that letter.

// Ensure that you don't append more than two consecutive occurrences of the same letter. */
// class Solution {
//     public boolean allDone(int a, int b, int c, int x, int y, int z) {
//         return ((a == x) && (y == b) && (z == c));
//     }

//     public String longestDiverseString(int a, int b, int c) {
//         StringBuilder s = new StringBuilder();  // Use StringBuilder for efficient string manipulation
//         int x, y, z;
//         x = y = z = 0;

//         while (!allDone(a, b, c, x, y, z)) {
//             int cnt = 0;
//             int flag = 0;

//             // Handle 'a' (check last two characters to avoid "aaa")
//             if (s.length() < 2 || !(s.charAt(s.length() - 1) == 'a' && s.charAt(s.length() - 2) == 'a')) {
//                 while (cnt < 3 && x < a) {
//                     s.append("a");
//                     x++;
//                     cnt++;
//                 }
//                 flag += cnt > 0 ? 1 : 0;
//             }

//             cnt = 0;

//             // Handle 'b' (check last two characters to avoid "bbb")
//             if (s.length() < 2 || !(s.charAt(s.length() - 1) == 'b' && s.charAt(s.length() - 2) == 'b')) {
//                 while (cnt < 3 && y < b) {
//                     s.append("b");
//                     y++;
//                     cnt++;
//                 }
//                 flag += cnt > 0 ? 1 : 0;
//             }

//             cnt = 0;

//             // Handle 'c' (check last two characters to avoid "ccc")
//             if (s.length() < 2 || !(s.charAt(s.length() - 1) == 'c' && s.charAt(s.length() - 2) == 'c')) {
//                 while (cnt < 3 && z < c) {
//                     s.append("c");
//                     z++;
//                     cnt++;
//                 }
//                 flag += cnt > 0 ? 1 : 0;
//             }

//             if (flag == 0) {
//                 break; // No valid character was added, exit loop
//             }
//         }

//         return s.toString();
//     }
// }


// // class Solution {
// //     public boolean allDone(int a, int b, int c, int x, int y, int z){
// //         return ((a==x) && (y==b) && (z==c));
// //     }
// //     public String longestDiverseString(int a, int b, int c) {
// //         //since constraints are very low, brute force can be used
// //         //at least a a
// //         String s = "";
// //         int x,y,z;
// //         x = y = z = 0;
// //         while(!allDone(a,b,c,x,y,z)){
// //             int c = 0;
// //             int flag = 0;
// //             while(c < 3){
// //                 if(x == a){
// //                     break;
// //                 }
// //                 flag++;
// //                 s += "a";
// //                 x++;
// //                 c++;
// //             }
// //             c = 0;
// //             while(c < 3){
// //                 if(y==b){
// //                     break;
// //                 }
// //                 flag++;
// //                 s += "b";
// //                 y++;
// //                 c++;
// //             }
// //             c = 0;
// //             while(c < 3){
// //                 if(z==c){
// //                     break;
// //                 }
// //                 flag++;
// //                 s += "c";
// //                 z++;
// //                 c++;
// //             }
// //             if(flag == 0){
// //                 break;
// //             }
// //         }
// //         return s;
// //     }
// // }