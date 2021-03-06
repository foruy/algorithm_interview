package com.datastructure.exercise;

import com.datastructure.basic.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。 
 * 中序遍历后是排序的
 *
 */
public class 二叉搜索树转双链表 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(8);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		root = Convert(root);
		TreeNode last = null;
		while(root != null){
			System.out.print(root.val+";");
			root = root.right;
			if(root != null){
				last = root;
			}
		}
		System.out.println();
		while(last != null){
			System.out.print(last.val+";");
			last = last.left;
		}
		
	}

	/**
	 * 
	 *1.将左子树构造成双链表，并返回链表头节点。
     *2.定位至左子树双链表最后一个节点。
     *3.如果左子树链表不为空的话，将当前root追加到左子树链表。
     *4.将右子树构造成双链表，并返回链表头节点。
     *5.如果右子树链表不为空的话，将该链表追加到root节点之后。
     *6.根据左子树链表是否为空确定返回的节点。
	 */
	public static TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null){
			return null;
		}
		if(pRootOfTree.left == null && pRootOfTree.right == null){
			return pRootOfTree;
		}
		TreeNode left = Convert(pRootOfTree.left);
		TreeNode p = left;
		while(p != null && p.right != null){
			p = p.right;
		}
		if(left != null){
			p.right = pRootOfTree;
			pRootOfTree.left = p;
		}
		TreeNode right = Convert(pRootOfTree.right);
		if(right != null){
			right.left = pRootOfTree;
			pRootOfTree.right = right;
		}
		return left != null ? left : pRootOfTree;
	}
	

}
