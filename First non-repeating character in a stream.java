// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution
{
    public String FirstNonRepeating(String A)
    {
        String ans = new String(); 
        int len = A.length();
        ArrayList<Character> al = new ArrayList<Character>();
        int [] repeat = new int[26]; 
        
        for (int i = 0 ; i < len ; i++) {
            char current = A.charAt(i);
            if (repeat[current-97] == 0) {
                if (al.contains(current)) {
                    al.remove((Character)current);
                    repeat[current-97] = 1;
                }
                else
                    al.add(current);
            }
            if (al.size() == 0)
                ans = ans + "#";
            else
                ans = ans + al.get(0);
        }
        return ans.toString();
    }
}