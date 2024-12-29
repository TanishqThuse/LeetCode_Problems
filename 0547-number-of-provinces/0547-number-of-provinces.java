//Approach - 2 : BFS
class Solution{
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                numberOfComponents++;
                bfs(i, isConnected, visited);
            }
        }
        return numberOfComponents;

    }
    public void bfs(int node, int[][] isConnected, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node]= true;

        while(!q.isEmpty()){
            node = q.poll();

            for(int i=0; i<isConnected.length; i++)
            
            if(isConnected[node][i]==1 && !visited[i]){
                q.offer(i);
                visited[i] =true;
            }
        }
    }
}


//Apporahc - 1 : DFS
// class Solution {
//     public void dfs(int node, int[][] isConnected, boolean[] visited){
//         //visit the current node and all its adjancet nodes
//         visited[node] = true;

//         //traverse the other in dfs
//         for(int i=0; i<isConnected.length; i++){
//             if(isConnected[node][i] == 1 && !visited[i]){
//                 dfs(i, isConnected, visited);
//             }
//         }
//     }
//     public int findCircleNum(int[][] isConnected) {
//         //Approach - 1 : DFS Search
//         //since isConnected is gonna be a nxn matrix we only need to check the rows first
//         int n = isConnected.length; //n is number of node
//         int countOfComponents = 0;

//         //Also create an array visited to keep track of all the visited Nodes
//         boolean[] visited = new boolean[n];
        
//         //simply do the iteration
//         for(int i=0; i<n; i++){
//             if(!visited[i]){
//                 countOfComponents++;

//                 //just do dfs traversal
//                 dfs(i , isConnected, visited);
//             }
//         }        

//         return countOfComponents;
//     }
// }