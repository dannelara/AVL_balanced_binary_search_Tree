public class App {
    public static void main(String[] args) {

        AVLTree tree = new AVLTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        tree.printPreorder();
    }
}
