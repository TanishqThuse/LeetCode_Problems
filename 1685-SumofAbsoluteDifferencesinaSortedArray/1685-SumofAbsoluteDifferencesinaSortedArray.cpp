class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        // int sum=accumulate(nums.begin(),nums.end(),0);
        vector<int>ans;
        int n=nums.size();

        vector<int>pre(n,0);
        vector<int>suf(n,0);
        pre[0]=nums[0];
        suf[n-1]=nums[n-1];
        for(int i=1;i<n;i++)
        {
            pre[i]=pre[i-1]+nums[i];
        }

        for(int i=n-2;i>=0;i--)
        {
            suf[i]=suf[i+1]+nums[i];
        }

        for(int i=0;i<n;i++)
        {
            int temp=(i+1)*nums[i]-pre[i];
            temp+=(suf[i]-((n-i)*nums[i]));
            ans.push_back(temp);
        }
        return ans;
    }
};