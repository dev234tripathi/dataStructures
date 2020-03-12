/**
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/

 public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder.length!=inorder.length) return null;
    return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
}

public TreeNode build(int [] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){
    if(preLow>preHigh || inLow>inHigh) return null;
    TreeNode root = new TreeNode(preorder[preLow]);
   
    int inorderRoot = inLow;
    for(int i=inLow;i<=inHigh;i++){
        if(inorder[i]==root.val){ inorderRoot=i; break; }
    }
   
    int leftTreeLen = inorderRoot-inLow;
    root.left = build(preorder, preLow+1, preLow+leftTreeLen, inorder, inLow, inorderRoot-1);
    root.right = build(preorder, preLow+leftTreeLen+1, preHigh, inorder, inorderRoot+1, preHigh);       
    return root;        
}