package OA;

import java.util.Arrays;

public class ReorderLogFile {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }

    public static String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (log1,log2)->{ // lambda expression
            String[] arr1 = spiltStr(log1); // seperate based on id and content, 
            String[] arr2 = spiltStr(log2);

            boolean isNum1 = isNumber(arr1[1].charAt(0));
            boolean isNum2 = isNumber(arr2[1].charAt(0));

            if (isNum1 && isNum2) return 0; // stay in the relevant order cuz all are digit-logs

            // one digit-log and other is letter-log
            else if (isNum1) return 1;
            else if (isNum2) return -1; //  if log1 should come before log2

            // when both log1 and log2 are letter-log
            boolean isSameContent = arr1[1].equals(arr2[1]);
            if(isSameContent) return arr1[0].compareTo(arr2[0]);  // compareTo gives us the alphabetical comparison result (0, negative, or positive)
            
            //  If the content of identifier was not the same, sort based on content itself
            return arr1[1].compareTo(arr2[1]);

        });
        return logs;
        
    }

    private static String[] spiltStr(String log){
        return log.split(" ", 2);
    }

    private static boolean isNumber(char curChar) {
        return '0' <= curChar && curChar <= '9';
    }
}
