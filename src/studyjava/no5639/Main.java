package studyjava.no5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while ((input = br.readLine()) != null) {
            Node.addNode(new Node(Integer.parseInt(input)));
        }

        br.close();

        Node.postOrder();
    }
}

class Node {
    private static Node root = null;
    private int value;
    private Node left, right;

    public Node(int value) {
        this.value = value;
    }

    public static void addNode(Node newNode) {
        if (root == null) {
            root = newNode;
            return;
        }

        Node now = root;

        while (true) {
            if (now.value > newNode.value) {
                if (now.left == null) {
                    now.left = newNode;
                    return;
                } else now = now.left;
            } else {
                if (now.right == null) {
                    now.right = newNode;
                    return;
                } else now = now.right;
            }
        }
    }

    public static void postOrder() {
        postOrder(root);
    }

    private static void postOrder(Node now) {
        if (now.left != null) postOrder(now.left);
        if (now.right != null) postOrder(now.right);
        System.out.println(now.value);
    }

}