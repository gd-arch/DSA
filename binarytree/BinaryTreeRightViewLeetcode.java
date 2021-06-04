
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightViewLeetcode {
    public static void main(String[] args) {
        System.out.println();

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null) return list;
        Queue <TreeNode> q=new ArrayDeque<>();
        Queue <TreeNode> child=new ArrayDeque<>();
        q.add(root);
        list.add(root.val);
        while (!q.isEmpty()) {
            while (!q.isEmpty())  {
                TreeNode cur = q.remove();
                if (cur.right != null) child.add(cur.right);
                if (cur.left != null) child.add(cur.left);
            }
            if (child.peek() != null)
                list.add(child.peek().val);

            q=child;
            child=new ArrayDeque<TreeNode>();

        }

        return  list;

    }
}
