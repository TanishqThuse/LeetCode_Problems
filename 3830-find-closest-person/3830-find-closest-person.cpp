class Solution {
public:
    int findClosest(int x, int y, int z) {
        int fP = abs(x-z);
        int sP = abs(y-z);
        // return max(fP, sP);
        if(fP > sP) return 2;
        else if(fP < sP) return 1;
        return 0;
    }
};