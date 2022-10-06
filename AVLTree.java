public class AVLTree {
    AVLNode root = null;

    public AVLNode getRoot() {
        return root;
    }

    public void printPreorder() {
        _print_reorder(root);
    }

    public void insert(int i) {
        root = _insert(root, i);
    }

    private AVLNode _insert(AVLNode r, int i) {

        if (r == null)
            return new AVLNode(i, null, null, 0);

        boolean equal = r.compare(i);

        // If value exists, do nothing.
        if (equal)
            ;

        else if (r.key > i)
            r.left = _insert(r.left, i);
        else if (r.key < i)
            r.right = _insert(r.right, i);

        return balance(r);

    }

    private AVLNode balance(AVLNode n) {
        if (n == null)
            return n;

        if (height(n.left) - height(n.right) > 1) {
            if (height(n.left.left) >= height(n.left.right))
                n = rotate_left(n);
            else
                n = double_left(n);
        } else if (height(n.right) - height(n.left) > 1) {
            if (height(n.right.right) >= height(n.right.left))
                n = rotate_right(n);
            else
                n = double_right(n);
        }

        n.height = Math.max(height(n.left), height(n.right)) + 1;
        return n;
    }

    private int height(AVLNode n) {
        if (n == null)
            return -1;
        return n.height;
    }

    private AVLNode rotate_left(AVLNode n) {
        AVLNode r1 = n.left;

        n.left = r1.right;
        r1.right = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r1.height = Math.max(height(r1.left), n.height) + 1;

        return r1;
    }

    private AVLNode rotate_right(AVLNode n) {
        AVLNode r1 = n.right;

        n.right = r1.left;
        r1.left = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r1.height = Math.max(height(r1.left), n.height) + 1;

        return r1;
    }

    private AVLNode double_left(AVLNode n) {
        n.left = rotate_right(n.left);
        return rotate_left(n);
    }

    private AVLNode double_right(AVLNode n) {
        n.right = rotate_left(n.right);
        return rotate_right(n);
    }

    private void _print_reorder(AVLNode n) {
        if (n != null) {
            System.out.println(n.key);
            _print_reorder(n.left);
            _print_reorder(n.right);
        }
    }

}
