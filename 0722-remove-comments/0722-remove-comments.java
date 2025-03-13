import java.util.*;

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        boolean multi = false;
        StringBuilder newLine = new StringBuilder();

        for (String str : source) {
            int i = 0, n = str.length();
            
            if (!multi) newLine.setLength(0); // Reset for a new line if not in a block comment
            
            while (i < n) {
                if (!multi && i + 1 < n && str.charAt(i) == '/' && str.charAt(i + 1) == '/') {
                    break; // Ignore the rest of this line
                } else if (!multi && i + 1 < n && str.charAt(i) == '/' && str.charAt(i + 1) == '*') {
                    multi = true;
                    i++; // Skip '*'
                } else if (multi && i + 1 < n && str.charAt(i) == '*' && str.charAt(i + 1) == '/') {
                    multi = false;
                    i++; // Skip '/'
                } else if (!multi) {
                    newLine.append(str.charAt(i)); // Only add if not inside a block comment
                }
                i++;
            }
            
            if (!multi && newLine.length() > 0) {
                list.add(newLine.toString()); // Add to output only if not in block comment
            }
        }

        return list;
    }
}


    // //O(n*m) is time complexity
    // class Solution {
    //     public List<String> removeComments(String[] source) {
    //         List<String> list = new ArrayList<>();
    //         int n = source.length;
    //         boolean multi = false;
    //         for(int j=0; j<n; j++){
    //             String str = source[j];
    //             // StringBuilder str = new StringBuilder(source[i]);
    //             String string = "";
    //             int m = str.length();
    //             // boolean multi = false;
    //             boolean single = false;
    //             for(int i=0; i<m; i++){
                    
    //                 if(str.charAt(i) == '/')
    //                 {
    //                     if(i+1<m){
    //                         char ch1 = str.charAt(i);
    //                         char ch2 = str.charAt(i+1);
    //                         if(ch1=='/' && ch2=='/'){
    //                             single = true;
    //                             //i just realised it is much more efficient to break the line after this
    //                             break;
    //                         }
    //                         else if(ch1=='/' && ch2 == '*'){
    //                             multi = true;
    //                         }
    //                     }
    //                 }
    //                 else if(str.charAt(i)=='*'){
    //                     if(i+1<m && str.charAt(i+1)=='/'){
    //                         multi = false;
    //                         i++; //since we want to skip '/' being put in string as well
    //                     }
    //                 }
    //                 else if(!multi && !single){
    //                     string += str.charAt(i);   
    //                 }
    //             }
    //             if(string.length()!=0){
    //                 list.add(string);
    //             }
    //         }
    //         return list;
    //     }
    // }