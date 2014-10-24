public class Solution {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		helper(root, max);
		return max[0];
	}

	public int helper(TreeNode root, int[] max) {
		if(root == null) return 0;
		int l = helper(root.left, max);
		int r = helper(root.right, max);
		int maxToRoot = Math.max(l, r);
		int sum = root.val;
		if(l > 0) sum += l;
		if(r > 0) sum += r;
		max[0] = Math.max(max[0], sum);
		return (maxToRoot > 0) ? maxToRoot + root.val : root.val;
	}
}
