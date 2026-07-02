class Solution {
public:
    vector<string> createGrid(int m, int n) {
        string temp = "";
        vector<string> ans;
        if(m==1){
            // string res;
            for(int i=0; i<n; i++){
                temp += '.';
            }

            ans.push_back(temp);

            return ans;
        }


        for(int i=0; i<n; i++){
            temp += '#';
        }
        for(int i=0; i<m; i++){
            ans.push_back(temp);
        }

        int i=0; 
        int j=0;
        bool hehe = true;
        while((j!=n-1) || i!=m-1){
            ans[i][j] = '.';
            if(hehe) {
                // we need to increment coloumn
                if(j+1 < n)
                    j++;
                else i++;
            }
            else{
                if(i+1 < m)
                    i++;
                else j++;
            }
            hehe = !hehe;
        }
        ans[m-1][n-1] = '.';
        return ans;
    }
};