/*
Here are clean, short, revision-friendly notes you can keep for later practice.
No over-explanations, just exactly what you need to remember.

---

# **Minimum Time Visiting All Points – Notes (For Practice)**

## **Problem Summary**

Given a list of points on a 2D grid, you must visit them in order.
You can move:

* 1 unit horizontally
* 1 unit vertically
* 1 diagonal move: (1,1) in one second

Goal: find the **minimum time** to visit all points.

---

# **Key Insight**

Diagonal movement is the most efficient because it covers both x and y in the same second.

Given two points:

```
(x1, y1) → (x2, y2)
```

Let:

```
dx = |x2 - x1|
dy = |y2 - y1|
```

### **Minimum time = max(dx, dy)**

Reason:

* You use **min(dx, dy)** diagonals to reduce both axes.
* After that, only **|dx – dy|** straight moves remain.
* Combined, this always equals **max(dx, dy)**.

---

# **Example**

From (1,1) → (3,4):

```
dx = 2
dy = 3
time = max(2,3) = 3
```

---

# **Optimal Code (C++)**

```cpp
class Solution {
public:
    int minTimeToVisitAllPoints(vector<vector<int>>& points) {
        int ans = 0;
        for(int i=1; i<points.size(); i++){
            int dx = abs(points[i][0] - points[i-1][0]);
            int dy = abs(points[i][1] - points[i-1][1]);
            ans += max(dx, dy);
        }
        return ans;
    }
};
```

---

# **Why this is optimal**

* Diagonal moves combine vertical and horizontal movement.
* The maximum difference among dx and dy dictates the minimum time.
* This avoids step-by-step simulation and gives O(n) time.

---

# **What to remember**

1. Always compute difference in both axes: dx, dy
2. Minimum time = max(dx, dy)
3. Sum this for all consecutive pairs
4. Works because diagonal movement reduces both axes simultaneously

---

# **Common Wrong Approaches**

* Simulating each step
* Using BFS or Dijkstra (overkill)
* Moving one axis at a time

Correct approach always uses the Chebyshev Distance.

---

If you want, I can prepare similar revision notes for other questions you’re practicing.


*/

class Solution {
public:
    int minTimeToVisitAllPoints(vector<vector<int>>& points) {
        int ans = 0;
        for(int i=1; i<points.size(); i++){
            int dx = abs(points[i][0] - points[i-1][0]);
            int dy = abs(points[i][1] - points[i-1][1]);
            ans += max(dx, dy);
        }
        return ans;
    }
};


// class Solution {
// public:
//     int minTimeToVisitAllPoints(vector<vector<int>>& points) {
//         int n = points.size();
//         // if both x&y > curr then we go diag
//         // if only 1 then we go left/up or vice-versa
//         // will always start at first points
//         int cnt = 0;
//         int x = points[0][0];
//         int y = points[0][1];
//         for(int i=1;i<n;i++){
//             vector<int> point = points[i];
//             while(x != point[0] || y!=point[1]){
//                 if(point[0] > x && point[1] > y){
//                     x++;
//                     y++;
//                 }
//                 else if(point[0] < x && point[1] < y){
//                     x--;
//                     y--;
//                 } 
//                 else if(point[0] > x && point[1] < y){
//                     x++;
//                     y--;
//                 }
//                 else if(point[0] < x && point[1] > y){
//                     x--;
//                     y++;
//                 }
//                 else if(point[0] > x) {
//                     x++;
//                 }
//                 else if(point[0] < x){
//                     x--;
//                 }
//                 else if(point[1] > y){
//                     y++;
//                 }
//                 else if(point[1] < y){
//                     y--;
//                 }
//                 else{
//                     // if none of the above satified, that means we are at the same point, just continue;
//                     break;
//                 }
//                 cnt++;
//             }
//         }
//         return cnt;
//     }
// };