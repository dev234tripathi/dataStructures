/**
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
*/

/**
Let's start by writing the in order traversal:

private void traverse (TreeNode root) {
   if (root == null)
      return;
   traverse(root.left);
   // Do some business
   traverse(root.right);
}
So when we need to print the node values in order, we insert System.out.println(root.val) in the place of "Do some business".

What is the business we are doing here?
We need to find the first and second elements that are not in order right?

How do we find these two elements? For example, we have the following tree that is printed as in order traversal:

6, 3, 4, 5, 2

We compare each node with its next one and we can find out that 6 is the first element to swap because 6 > 3 and 2 is the second element to swap because 2 < 5.

Really, what we are comparing is the current node and its previous node in the "in order traversal".

Let us define three variables, firstElement, secondElement, and prevElement. Now we just need to build the "do some business" logic as finding the two elements. See the code below:

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
    TreeNode firstElement;
    TreeNode secondElement;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        firstElement = null;
        secondElement = null;
        prev = null;
        inorderTraversal(root);
      //  swap()
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    public void inorderTraversal(TreeNode root) {
        if(root == null) return;
        inorderTraversal(root.left);
        //some business logic
        if(firstElement == null && (prev == null || prev.val >= root.val)) {
            firstElement = prev;
        }
        if(firstElement != null && prev.val >= root.val) {
            secondElement = root;
        }
        prev = root;
        
        inorderTraversal(root.right);
    }
}
