
class Node {
    int docId;
    Node left, right;

    Node(int docId) {
        this.docId = docId;
        left = right = null;
    }
}

public class DocuTrackBST {
    Node root;

    Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.docId)
            root.left = insert(root.left, key);
        else if (key > root.docId)
            root.right = insert(root.right, key);

        return root;
    }

    boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.docId == key)
            return true;

        if (key < root.docId)
            return search(root.left, key);

        return search(root.right, key);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.docId + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.docId + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.docId + " ");
        }
    }

    public static void main(String args[]) {
        DocuTrackBST tree = new DocuTrackBST();

        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);

        if (tree.search(tree.root, 40))
            System.out.println("Document Found");
        else
            System.out.println("Document Not Found");

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder Traversal: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder Traversal: ");
        tree.postorder(tree.root);
    }
}

