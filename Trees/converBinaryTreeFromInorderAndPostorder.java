/**
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
   15   7
*/

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length) return null;
        return helper(inorder,0,inorder.length-1,postorder,postorder.length-1);
    }
    public TreeNode helper(int [] inorder,int inStart,int inEnd,int[] postorder,int postEnd) {
        if(inStart > inEnd ) return null;
        else if (inStart == inEnd) return new TreeNode(inorder[inStart]);
        
        int rootIndex;
        for(rootIndex=inStart;rootIndex<=inEnd;rootIndex++) {
            if(inorder[rootIndex] == postorder[postEnd]){
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rightSubTreeLength = inEnd - rootIndex;
        root.left = helper(inorder,inStart,rootIndex-1,postorder,postEnd-1-rightSubTreeLength);
        root.right = helper(inorder,rootIndex+1,inEnd,postorder,postEnd-1);
        return root;
    }
}