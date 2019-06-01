class Node {
    int value;
    Node left;
    Node right;
    Node parent;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}