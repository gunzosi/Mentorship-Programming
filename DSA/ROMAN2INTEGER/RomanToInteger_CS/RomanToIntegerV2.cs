﻿namespace csharp;

public class RomanToIntegerV2 {
    

    public static int RomanToInt(string s) {
        Dictionary<char, int> m = new Dictionary<char, int> {
            { 'I', 1 },
            { 'V', 5 },
            { 'X', 10 },
            { 'L', 50 },
            { 'C', 100 },
            { 'D', 500 },
            { 'M', 1000 }
        };

        var ans = 0;

        for (var i = 0; i < s.Length; i++) {
            if (i < s.Length - 1 && m[s[i]] < m[s[i + 1]]) {
                ans -= m[s[i]];
            } else {
                ans += m[s[i]];
            }
        }

        return ans;
    }
}