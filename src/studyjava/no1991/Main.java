import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		char name;
		Node left, right;

		public Node(char name) {
			this.name = name;
		}

		public Node getNode(char name) {
            if (this.name == name) return this;
			Deque<Node> dfsStack = new ArrayDeque<>();

			dfsStack.addLast(this);
            
			while(!dfsStack.isEmpty()) {
				Node now = dfsStack.pollLast();

				if (now.left != null) {
                    if (now.left.name == name) return now.left;
					dfsStack.addLast(now.left);
				}

				if (now.right != null) {
                    if (now.right.name == name) return now.right;
					dfsStack.addLast(now.right);
				}
			}

			return null;
		}

		public void preorder() {
			System.out.print(this.name);
			if (this.left != null) this.left.preorder();
			if (this.right != null) this.right.preorder();
		}

		public void inorder() {
			if (this.left != null) this.left.inorder();
			System.out.print(this.name);
			if (this.right != null) this.right.inorder();
		}

		public void postorder() {
			if (this.left != null) this.left.postorder();
			if (this.right != null) this.right.postorder();
			System.out.print(this.name);
		}

		@Override
		public String toString() {
			return this.name + " " + (this.left == null ? "." : this.left.name) + " " + (this.right == null ? "." : this.right.name);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		Node root = null;

		for (int i = 0; i < k; i++) {
			char[] input = br.readLine().toCharArray();
			if (i == 0) {
				root = new Node(input[0]);
				if (input[2] != '.') {
					root.left = new Node(input[2]);
				}
				if (input[4] != '.') {
					root.right = new Node(input[4]);
				}

				continue;
			} 

			Node parent = root.getNode(input[0]);

			if (input[2] != '.') {
				parent.left = new Node(input[2]);
			}
			if (input[4] != '.') {
				parent.right = new Node(input[4]);
			}
		}

		br.close();

		root.preorder();
		System.out.println();
		root.inorder();
		System.out.println();
		root.postorder();
		System.out.println();

		// System.out.println(root.getNode('A'));
		// System.out.println(root.getNode('B'));
		// System.out.println(root.getNode('C'));
		// System.out.println(root.getNode('D'));
		// System.out.println(root.getNode('E'));
		// System.out.println(root.getNode('F'));
		// System.out.println(root.getNode('G'));



	}
}

/*
ABDCEFG

DBAECFG

DBEGFCA

*/