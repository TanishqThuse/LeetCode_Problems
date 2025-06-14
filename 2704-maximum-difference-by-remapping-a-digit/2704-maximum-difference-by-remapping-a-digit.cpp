// My full intuitive solution
// class Solution {
// public:
//     int minMaxDifference(int num) {
//         // since we wanna iterate from the first numbert to the last number instead of rev(where we use %10 ops) so we will sconvert it to string
//         string s = to_string(num);
//         int size = s.size();
//         int n1 = 0;
//         int n = s.size() -1 ;
//         int maxi = 0;
//         int toConvert = -1;
//         bool flag = true; //shopld we convert a digit or not
//         for(char c : s){
//             int digit = c - '0';
//             int MUL10 = pow(10,n);
//             if(flag && digit >= 0 && digit<9){
//                 // we dont wanna change the 9 to a 9 only, instead just let it go
//                 maxi += 9*(MUL10);
//                 n--;
//                 toConvert = digit; //foudn the digit to be convert to 9
//                 flag = false;
//             }
//             else if(digit == toConvert){
//                 maxi += 9*(MUL10);
//                 n--;
//             }
//             else{
//                 // simply keep on appending
//                 maxi += digit*(MUL10);
//                 n--;
//             }
//         }


//         // now do the same for minimum
//         int mini = 0;
//         flag = true; //to find the required variable
//         toConvert = -1;
//         n = s.size() - 1;
//         // int first = s[0]; //we can make this zero even if it is second 
//         for(int i = 0; i<s.size(); i++){
//             int digit = s[i] - '0';
//             int MUL10 = pow(10,n);
//             if(flag && digit>0 && digit<=9){
//                 mini += 0;
//                 toConvert = digit;
//                 flag = false;
//             }
//             else if(digit != toConvert){
//                 mini += digit*(MUL10);
//             }
//             n--;
//         }

//         return (maxi - mini);
//     }
// };

class Solution {
public:
    int minMaxDifference(int num) {
        string s = to_string(num);

        // MAX: Replace first non-9 digit with 9
        char maxDigit = '\0';
        for (char c : s) {
            if (c != '9') {
                maxDigit = c;
                break;
            }
        }
        string sMax = s;
        if (maxDigit != '\0') {
            for (char &c : sMax) {
                if (c == maxDigit) c = '9';
            }
        }

        // MIN: Replace first non-0 digit with 0
        char minDigit = '\0';
        for (char c : s) {
            if (c != '0') {
                minDigit = c;
                break;
            }
        }
        string sMin = s;
        if (minDigit != '\0') {
            for (char &c : sMin) {
                if (c == minDigit) c = '0';
            }
        }

        return stoi(sMax) - stoi(sMin);
    }
};

