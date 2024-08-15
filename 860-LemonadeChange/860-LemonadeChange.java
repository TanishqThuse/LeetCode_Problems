// The greedy choice in this problem is to always give the largest possible change (preferably a 10-dollar bill over three 5-dollar bills) when encountering a 20-dollar bill.

//Time is O(N) and space is O(1)

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int sum=0;
        HashMap<Integer, Integer> map=  new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        boolean flag = true;
        for(int i=0; i<bills.length; i++){
            if(bills[i]==5){
                map.put(5,map.get(5)+1);
            }
            else if(bills[i]==10){
                if(map.get(5)<1){
                    flag=false;
                    break;
                }
                map.put(5,map.get(5)-1);
                map.put(10,map.get(10)+1);
            }
            else if(bills[i]==20){
                //3 ways of making payment
                //1)10 ke 1 note, 5 ka 1 note (more prefred)
                //2)5 ke 3 notes (more prefered)

                //Case - 1 :
                //always exchange higher currency ==> herr 10
                if(map.get(10)>=1 && map.get(5)>=1){
                    map.put(10,map.get(10)-1);
                    map.put(5,map.get(5)-1);
                    map.put(20,map.get(20)+1);
                }
                else if(map.get(5)>=3){
                    map.put(5,map.get(5)-3);
                    map.put(20,map.get(20)+1);
                }
                else{
                    flag = false;
                    break;
                }
            }
        }
        return flag;

    }
}