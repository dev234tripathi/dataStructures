/**
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

/**
This is the backtracking point. If we execute two sub recursive code in else branch and still can't get a match pathSum, 
this means the current "root" which already added into the List currentResult can not lead us to the correct answer. 
So we need to remove it from List currentResult and try other possible branches, this is what backtracking means.

in back-tracking,the currentResult always changes, the result which refers to the currentResult will change either.
LinkedList newResult = new LinkedList(currentResult);
result.add(newResult);
so that the result refers to the newResult which will not change in recursion.
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
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    List<Integer> list  = new ArrayList<Integer>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return result;
        list.add(root.val);
        if(root.left == null && root.right == null && sum == root.val)
            result.add(new ArrayList<>(list));
        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum- root.val);
        list.remove(list.size()-1);
        return result;
    }
}