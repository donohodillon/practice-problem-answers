public class CodeWars1 {
    public static int expressionsMatter(int a, int b, int c)
    {
        return  Math.max(Math.max(a + b + c, a * b * c),Math.max ((a + b) * c, a * (b + c)));
    }

//    Return the number (count) of vowels in the given string.
//
//    We will consider a, e, i, o, u as vowels for this Kata (but not y).
//
//    The input string will only consist of lower case letters and/or spaces.

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

    public static int getCount2(String str) {
        int vowelsCount = 0;

        for(char c : str.toCharArray())
            vowelsCount += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;

        return vowelsCount;
    }

//    Implement a function that accepts 3 integer values a, b, c. The function should return true if a triangle can be built with the sides of given length and false in any other case.

    public static boolean validateTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static void main(String[] args) {
//        System.out.println(expressionsMatter(1,3,9));
//        System.out.println(getCount("boobs"));
//        System.out.println(validateTriangle(1,2,3));
    }
}
