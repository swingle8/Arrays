https://www.geeksforgeeks.org/count-of-common-multiples-of-two-numbers-in-a-range/
//Given a number A, we have to figure out all the common multiples of B and C till the number A

public class Solution {
    public int solve(int A, int B, int C) {
         int count = 0;
    int lcm = ((B*C)/gcd(B, C));
    if (lcm > A)
        return 0;
    
    count = A/lcm;
    return count;
}

    public int gcd (int B, int C) {
    if (B < C) {
        int temp = B;
        B = C;
        C = temp;
    }
    
    if (C == 0)
        return B;
    
    return gcd (C, B%C);
}
}
