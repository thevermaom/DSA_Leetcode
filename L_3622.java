class L_3622 {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int temp = n;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        
        int total = sum + product;
        
        return n % total == 0;
    }
}