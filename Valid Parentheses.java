// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
// Example 4:

// Input: s = "([)]"
// Output: false
// Example 5:

// Input: s = "{[]}"
// Output: true
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.





class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n%2 != 0)
            return false;
        Stack<Character> st = new Stack<Character>();
        for (int i = 0 ; i < n  ; i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[')
                st.push(curr);
            else if (curr == ')') {
                if (! st.isEmpty() && st.pop() == '(')
                    continue;
                else
                    return false;
            }
            else if (curr == '}') {
                if (! st.isEmpty() && st.pop() == '{')
                    continue;
                else
                    return false;
            }
            else if (curr == ']') {
                 if (! st.isEmpty() && st.pop() == '[')
                    continue;
                else
                    return false;
            }
        }
        
        if (st.isEmpty())
            return true;
        return false;
    }
}