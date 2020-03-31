class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int lenIntervals = intervals.length;
        if (lenIntervals == 0) {
            int  [][] result = new int[1][2];
            result[0][0] = newInterval[0];
            result[0][1] = newInterval[1];
            return result;
        }
            
        
        
        int cellX = -1;
        int newCellLocation = -1;
        int newRightIntervals = newInterval[1];
        int newLeftIntervals = newInterval[0];
        //System.out.println (newLeftIntervals);
            
        int [][] newIntervals = new int[lenIntervals+1][2];
        boolean set = false;
        int k = 0;
        for (int i = 0 ; i < lenIntervals ; i++) {
            int leftIntervals = intervals[i][0];
            int rightIntervals = intervals[i][1];
            
             newIntervals[k][0] = leftIntervals;
            newIntervals[k][1] = rightIntervals;
            
            
            if (newLeftIntervals >= leftIntervals && newLeftIntervals <= rightIntervals) {
                cellX = i;
                break;
            }
            else if (newLeftIntervals < leftIntervals && !set) {
                newCellLocation = i;
                newIntervals[k][0] = newLeftIntervals;
                newIntervals[k][1] = newRightIntervals;
                i--;
                //k++;
                set = true;
            }
            
           
            k++;
            
        }
        
        
        
        if (!set && cellX == -1) {
           newIntervals[lenIntervals][0] =  newLeftIntervals;
           newIntervals[lenIntervals][1] =  newRightIntervals;
            return newIntervals;
        }
        
        if (cellX != -1) {
            //int currNodeRight = intervals[cellX][1];
            intervals = findEnd (cellX+1, intervals, newRightIntervals);
            // if (intervals[cellX][1] != newRightIntervals)
            //         intervals[cellX][1] = newRightIntervals;
            
            return intervals;
        }
        
        if (newCellLocation != -1) {
            //System.out.println(newIntervals[newCellLocation][0]);
            newIntervals = findEnd(newCellLocation+1, newIntervals, newRightIntervals);
            return newIntervals;
        }
        
        
        return newIntervals;
        }
        
    
    
    public int [][] findEnd (int start, int [][] interval, int right) {
        int lenIntervals = interval.length;
        if (start >= lenIntervals) {
            if (interval[start-1][1] < right)
                interval[start-1][1] = right;
         return interval;
        }
            
        
        for (int i = start ; i < lenIntervals ; i++) {
            int leftIntervals = interval[i][0];
            int rightIntervals = interval[i][1];
            
            if (right < leftIntervals) {
                if (right > interval[start-1][1]) {
                    interval[start-1][1] = right;
                    break;
                }
            }
            
            else if (right >= leftIntervals && right <= rightIntervals) {
                    interval[start-1][1] = rightIntervals;
                    // if (interval[start-1][0] < interval[start][0])
                    //     interval[start-1][0] = rightIntervals;
                
                    interval[i][0] = -1;
                    interval[i][1] = -1;
            }
            
            else if (right > rightIntervals) {
                if (interval[start-1][1] < right)
                   interval[start-1][1] = right; 
                interval[i][0] = -1;
                interval[i][1] = -1;
            }
        }
    
       // for (int k = 0 ; k < interval.length ; k ++) 
       //  System.out.println(interval[k][0] + " " + interval[k][1]);
        
       int lastRight = interval[start-1][1];
       int currRemove = -1;
        int zeroElem = 0;
       for (int i = start ; i < lenIntervals ; i++) {
           
           if (0 > interval[i][0] && 0 > interval[i][1])
                zeroElem++;
           else
                lastRight = interval[i][1]; 
       }
        
        int j = 0;
        int [][] intervals = new int[lenIntervals-zeroElem][2];
        for (int i = 0 ; i < interval.length ; i++) {
            if (interval[i][0] >= 0 && interval[i][1] >= 0) {
                intervals[j][0] = interval[i][0];
                intervals[j][1] = interval[i][1];
                j++;
            }
        }
        
      return intervals;  
      
    }
    }