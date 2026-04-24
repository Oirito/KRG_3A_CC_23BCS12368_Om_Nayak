import java.util.*;

class SegmentTree {
    int[] tree, lazy;
    int n;

    SegmentTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }

    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }

    // 🔹 Push lazy updates
    void push(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[2 * node] += lazy[node];
                lazy[2 * node + 1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

    // 🔹 Range Update
    void updateRange(int node, int start, int end, int l, int r, int val) {
        push(node, start, end);

        if (r < start || end < l) return; // no overlap

        if (l <= start && end <= r) {
            lazy[node] += val;
            push(node, start, end);
            return;
        }

        int mid = (start + end) / 2;
        updateRange(2 * node, start, mid, l, r, val);
        updateRange(2 * node + 1, mid + 1, end, l, r, val);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // 🔹 Range Query
    int query(int node, int start, int end, int l, int r) {
        push(node, start, end);

        if (r < start || end < l) return 0;

        if (l <= start && end <= r) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int left = query(2 * node, start, mid, l, r);
        int right = query(2 * node + 1, mid + 1, end, l, r);
        return left + right;
    }
}

public class exp10 {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 11};

        SegmentTree st = new SegmentTree(arr);

        System.out.println("Initial sum (1-3): " + st.query(1, 0, arr.length - 1, 1, 3));

        System.out.println("Adding +10 to range [1,3]...");
        st.updateRange(1, 0, arr.length - 1, 1, 3, 10);

        System.out.println("Updated sum (1-3): " + st.query(1, 0, arr.length - 1, 1, 3));
    }
}