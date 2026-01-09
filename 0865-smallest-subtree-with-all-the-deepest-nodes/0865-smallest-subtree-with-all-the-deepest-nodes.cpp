/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int dfs(TreeNode* root, int depth){
        if(root == NULL){
            return depth;
        }

        depth++;

        return max(dfs(root->left, depth), dfs(root->right,depth));
    } 

    int f(TreeNode* root, int depth){
        if(root == NULL){
            return depth;
        }

        return max(f(root->left,depth+1), f(root->right, depth+1));
    }

    TreeNode* LCA(TreeNode* root){
        // if(currDepth == depth){
        //     return NULL;
        // }

        // check the leftDeepest level
        int depthOfLeft = f(root->left, 0);

        int depthOfRight = f(root->right, 0);

        if(depthOfLeft == depthOfRight) {
            // we found the LCA
            return root;
        }
        else if(depthOfLeft>depthOfRight) {
            return LCA(root->left);
        }
        return LCA(root->right);
    }

    TreeNode* subtreeWithAllDeepest(TreeNode* root) {
        int maxDep = dfs(root,0);

        return LCA(root);
    }
};