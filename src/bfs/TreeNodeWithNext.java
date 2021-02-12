package bfs;

public class TreeNodeWithNext {
    public int val;
    public TreeNodeWithNext left;
    public TreeNodeWithNext right;
    public TreeNodeWithNext next;

    public TreeNodeWithNext() {}

    public TreeNodeWithNext(int _val) {
        val = _val;
    }

    public TreeNodeWithNext(int _val, TreeNodeWithNext _left, TreeNodeWithNext _right, TreeNodeWithNext _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
