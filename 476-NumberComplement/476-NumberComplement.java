
//This solution uses a lot of in-built libraries in java 
//especially for convertion from one data type to anohoher
//and conversion between number systems
class Solution {
    // public int IntToBin(int num){
    //     int rem ;
    //     while(num>0){
    //         int rem = num%2; // 
    //         //5%2==1;
    //         //2%2==0

    //     }
    // }

    public String compliment(String bin){
        String comp = "";
        for(int i=0;  i<bin.length() ; i++){
            if(bin.charAt(i)=='0'){
                comp+='1';
            }
            else{
                comp+='0';
            }
        }
        return comp;
    }

    public int findComplement(int num) {
       String bin = Integer.toBinaryString(num);
       String comp = compliment(bin);
       return Integer.parseInt(comp, 2);
    }
}