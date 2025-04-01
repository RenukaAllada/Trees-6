class sample{
    /************************PROBLEM-1***************/
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    //TC:0(N)
    //SC:0(N)
    class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            if(root==null){
                return new ArrayList<>();
            }
            List<List<Integer>> result=new ArrayList<>();
            Queue<TreeNode> q=new LinkedList<>();
            Queue<Integer> levels=new LinkedList<>();
            HashMap<Integer,List<Integer>> answer=new HashMap<>();
            int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
            q.add(root);
            levels.add(0);
            while(!q.isEmpty()){
                TreeNode value=q.poll();
                int level=levels.poll();
                if(!answer.containsKey(level)){
                    answer.put(level,new ArrayList<>());
                }
                answer.get(level).add(value.val);
                max=Math.max(max,level);
                min=Math.min(min,level);
                if(value.left!=null){
                    q.add(value.left);
                    levels.add(level-1);
                }
                if(value.right!=null){
                    q.add(value.right);
                    levels.add(level+1);
                }

            }
            for(int i=min;i<max+1;i++){
                result.add(answer.get(i));
            }
            return result;
        }
    }
}