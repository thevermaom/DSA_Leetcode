class L_1927 {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;

        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                leftQ++;
            } else {
                leftSum += c - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                rightQ++;
            } else {
                rightSum += c - '0';
            }
        }

        // If the total number of '?' is odd, Alice can always force a win
        if ((leftQ + rightQ) % 2 != 0) {
            return true;
        }

        // Bob wins (returns false) if the sum difference perfectly offsets the '?' difference
        // Otherwise, Alice wins (returns true)
        return (leftSum - rightSum) != (rightQ - leftQ) * 9 / 2;
    }
}