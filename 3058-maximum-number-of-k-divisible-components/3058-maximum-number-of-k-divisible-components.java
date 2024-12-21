/**
 * Start from the leaves of the tree (the smallest subtrees) and compute their
 * sums.
 * Propagate the results up to their parent nodes, adding up the remainders
 * modulo k.
 * Whenever a subtree's sum is divisible by k, count it as a valid component.
 */

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Step : 1 Create an adjacencylist from edges
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        // Step 2 : Initialise component count
        // here we have used array's pass by reference
        int[] componentCount = new int[1];

        // Start DFS traversal from node 0
        dfs(0, -1, adjList, values, k, componentCount);

        // Step - 4 : Return the totoal number of compoenents
        return componentCount[0];
    }

    private int dfs(
            int currentNode,
            int parentNode,
            List<Integer>[] adjList,
            int[] nodeValues,
            int k,
            int[] componentCount) {
        // Step - 1 :Initialise sum for the current subtree
        int sum = 0;

        // Step -2 : Traverse all neighbours
        for (int neighbourNode : adjList[currentNode]) {
            if (neighbourNode != parentNode) {
                sum += dfs(
                        neighbourNode,
                        currentNode,
                        adjList,
                        nodeValues,
                        k,
                        componentCount);
                sum %= k; // ensure sum stays within the boundaries

            }
        }
        // Step - 3 : Add the value of the current node to the sum
        sum += nodeValues[currentNode];
        sum %= k;

        // Step - 4: Cheacking if sm is divisible by k
        if (sum == 0) {
            componentCount[0]++;
        }

        // step - 5 :
        return sum;
    }
}