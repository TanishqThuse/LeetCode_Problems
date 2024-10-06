class Solution {

    public static String convertToBinary(int num) {
        StringBuilder binary = new StringBuilder();
        if (num == 0) return "0";
        while (num > 0) {
            binary.insert(0, num % 2);
            num = num / 2;
        }
        return binary.toString();
    }

    public int maxGoodNumber(int[] nums) {
        int n = nums.length;
        String[] binNums = new String[n];

        for (int i = 0; i < n; i++) {
            binNums[i] = convertToBinary(nums[i]);
        }

        String[] concatenatedBinaries = new String[6];
        concatenatedBinaries[0] = binNums[0] + binNums[1] + binNums[2];
        concatenatedBinaries[1] = binNums[0] + binNums[2] + binNums[1];
        concatenatedBinaries[2] = binNums[1] + binNums[0] + binNums[2];
        concatenatedBinaries[3] = binNums[1] + binNums[2] + binNums[0];
        concatenatedBinaries[4] = binNums[2] + binNums[0] + binNums[1];
        concatenatedBinaries[5] = binNums[2] + binNums[1] + binNums[0];

        int maxNumber = 0;
        for (int i = 0; i < 6; i++) {
            int number = Integer.parseInt(concatenatedBinaries[i], 2);
            maxNumber = Math.max(maxNumber, number);
        }

        return maxNumber;
    }
}


    // class Solution {

    //     public static String convertToBinary(int num) {
    //         StringBuilder binary = new StringBuilder();
            
    //         // Handle 0 case
    //         if (num == 0) {
    //             return "0";
    //         }
            
    //         while (num > 0) {
    //             binary.insert(0, num % 2); // Prepend remainder
    //             num = num / 2;
    //         }
            
    //         return binary.toString();
    //     }


    //     public int maxGoodNumber(int[] nums) {
    //         int n = nums.length; //which is 3 anyways
    //         String[] binNums = new String[n];

    //         for(int i=0; i<n ; i++){
    //             binNums = convertToBinary(nums[i]);
    //         }

    //         //now check all three combinartions
    //         //trick : int number = Integer.parseInt(binaryString, 2);

    //         String a=b=c="";
    //         for(int i=0; i<3; i++){
    //             a += nums[i];
    //         }

    //         for(int i=1; i<3; i++){
    //             b += nums[i];
    //         }
    //         b+=nums[0];

    //         c += nums[2];
    //         for(int i=0; )

    //     }
    // }