/**
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
*/

/**
method is based on DFS. Instead of calling depth() explicitly for each child node, we return the height of the current node in DFS recursion. 
When the sub tree of the current node (inclusive) is balanced, the function dfsHeight() returns a non-negative value as the height. 
Otherwise -1 is returned. According to the leftHeight and rightHeight of the two children, the parent node could check if the sub tree
is balanced, and decides its return value.
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
    public boolean isBalanced(TreeNode root) {
        
        return getHeight(root) != -1;
    }
    public int getHeight(TreeNode root) {
        if(root == null) return 1;
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) 
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}