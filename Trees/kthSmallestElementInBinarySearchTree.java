/**
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
*/

//version 1: 
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
    public int count = 0;
    public int number= 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    public void helper(TreeNode node) {
        if(node.left != null) {
            helper(node.left);
        }
        count--;
        if(count == 0) {
            number = node.val;
            return;
        }
        if(node.right != null) {
            helper(node.right);
        }
    }
}


//version 2: 
public int kthSmallest(TreeNode root, int k) {
      Stack<TreeNode> st = new Stack<>();
      
      while (root != null) {
          st.push(root);
          root = root.left;
      }
          
      while (k != 0) {
          TreeNode n = st.pop();
          k--;
          if (k == 0) return n.val;
          TreeNode right = n.right;
          while (right != null) {
              st.push(right);
              right = right.left;
          }
      }
      
      return -1; // never hit if k is valid
}