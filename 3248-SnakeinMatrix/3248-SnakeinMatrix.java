class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i=0, j=0;
        for(int k=0; k<commands.size(); k++){
            String check = commands.get(k);
            if(check.equals("RIGHT")){
                j++;
            }
            if(check.equals("UP")){
                i--;
            }
            if(check.equals("DOWN")){
                i++;
            }
            if(check.equals("LEFT")){
                j--;
            }
        }
            // return grid[i][j];
            return i * n + j;
    }
}