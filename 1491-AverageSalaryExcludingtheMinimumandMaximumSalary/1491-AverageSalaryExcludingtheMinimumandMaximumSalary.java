class Solution {
    public double average(int[] salary) {
        double ans = 0;
        int mn = Integer.MAX_VALUE, mx = 0;
        for (int i = 0; i < salary.length; i++) {
            mn = Math.min(mn, salary[i]);
            mx = Math.max(mx, salary[i]);
            ans += salary[i];
        }
        ans = ans - mn - mx;
        ans = ans / (salary.length - 2);
        return ans;
    }
}