package com.leetcode.DailyCheckIn._0830;

import com.leetcode.TreeNode;

/**
 * @Author zyh
 * @Date 2022/8/30 19:57
 * @Version 1.0
 */
public class InsertIntoMaxTree_998 {
    /*
    * 解题思路：
    *   1. 如果根节点的值小于给定的整数val，那么新的树会以val 作为根节点，并将原来的树作为新的根节点的左子树；
    *   2. 否则从根节点开始不断地向右子节点进行遍历
    *       当遍历到cur以及parent节点，并cur的值小于val，则创建新节点作为parent的右子树，其左子树的根为cur
    *   3. 若val比任何一个节点都小，则构造val为值的新节点，将该节点作为parent的右节点
    * */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while(cur != null){
            if(val > cur.val){
                if(parent == null){
                    return new TreeNode(val , root , null);
                }
                TreeNode node = new TreeNode(val , cur , null);
                parent.right = node;
                return root;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        parent.right = new TreeNode(val);
        return root;
    }
}
