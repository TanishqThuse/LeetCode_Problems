class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for(int i=1; i<=n; i++){
            list.add(String.valueOf(i));
        }

        Collections.sort(list);

        for(int i=1; i<=n; i++){
            int temp = Integer.parseInt(list.get(i-1));
            res.add(temp);
            // res.add(Integer.parseInt(list.get(i));
        }

        return res;

    }
}