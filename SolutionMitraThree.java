import java.io.*;
import java.util.*;

class Hex {
	int x;
	int y;
	int z;
	int id;
	int distance;
	boolean movable = true;
	
	public Hex(int x, int y, int z, int id, boolean movable) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
        this.movable = movable;
        if (x + y + z != 0) 
        	throw new IllegalArgumentException("x + y + z must be 0");
    }
}

public class SolutionMitraThree {
	
	public static void findPath(int totalCells, int maxChew, int start, int destination, int totalWaxedCells, String wax) {
		int rows = 	totalCells + (totalCells-1);
		Map<Integer, Hex> mapHex = new HashMap<Integer, Hex>();
		Map<String, Integer> mapXYZtoKey = new HashMap<String, Integer>();
		
		String[] waxedNumbers = wax.split(" ");
		List<Integer> waxedNumbersList = new ArrayList<Integer>();
		for(String number : waxedNumbers){
    		waxedNumbersList.add(Integer.parseInt(number));
		}
		
		
		
		int x = 0;
		int y = totalCells - 1 ;
		int z = (totalCells - 1) * -1;
		int counter = 1;
		
		boolean mid = false;
		int midRow = 0;
		int cols = totalCells-1;
		for (int i = 1 ; i <= rows ; i++) {
			if (!mid)
				cols = cols + 1;
			else
				cols = cols - 1;
			for (int j = 0 ; j < cols ; j++) {
				boolean movable = true;
				if (waxedNumbersList.contains(counter))
					movable = false;
				
				Hex node = new Hex(x, y, z, counter, movable);
				mapHex.put(counter, node);
				
				mapXYZtoKey.put(x + "" + y + "" + z, counter );
				counter++;
				x++;
				y--;
			}
			
			
			if (x != (y * -1) && !mid) {
				x = 0 - i;
				y = totalCells - 1;
				z++ ;
			}
			else if (!mid) {
				mid = true;
				midRow = i;
			}
				
			if (mid) {
				x = (totalCells - 1) * -1;
				y = (totalCells - 2) - (i - midRow);
				z ++;
			}
		}
		
		Hex startHex = mapHex.get(start);
		startHex.movable = false;
		Stack<Hex> stack = new Stack<Hex>();
		startHex.distance = 0;
		stack.push(startHex);
		//System.out.println("destination : " + destination );
		
		int cameFrom [] = new int[100]; 
		cameFrom[start] = 0; 
		while (!stack.empty()) {
			
			Hex cell = stack.pop();
			//System.out.println("distance covered : " + cell.distance);
			
			//System.out.println("id : " + cell.id);
			// if (cell.id == destination) {
// 				System.out.println(cell.distance);
// 				return;
// 			}
			
			// if (cell.distance == maxChew) {
// 				System.out.println("NO");
// 				return;
// 			}
				
			
			int neighX = cell.x + 0;
			int neighY = cell.y + 1;
 			int neighZ = cell.z - 1;
 			
				Integer id = mapXYZtoKey.get(neighX + "" + neighY + "" + neighZ);
				if (id != null) {
					Hex newCell = mapHex.get(id);
					if (newCell.movable == true) {
						newCell.distance = cell.distance+1;
						newCell.movable = false;
						cameFrom[id] = cell.id; 
						stack.push(newCell);
					}
				}
 			
 			neighX = cell.x + 1;
			neighY = cell.y + 0;
 			neighZ = cell.z - 1;
 			
 				
				 id = mapXYZtoKey.get(neighX + "" + neighY + "" + neighZ);
				if (id != null) {
					Hex newCell = mapHex.get(id);
					if (newCell.movable == true) {
						newCell.distance = cell.distance+1;
						newCell.movable = false;
						cameFrom[id] = cell.id; 
						stack.push(newCell);
					}
				}
			
			
			neighX = cell.x + 1;
			neighY = cell.y - 1;
 			neighZ = cell.z + 0;
 			
 			
				id = mapXYZtoKey.get(neighX + "" + neighY + "" + neighZ);
				if (id != null) {
				Hex newCell = mapHex.get(id);
				if (newCell.movable == true) {
					newCell.distance = cell.distance+1;
					newCell.movable = false;
					cameFrom[id] = cell.id; 
					stack.push(newCell);
				}
			}
			
			
			neighX = cell.x - 1;
			neighY = cell.y + 1;
 			neighZ = cell.z + 0;
 			
 			
				id = mapXYZtoKey.get(neighX + "" + neighY + "" + neighZ);
				if (id != null) {
				Hex newCell = mapHex.get(id);
				if (newCell.movable == true) {
					newCell.distance = cell.distance+1;
					newCell.movable = false;
					cameFrom[id] = cell.id; 
					stack.push(newCell);
				}
			}	
			
			
			neighX = cell.x - 1;
			neighY = cell.y + 0;
 			neighZ = cell.z + 1;
 			
 			
				id = mapXYZtoKey.get(neighX + "" + neighY + "" + neighZ);
				if (id != null) {
				Hex newCell = mapHex.get(id);
				if (newCell.movable == true) {
					newCell.distance = cell.distance+1;
					newCell.movable = false;
					cameFrom[id] = cell.id; 
					stack.push(newCell);
				}
			}
			
			
			neighX = cell.x + 0;
			neighY = cell.y - 1;
 			neighZ = cell.z + 1;
 			
 			
				id = mapXYZtoKey.get(neighX + "" + neighY + "" + neighZ);
				if (id != null) {
				Hex newCell = mapHex.get(id);
				if (newCell.movable == true) {
					newCell.distance = cell.distance+1;
					newCell.movable = false;
					cameFrom[id] = cell.id; 
					stack.push(newCell);
				}
			}
			
		}
		
		int countSteps = 0;
		int dest = destination;
		while (cameFrom[dest] != 0) {
			countSteps++;
			dest = cameFrom[dest];
		}
		
		if (countSteps > maxChew)
			System.out.println("NO");
		else
			System.out.println(countSteps);
		
	}
	
	
	
	
	
	
	public static void main(String args[]) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = bf.readLine();
			String wax = bf.readLine();
			
			String [] data = s.split(" ");
			int totalCells = Integer.parseInt(data[0]);
			int maxChew = Integer.parseInt(data[1]);
			int start = Integer.parseInt(data[2]);
			int destination = Integer.parseInt(data[3]);
			int totalWaxedCells = Integer.parseInt(data[4]);
			
			findPath(totalCells, maxChew, start, destination, totalWaxedCells, wax);
			
		}
	
		catch(Exception e) {
			System.out.println("Exception caught :" +e);
		}
	}
}