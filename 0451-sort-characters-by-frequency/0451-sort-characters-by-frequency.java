//Practise Again

class Solution{

    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freq.entrySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();        
    }

    //The hardest  part was sorting the HashMap according 
    // public String frequencySort(String s){
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     int n = s.length();
    //     for(int i=0; i<n; i++){
    //         char ch = s.charAt(i);
    //         map.put(ch, map.getOrDefault(ch,0)+1);
    //     }


    // }
}

// class Solution {
//     public String frequencySort(String s) {
//         //frequency
//         HashMap<Character,Integer> map=new HashMap<>();
        
//         for(char ch:s.toCharArray())
//         {
//             map.put(ch,map.getOrDefault(ch,0)+1);
//         }
        

//     }
// }