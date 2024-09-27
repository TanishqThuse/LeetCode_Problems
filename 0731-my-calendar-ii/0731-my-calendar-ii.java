//Good Qsn can practise

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCalendarTwo {
    private List<Integer> singleBooked;
    private List<Integer> doubleBooked;

    public MyCalendarTwo() {
        singleBooked = new ArrayList<>();
        doubleBooked = new ArrayList<>();
    }

    private List<Integer> intersection(List<Integer> intervals, int s, int e) {
        int l = Collections.binarySearch(intervals, s);
        if (l < 0) l = ~l;
        int r = Collections.binarySearch(intervals, e);
        if (r < 0) r = ~r;

        List<Integer> intersection = new ArrayList<>();
        if (l % 2 != 0) {
            if (!intervals.get(l).equals(s)) {
                intersection.add(s);
            } else {
                l++;
            }
        }

        intersection.addAll(intervals.subList(l, r));

        if (r % 2 != 0) {
            if (!intervals.get(r - 1).equals(e)) {
                intersection.add(e);
            } else {
                intersection.remove(intersection.size() - 1);
            }
        }

        return intersection;
    }

    private void add(List<Integer> intervals, int s, int e) {
        int l = Collections.binarySearch(intervals, s);
        if (l < 0) l = ~l;
        int r = Collections.binarySearch(intervals, e);
        if (r < 0) r = ~r;

        List<Integer> newIntervals = new ArrayList<>();
        if (l % 2 == 0) {
            newIntervals.add(s);
        }

        if (r % 2 == 0) {
            newIntervals.add(e);
        }

        intervals.subList(l, r).clear();
        intervals.addAll(l, newIntervals);
    }

    public boolean book(int start, int end) {
        if (!intersection(doubleBooked, start, end).isEmpty()) {
            return false;
        }

        List<Integer> inter = intersection(singleBooked, start, end);
        if (!inter.isEmpty()) {
            for (int i = 0; i < inter.size(); i += 2) {
                add(doubleBooked, inter.get(i), inter.get(i + 1));
            }
        }

        add(singleBooked, start, end);
        return true;
    }
}

// //GOT TLE
// class MyCalendarTwo {

//     HashMap<Integer, Integer> map;
//     public MyCalendarTwo() {
//         map = new HashMap<>();
//     }
    
//     public boolean book(int start, int end) {
//         //i assume it's again a semi-open interval 
//         //it's like [start,end) ==> will follow this
//         if(map.isEmpty()){
//             //we adding the first time
//             for(int i=start; i<end; i++){  // [start,end)
//                 map.put(i, map.getOrDefault(i,0)+1);
//             }
//         }
//         else{
//             //first we must check if any thing exceeds limit
//             for(int i=start; i<end; i++){
//                 if(map.getOrDefault(i,0)>1){
//                     return false;
//                 }
//             }
//             //after verification actually wwe add it in map
//             for(int i=start; i<end; i++){
//                 map.put(i, map.getOrDefault(i, 0)+1);
//             }
//         }
//         return true;
//     }
// }

// /**
//  * Your MyCalendarTwo object will be instantiated and called as such:
//  * MyCalendarTwo obj = new MyCalendarTwo();
//  * boolean param_1 = obj.book(start,end);
//  */