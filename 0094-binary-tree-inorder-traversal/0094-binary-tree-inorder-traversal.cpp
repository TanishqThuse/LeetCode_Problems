class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> st;
        TreeNode* current = root;

        while (current != nullptr || !st.empty()) {
            // Reach the leftmost node
            while (current != nullptr) {
                st.push(current);
                current = current->left;
            }

            // Current is null, so process the node on top of the stack
            current = st.top();
            st.pop();
            result.push_back(current->val);

            // Move to the right subtree
            current = current->right;
        }

        return result;
    }
};


    // // /**
    // //  * Definition for a binary tree node.
    // //  * struct TreeNode {
    // //  *     int val;
    // //  *     TreeNode *left;
    // //  *     TreeNode *right;
    // //  *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
    // //  *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    // //  *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
    // //  * };
    // //  */


    // // non recrusive solutoin
    // class Solution{
    //     public:
    //         vector<int> inorderTraversal(TreeNode* root) {
    //             // FOr the non-recursive solution we stimulaye tje recursive calls wiht a stack
    //             vector<int> list;
    //             stack<TreeNode*> st;
    //             TreeNode* curr = root;

    //             while(curr != nullptr || !st.empty()){
    //                 // We read the leftMost mode
    //                 while(curr != nullptr){
    //                     st.push(curr);
    //                     curr -> left;
    //                 }

    //                 // Curr is null, so proces the node on top of the stack
    //                 curr = st.top();
    //                 st.pop();
    //                 list.push_back(curr->val);

    //                 curr = curr->right;
    //             }

    //             return list;
    //         }
    // };






    // // class Solution {
    // // public:
    // // // Recursive solution
    // // // Inorder traversal : left, Root, Right
    // //     vector<int> inorderTraversal(TreeNode* root) {
    // //         vector<int> list;

    // //         dfs(root, list);

    // //         return list;
    // //     }

    // //     void dfs(TreeNode* root, vector<int>& list){
    // //         if(root == NULL){
    // //             return;
    // //         }

    // //         // firstly print the left subtree
    // //         dfs(root->left, list);

    // //         // secondly add the current node
    // //         list.push_back(root->val);

    // //         // then the right subtree
    // //         dfs(root->right, list);
    // //     }
    // // };