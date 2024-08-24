nearestPalindrome = 0
minDifference = MAX_LONG_VALUE
for each candidate in candidates:
    if candidate == number:
        continue
    difference = abs(candidate - number)
    if difference < minDifference OR (difference == minDifference AND candidate < nearestPalindrome):
        minDifference = difference
        nearestPalindrome = candidate