/**
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean zigzag = false;
        List<List<Integer>> res = new ArrayList<>();
        if(root == null ) return res;
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int count = queue.size();
            for(int i=0;i<count;i++) {
                TreeNode node = queue.poll();
                if(zigzag)
                    level.add(0,node.val);
                else
                    level.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }
	
/**
O(n) solution by using LinkedList along with ArrayList. So insertion in the inner list and outer list are both O(1),
Using DFS and creating new lists when needed.
*/