package BST;

public class BinarySearchTree <T extends Comparable<T>>{
    Node<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T data){
        root = insertRec(root,data);
        System.out.println("After inserting " + data + ":");
        printTreeDesign();
        System.out.println();
    }
 private Node<T> insertRec(Node<T> root, T data) {
        if (root == null) {
            return new Node<>(data);
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        } else {
            // If data is equal to the current node's data, insert to the right only if greater
            if (data.compareTo(root.data) > 0) {
                root.right = insertRec(root.right, data);
            }
        }

        return root;
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    public void inorderTraversal(Node<T> root){
        if(root != null){
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    public void preorderTraversal(Node<T> root){
        if(root != null){
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void postorderTraversal() {
        postorderTraversal(root);
    }

    public void postorderTraversal(Node<T> root){
        if(root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public boolean search(T data){
        return searchData(root,data);
    }

    private boolean searchData(Node<T> root, T data) {
        if (root == null){
            return false;
        }

        if(data.equals(root.data)){
            return true;
        }

        if(data.compareTo(root.data) < 0){
            return searchData(root.left,data);
        } else {
            return searchData(root.right,data);
        }
    }

    public void printTreeDesign() {
        printTreeDesign(root, 0);
    }

    private void printTreeDesign(Node<T> root, int indent) {
        if (root != null) {
            printTreeDesign(root.right, indent + 4);
            for (int i = 0; i < indent; i++) {
                System.out.print(" ");
            }
            System.out.println(root.data);
            printTreeDesign(root.left, indent + 4);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insert(56);
        binarySearchTree.insert(30);
        binarySearchTree.insert(70);
        binarySearchTree.insert(22);
        binarySearchTree.insert(40);
        binarySearchTree.insert(60);
        binarySearchTree.insert(95);
        binarySearchTree.insert(11);
        binarySearchTree.insert(65);
        binarySearchTree.insert(3);
        binarySearchTree.insert(16);
        binarySearchTree.insert(63);
        binarySearchTree.insert(67);


        System.out.println("\nInorder Traversal: ");
        binarySearchTree.inorderTraversal();

        System.out.println("\nPreorder Traversal: ");
        binarySearchTree.preorderTraversal();

        System.out.println("\nPostorder Traversal: ");
        binarySearchTree.postorderTraversal();

        int searchData = 63;
        if(binarySearchTree.search(searchData)){
            System.out.println("\n" +searchData + " found in BST");
        } else {
            System.out.println("\n"+searchData +" not fount in BST");
        }
    }
}
