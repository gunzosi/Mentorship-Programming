namespace csharp;

public class RomanToIntegerV3 {
    public int RomanToInt(string s) {
        var sum = 0;
        int x = 0, y = 0;
        for (var i = 0; i < s.Length; i++) {
            switch (s[i]) {
                case 'I': x = 1; break;
                case 'V': x = 5; break;
                case 'X': x = 10; break;
                case 'L': x = 50; break;
                case 'C': x = 100; break;
                case 'D': x = 500; break;
                case 'M': x = 1000; break;
                default: return -1;
            }

            if (i < s.Length - 1) {
                switch (s[i + 1]) {
                    case 'I': y = 1; break;
                    case 'V': y = 5; break;
                    case 'X': y = 10; break;
                    case 'L': y = 50; break;
                    case 'C': y = 100; break;
                    case 'D': y = 500; break;
                    case 'M': y = 1000; break;
                    default: return -1;
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
