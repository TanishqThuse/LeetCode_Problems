class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        // prevRow.add(-1);
        for(int i=0; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            if(i==0){
                row.add(1);// = 1; //Mistake
                prevRow = row;
                list.add(row);
            }
            else{
                for(int j=0; j<=i; j++){
                    if(j==i){
                        row.add(1);
                        prevRow = row;
                        list.add(row);
                    }
                    else if(j==0){
                        row.add(1);
                    }
                    else{
                        int sum = prevRow.get(j-1) + prevRow.get(j);
                        row.add(sum);
                    }
                }
            }
        }
        return list;
    }
}