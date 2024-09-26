//Practise once more

import java.util.TreeMap;

class MyCalendar {
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // Find the closest booking with a start time less than or equal to the current start
        Integer prev = calendar.floorKey(start);
        // Find the next booking with a start time greater than or equal to the current end
        Integer next = calendar.ceilingKey(start);
        
        // Check if the current booking overlaps with the previous or next bookings
        if ((prev == null || calendar.get(prev) <= start) && (next == null || next >= end)) {
            // If no overlap, add the new booking
            calendar.put(start, end);
            return true;
        }
        // Overlap detected, return false
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */


/**Solution works but TLE */
// class MyCalendar {

//     HashSet<Integer> set;
//     public MyCalendar() {
//         set = new HashSet<>();
//     }

//     /**IMP : The bookings are defined as half-open intervals [start, end), meaning start is inclusive, but end is exclusive. */
    
//     public boolean book(int start, int end) {
//         if(set.size()==0){
//             for(int i=start; i<end; i++){
//                 set.add(i);
//             }
//             return true;
//         }
//         else{
//             for(int i=start; i<end ; i++){
//                 if(set.contains(i)){
//                     return false;
//                 }
//             }
//             for(int i=start; i<end; i++){
//                 set.add(i);
//             }
//         }
//         return true;
//     }
// }

// /**
//  * Your MyCalendar object will be instantiated and called as such:
//  * MyCalendar obj = new MyCalendar();
//  * boolean param_1 = obj.book(start,end);
//  */