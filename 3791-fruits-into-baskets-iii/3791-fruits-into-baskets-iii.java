class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] baskets) {
        this.n = baskets.length;
        tree = new int[n * 4];
        build(baskets, 0, 0, n - 1);
    }

    private void build(int[] baskets, int node, int l, int r) {
        if (l == r) {
            tree[node] = baskets[l];
        } else {
            int mid = (l + r) / 2;
            build(baskets, node * 2 + 1, l, mid);
            build(baskets, node * 2 + 2, mid + 1, r);
            tree[node] = Math.max(tree[node * 2 + 1], tree[node * 2 + 2]);
        }
    }

    // Find leftmost basket index ≥ val
    public int query(int val) {
        return query(0, 0, n - 1, val);
    }

    private int query(int node, int l, int r, int val) {
        if (tree[node] < val) return -1; // No basket in this segment can hold the fruit
        if (l == r) return l;

        int mid = (l + r) / 2;
        int left = query(node * 2 + 1, l, mid, val);
        if (left != -1) return left;
        return query(node * 2 + 2, mid + 1, r, val);
    }

    // Mark basket at index as used (set to -1)
    public void update(int index) {
        update(0, 0, n - 1, index);
    }

    private void update(int node, int l, int r, int index) {
        if (l == r) {
            tree[node] = -1;
        } else {
            int mid = (l + r) / 2;
            if (index <= mid)
                update(node * 2 + 1, l, mid, index);
            else
                update(node * 2 + 2, mid + 1, r, index);
            tree[node] = Math.max(tree[node * 2 + 1], tree[node * 2 + 2]);
        }
    }
}

public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree st = new SegmentTree(baskets);
        int unplaced = 0;

        for (int fruit : fruits) {
            int idx = st.query(fruit);
            if (idx == -1) {
                unplaced++;
            } else {
                st.update(idx); // Use the basket
            }
        }

        return unplaced;
    }
}
