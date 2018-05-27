package com.datastructure.exercise;


/**
 * 
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalancedTree {

	private class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }

	}
	
	public static void main(String[] args) {
		
	}
	
	public boolean IsBalanced_Solution(TreeNode root) {
		return isBalanced(root);
	}
	
	/**
	 * 当前节点的左右子树高度差<=1 ，而且左右子树为平衡二叉树
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (root != null) {
			int leftDepth = treeDepth(root.left);
			int rightDepth = treeDepth(root.right);
			int diff = Math.abs(leftDepth - rightDepth);
			return diff < 2 && isBalanced(root.left) && isBalanced(root.right);
		}else{
			return true;
		}
	}
	
	public int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}else{
			return Math.max(treeDepth(root.right), treeDepth(root.left)) + 1;
		}
	}
}
