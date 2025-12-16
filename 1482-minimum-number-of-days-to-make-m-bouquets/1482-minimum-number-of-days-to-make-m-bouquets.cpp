class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        int n = bloomDay.size();
        if((long long)m*k > (long long)n){
            return -1;
        }

        int mini = *min_element(bloomDay.begin(), bloomDay.end());
        int maxi = *max_element(bloomDay.begin(), bloomDay.end());

        vector<int> copy = bloomDay;
        sort(copy.begin(), copy.end());

        int left = 0;
        int right = n-1;
        int ans = -1;
        // coz of binary search + linear inside
        // worst = O(nlogn) 
        while(left <= right){
            int mid = (left+right)/2;
            // now for the idx at mid check the status
            int ele = copy[mid];
            // now for this day make the elememnts bloom
            vector<int> check(n,0);
            for(int i=0; i<n; i++){
                if(bloomDay[i] <= ele){
                    check[i] = 1;
                }
            }

            // 1 1 1 1 0 1 1
            // now for the check array check if we get m sums of 
            int cnt = 0;
            int bouq = 0;
            for(int i=0; i<n; i++){
                if(check[i] == 1){
                    cnt++;
                    if(cnt == k){
                        bouq++;
                        cnt=0;
                    }
                }
                else{
                    // now we broke the continous sequnce, gotta setback
                    cnt=0;
                }
            }

            if(bouq >= m){
                ans = ele;
                right = mid-1; //try to see if any smaller value will work
            }
            else{
                // if we fail to not return above, we have to go ahead
                // we can try larger day
                left = mid + 1;
            }
        }

        return ans;
    }
};