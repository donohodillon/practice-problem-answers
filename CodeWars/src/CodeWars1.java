import java.util.Locale;

public class CodeWars1 {
//    This time no story, no theory. The examples below show you how to write function accum:
//
//    Examples:
//    accum("abcd") -> "A-Bb-Ccc-Dddd"
//    accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
//    accum("cwAt") -> "C-Ww-Aaa-Tttt"
//    The parameter of accum is a string which includes only letters from a..z and A..Z.
/////////////////////////////////////////////////////////////////////////////////////////
    public static String accumul (String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j <= i; j++){
                if (j == 0)
                    answer += s.toUpperCase(Locale.ROOT).substring(i, i + 1);
                else {
                    answer += s.toLowerCase(Locale.ROOT).substring(i, i + 1);
                }
                if (j == i && j != s.length()-1)
                    answer += "-";
            }
        }
        return answer;
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    public class accumul2 {
        public static String accum(String s) {
            StringBuilder bldr = new StringBuilder();
            int i = 0;
            for(char c : s.toCharArray()) {
                if(i > 0) bldr.append('-');
                bldr.append(Character.toUpperCase(c));
                for(int j = 0; j < i; j++) bldr.append(Character.toLowerCase(c));
                i++;
            }
            return bldr.toString();
        }
    }

//    ///////////////////////////////////////////////////////////////////////////////
//    You are going to be given an array of integers. Your job is to take that array and find an
//    index N where the sum of the integers to the left of N is equal to the sum of the integers to the right of N.
//    If there is no index that would make this happen, return -1.
//
//    For example:
//
//    Let's say you are given the array {1,2,3,4,3,2,1}:
//    Your function will return the index 3, because at the 3rd position of the array, the sum of left side of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both equal 6.
//
//    Let's look at another one.
//    You are given the array {1,100,50,-51,1,1}:
//    Your function will return the index 1, because at the 1st position of the array, the sum of left side of the index ({1}) and the sum of the right side of the index ({50,-51,1,1}) both equal 1.
//
//    Last one:
//    You are given the array {20,10,-80,10,10,15,35}
//    At index 0 the left side is {}
//    The right side is {10,-80,10,10,15,35}
//    They both are equal to 0 when added. (Empty arrays are equal to 0 in this problem)
//    Index 0 is the place where the left side and right side are equal.
//
//    Note: Please remember that in most programming/scripting languages the index of an array starts at 0.
//
//    Input:
//    An integer array of length 0 < arr < 1000. The numbers in the array can be any integer positive or negative.
//
//    Output:
//    The lowest index N where the side to the left of N is equal to the side to the right of N. If you do not find an index that fits these rules, then you will return -1.
//
//    Note:
//    If you are given an array with multiple answers, return the lowest correct index.
/////////////////////////////////////////////////////////////////////////////////////////
    public static int findEvenIndex(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;
        int answer = 0;
        boolean answerChanged = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++)
                if (i == 0)
                    leftSum = 0;
                else
                    leftSum += arr[j];
            for (int k = i+1; k < arr.length; k++)
                rightSum += arr[k];
            if (leftSum == rightSum) {
                answer = i;
                answerChanged = true;
            }
            else {
                leftSum = 0;
                rightSum = 0;
            }
        }
        if (answerChanged)
            return answer;
        else
            return -1;
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    public static int findEvenIndex1(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(leftSum(arr, i) == rightSum(arr, i))
                return i;
        }

        return -1;
    }

    public static long leftSum(int[] arr,int idx){
        long result = 0;

        for(int i = 0; i < idx; i++){
            result += arr[i];
        }

        return result;
    }

    public static long rightSum(int[] arr, int idx){
        long result = 0;

        for(int i = idx + 1; i < arr.length; i++){
            result += arr[i];
        }

        return result;
    }
/////////////////////////////////////////////////////////////////////////////////////////
    public static int expressionsMatter(int a, int b, int c)
    {
        return  Math.max(Math.max(a + b + c, a * b * c),Math.max ((a + b) * c, a * (b + c)));
    }

//    Return the number (count) of vowels in the given string.
//
//    We will consider a, e, i, o, u as vowels for this Kata (but not y).
//
//    The input string will only consist of lower case letters and/or spaces.
/////////////////////////////////////////////////////////////////////////////////////////
    public static int getCount(String str) {
        int vowelsCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equalsIgnoreCase("a") ||
                    str.substring(i, i + 1).equalsIgnoreCase("e") ||
                    str.substring(i, i + 1).equalsIgnoreCase("i") ||
                    str.substring(i, i + 1).equalsIgnoreCase("o") ||
                    str.substring(i, i + 1).equalsIgnoreCase("u")) {

                vowelsCount++;
            }
        }
        return vowelsCount;
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    public static int getCount2(String str) {
        int vowelsCount = 0;

        for(char c : str.toCharArray())
            vowelsCount += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;

        return vowelsCount;
    }
/////////////////////////////////////////////////////////////////////////////////////////
//    Implement a function that accepts 3 integer values a, b, c. The function should return true if a triangle can be built with the sides of given length and false in any other case.
/////////////////////////////////////////////////////////////////////////////////////////
    public static boolean validateTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
//        System.out.println(expressionsMatter(1,3,9));
//        System.out.println(getCount("boobs"));
//        System.out.println(validateTriangle(1,2,3));
//        System.out.println(accumul("abjdls"));
        System.out.println(findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));
    }
}
