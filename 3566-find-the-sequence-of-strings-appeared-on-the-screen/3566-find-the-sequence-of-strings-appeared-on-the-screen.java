class Solution {
    public List<String> stringSequence(String target) {
        char curr = 'a';
        List<String> list = new ArrayList<>();
        int n = target.length();
        String str = "";
        for(int i=0; i<n; i++){
            char ch = target.charAt(i);
            while(ch != curr){
                String temp = str;
                temp += curr;
                list.add(temp);
                curr++;
            }
            //now ch == curr
            //so
            str += ch;
            list.add(str);
            curr = 'a';
        }
        return list;
    }
}