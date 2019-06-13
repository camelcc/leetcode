public class S0307RangeSumQueryMutable {
    public static class NumArray {
        class SegmentTreeNode {
            int start, end;
            SegmentTreeNode left, right;
            int sum;

            public SegmentTreeNode(int start, int end) {
                this.start = start;
                this.end = end;
                this.left = null;
                this.right = null;
                this.sum = 0;
            }
        }

        SegmentTreeNode segmentTree = null;

        public NumArray(int[] nums) {
            segmentTree = build(nums, 0, nums.length-1);
        }

        private SegmentTreeNode build(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start == end) {
                root.sum = nums[start];
                return root;
            }

            // start < end
            int mid = start+(end-start)/2;
            root.left = build(nums, start, mid);
            root.right = build(nums, mid+1, end);
            root.sum = root.left.sum+root.right.sum;
            return root;
        }

        public void update(int i, int val) {
            update(segmentTree, i, val);
        }

        private void update(SegmentTreeNode node, int i, int val) {
            if (node.start == node.end) {
                assert node.start == i;
                node.sum = val;
                return;
            }

            int mid = node.start+(node.end-node.start)/2;
            if (i <= mid) {
                update(node.left, i, val);
            } else if (i > mid) {
                update(node.right, i, val);
            }
            node.sum = node.left.sum+node.right.sum;
        }

        public int sumRange(int i, int j) {
            return sumRange(segmentTree, i, j);
        }

        private int sumRange(SegmentTreeNode node, int start, int end) {
            if (node.start == start && node.end == end) {
                return node.sum;
            }

            int mid = node.start+(node.end-node.start)/2;
            if (end <= mid) {
                return sumRange(node.left, start, end);
            } else if (start > mid) {
                return sumRange(node.right, start, end);
            } else {
                return sumRange(node.left, start, mid) + sumRange(node.right, mid+1, end);
            }
        }
    }
}
