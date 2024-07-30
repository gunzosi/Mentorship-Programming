def roman_to_value(ch: str) -> int:
    roman_dict = {
        'I': 1, 'V': 5, 'X': 10, 'L': 50,
        'C': 100, 'D': 500, 'M': 1000
    }
    return roman_dict.get(ch, 0)


class Solution:
    @staticmethod
    def romanToInt(s: str) -> int:
        total = 0
        pre = 0

        for i in range(len(s) - 1, -1, -1):
            current = roman_to_value(s[i])
            if current < pre:
                total -= current
            else:
                total += current
            pre = current

        return total


# Test cases
print(Solution.romanToInt("III"))  # 3
print(Solution.romanToInt("IV"))  # 4
print(Solution.romanToInt("IX"))  # 9
print(Solution.romanToInt("LVIII"))  # 58
print(Solution.romanToInt("MCMXCIV"))  # 1994
