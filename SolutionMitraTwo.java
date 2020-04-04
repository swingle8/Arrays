import java.io.*;
public class SolutionMitraTwo {
	
	public static boolean checkSpacing(String s) {	
		boolean flag = true;
		int noOfStars = 0;
		
		for(int i=0 ; i<s.length();i++) {
			if(s.charAt(i)=='*')
				noOfStars ++;
		}
		
		String count[] = s.trim().split("\\*");
			
		if((count.length!=0)&&(noOfStars > count.length)) {
			flag = false;
		}
		
		else if(noOfStars == count.length) {
			int compare = count[1].length();
			for(int i=2;i<count.length;i++) {
				if(count[i].length() != compare) {
					flag = false;
					break;
				}
			}
		}
		
		return flag;
	}
	
	public static void main(String args[]) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		int number = 1;
		try {
			while(!((s = bf.readLine()).equals("END"))) {
				if(checkSpacing(s))
					System.out.println( number + " EVEN");
				else
					System.out.println( number + " NOT EVEN");
					
				number ++;
			}
		}
	
		catch(Exception e) {
			System.out.println("Exception caught :" +e);
		}
	}
}