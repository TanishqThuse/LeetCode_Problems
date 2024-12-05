class Solution {

    public boolean canChange(String start, String target) {
        // Queue to store characters and indices from both strings
        Queue<Pair<Character, Integer>> startQueue =
            new LinkedList<>(), targetQueue = new LinkedList<>();

        // Record non-underscore characters and their indices
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                startQueue.add(new Pair<>(start.charAt(i), i));
            }
            if (target.charAt(i) != '_') {
                targetQueue.add(new Pair<>(target.charAt(i), i));
            }
        }

        // If number of pieces don't match, return false
        if (startQueue.size() != targetQueue.size()) return false;

        // Compare each piece's type and position
        while (!startQueue.isEmpty()) {
            Pair<Character, Integer> startPair = startQueue.poll();
            Pair<Character, Integer> targetPair = targetQueue.poll();

            char startChar = startPair.getKey();
            int startIndex = startPair.getValue();
            char targetChar = targetPair.getKey();
            int targetIndex = targetPair.getValue();

            // Check character match and movement rules
            if (
                startChar != targetChar ||
                (startChar == 'L' && startIndex < targetIndex) ||
                (startChar == 'R' && startIndex > targetIndex)
            ) {
                return false;
            }
        }

        return true;
    }
}

// class Solution{
//     public boolean canChange(String start, String target){
        
//         //to store the visited states
//         Set<String> visitedStates = new HashSet<>();

//         //Queue for storing the current state
//         Queue<String> queue = new LinkedList<>();

//         //we add the current state
//         queue.add(start);

//         while(!queue.isEmpty()){
//             String currentState = queue.poll();
//             if(currentState.equals(target)) return true;

//             for(int position = 1; position<currentState.length(); position++){
//                 //move L
//                 currentState.charAt(position)
//             }
//         }
//     }
// }


// // class Solution {
// //     public boolean checkCondition()

// //     public boolean canChange(String start, String target) {
// //         //brute force
// //         int n = start.length();
// //         if(start.equals(target)) return true;
// //         for(int i=0; i<n ; i++){
// //             char ch = start.charAt(i);
// //             if(ch=='L' || ch=='R'){
// //                 // String temp = start; //create a copy
// //                 // if(ch=='L'){
// //                 //     //go left
// //                 //     for(int j=i; j>=0; j--){

// //                 //     }
// //                 // }
// //             }
// //         }
// //     }
// // }