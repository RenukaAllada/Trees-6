class sample{
    /************************PROBLEM-3***************/
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

    /********************PROBLEM-2******************/
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {
        //tc:0(n)
        //sc:0(n)
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null){
                return "";
            }
            Queue<TreeNode> q=new LinkedList<>();
            StringBuilder sb=new StringBuilder();
            q.add(root);
            while(!q.isEmpty()){
                TreeNode curr=q.poll();

                if(curr!=null){
                    sb.append(curr.val);
                    q.add(curr.left);
                    q.add(curr.right);
                }else{
                    sb.append("null");
                }
                sb.append(",");
            }
            return sb.toString();
        }
        //tc:0(n)
        //sc:0(n)
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data==null || data.length()==0){
                return null;
            }

            String[] strArray=data.split(",");
            int n=strArray.length;
            Queue<TreeNode> tree=new LinkedList<>();
            TreeNode root=new TreeNode(Integer.parseInt(strArray[0]));
            tree.add(root);
            int i=1;
            while(!tree.isEmpty()){
                TreeNode curr=tree.poll();
                if(!strArray[i].equals("null")){
                    curr.left=new TreeNode(Integer.parseInt(strArray[i]));
                    tree.add(curr.left);
                }
                i++;
                if(!strArray[i].equals("null")){
                    curr.right=new TreeNode(Integer.parseInt(strArray[i]));
                    tree.add(curr.right);
                }
                i++;
            }
            return root;
        }
    }

}