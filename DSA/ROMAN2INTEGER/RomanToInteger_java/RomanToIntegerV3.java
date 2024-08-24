package RomanToInteger;

public class RomanToIntegerV3 {

    public static void main(String[] args) {
        RomanToIntegerV3 romanToInteger = new RomanToIntegerV3();
        System.out.println(romanToInteger.romanToInt("MCMXCIV")); // 1994
        System.out.println(romanToInteger.romanToInt("IV")); // 4
        System.out.println(romanToInteger.romanToInt("III")); // 3
        System.out.println(romanToInteger.romanToInt("IV")); // 4
        System.out.println(romanToInteger.romanToInt("IX")); // 9
        System.out.println(romanToInteger.romanToInt("LVIII")); // 58
    }

    public int romanToInt(String s) {
        int sum = 0;
        int x, y = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I' -> x = 1;
                case 'V' -> x = 5;
                case 'X' -> x = 10;
                case 'L' -> x = 50;
                case 'C' -> x = 100;
                case 'D' -> x = 500;
                case 'M' -> x = 1000;
                default -> {  return -1; }
            }

            if (i < s.length() - 1) {
                switch (s.charAt(i + 1)) {
                    case 'I' -> y = 1;
                    case 'V' -> y = 5;
                    case 'X' -> y = 10;
                    case 'L' -> y = 50;
                    case 'C' -> y = 100;
                    case 'D' -> y = 500;
                    case 'M' -> y = 1000;
                    default -> { return -1; }
                }
            }
            if (x < y) {
                sum -= x;
            } else {
                sum += x;
            }

        }
        return sum;
    }
}
