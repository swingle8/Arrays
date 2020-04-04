import java.io.*;

public class SolutionMitraTwo {
	
	public static void checkSpacing(String s) {
	
	int count =0;
	for( int i = 0 ; i < s.length ; i++ ) {
		if(s[0].equals('*'))
		count++;
	
	}
	System.out.println(count);
	
	}
	
	
	
	
	public static void main(String args[]) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while((String s = bf.readLine())!="END") {
				checkSpacing(s);
			
			}
			
			
			
			
			
			
			
		
			
		}
	
		catch(Exception e) {
			System.out.println("Exception caught :" +e);
		}
		
		
		
		
		
	}
}