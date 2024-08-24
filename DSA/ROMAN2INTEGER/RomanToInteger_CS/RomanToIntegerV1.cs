namespace csharp;

public class RomanToIntegerV1
{
    public static int RomanToInt(string s) {
        var sum = 0;
        var pre = 0;

        for (var i = s.Length - 1; i >= 0; i--) {
            var current = RomanToValue(s[i]);

            if (current < pre) {
                sum -= current;
            } else {
                sum += current;
            }

            pre = current;
        }

        return sum;
    }

    private static int RomanToValue(char ch)
    {
        return ch switch
        {
            'I' => 1,
            'V' => 5,
            'X' => 10,
            'L' => 50,
            'C' => 100,
            'D' => 500,
            'M' => 1000,
            _ => 0
        };
    }
}