class Solution:
    def romanToInt(self, s: str) -> int:
        sum = 0
        x, y = 0, 0
        for i in range(len(s)):
            if s[i] == 'I':
                x = 1
            elif s[i] == 'V':
                x = 5
            elif s[i] == 'X':
                x = 10
            elif s[i] == 'L':
                x = 50
            elif s[i] == 'C':
                x = 100
            elif s[i] == 'D':
                x = 500
            elif s[i] == 'M':
                x = 1000
            else:
                return -1

            if i < len(s) - 1:
                if s[i + 1] == 'I':
                    y = 1
                elif s[i + 1] == 'V':
                    y = 5
                elif s[i + 1] == 'X':
                    y = 10
                elif s[i + 1] == 'L':
                    y = 50
                elif s[i + 1] == 'C':
                    y = 100
                elif s[i + 1] == 'D':
                    y = 500
                elif s[i + 1] == 'M':
                    y = 1000
                else:
                    return -1

            if x < y:
                sum -= x
            else:
                sum += x
        return sum
