class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        //brute force : O(n*m)
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         if(matrix[i][j]==target){
        //             return true;
        //         }
        //     }
        // }
        // return false;

        //Approach -2 
        //optimised approach : Thus, the expected time complexity is 
    // O(log(m×n)), which satisfies the problem requirements.

    //obviously it utilised the binary search
    /**Why use / for row and % for column:
    Dividing by m for Row Calculation:

    The row index is determined by how many complete rows fit into the index mid in the conceptual 1D array.
    Since each row contains m columns, dividing the mid index by m (the number of columns) tells you how many full rows the element is past. This gives you the row number. */
       
        /**Modulus % for Column Calculation:

    The column index is determined by the remainder when you divide the index mid by m. This remainder gives the column offset within the row.
    Since the matrix has m columns, the remainder when dividing mid by m indicates the position within the row (i.e., the column). */

        int low = 0;
        int high = n*m-1;
        
        while(low<=high){
            //kind of still don't get the below apporrahc
            int mid = low + (high-low)/2;
            int row = mid / m;
            int col = mid%m;

              if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return false;
    }
}