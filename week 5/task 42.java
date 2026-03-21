class Solution {

    // max nodes (safe limit)
    int[][] nodes = new int[1000][3];
    int index = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // Step 1: store all nodes
        dfs(root, 0, 0);

        // Step 2: sort manually
        sort(nodes, index);

        // Step 3: group by column
        List<List<Integer>> result = new java.util.ArrayList<>();

        int i = 0;
        while (i < index) {
            List<Integer> colList = new java.util.ArrayList<>();
            int col = nodes[i][0];

            while (i < index && nodes[i][0] == col) {
                colList.add(nodes[i][2]);
                i++;
            }

            result.add(colList);
        }

        return result;
    }

    // DFS traversal
    private void dfs(TreeNode node, int row, int col) {
        if (node == null) return;

        nodes[index][0] = col;
        nodes[index][1] = row;
        nodes[index][2] = node.val;
        index++;

        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }

    // simple bubble sort (can use any basic sort)
    private void sort(int[][] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (compare(arr[j], arr[j + 1]) > 0) {
                    int[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // compare logic
    private int compare(int[] a, int[] b) {
        if (a[0] != b[0]) return a[0] - b[0];  // col
        if (a[1] != b[1]) return a[1] - b[1];  // row
        return a[2] - b[2];                   // value
    }
}
