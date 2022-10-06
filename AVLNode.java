
public class AVLNode {
    public int key;
    public AVLNode left;
    public AVLNode right;
    public int height = 0;

    public AVLNode(int k, AVLNode l, AVLNode r, int h) {
        key = k;
        left = l;
        right = r;
        height = h;
    }

    public boolean compare(int i) {
        return key == i;
    }
}
