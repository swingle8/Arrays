https://leetcode.com/problems/merge-intervals/


class Solution {
    public int[][] merge(int[][] intervals) {
        int rows = intervals.length;
        if (rows < 2) {
            return intervals;
        }
        
        Arrays.sort(intervals, new Comparator<int []>() {
            public int compare(int [] i1, int [] i2) 
            { 
                if (i1[0] > i2[0])
                    return 1;
                else if (i1[0] < i2[0])
                    return -1;
                else
                    return i1[0] - i2[0];
            }
        });
        
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        
        int removalCount = 0;
        
        for (int i = 1 ; i < rows ; i ++) {
            if ((intervals[i][0] >= prevStart && intervals[i][0] <= prevEnd) || (intervals[i][0] < prevStart && intervals[i][1] >= prevStart)) {
                if (prevEnd < intervals[i][1]) { 
                    intervals[i-1][1] = intervals[i][1];
                    prevEnd = intervals[i-1][1];
                }
                if (prevStart > intervals[i][0]) { 
                    intervals[i-1][0] = intervals[i][0];
                    prevStart = intervals[i-1][0];
                }
                
                
                intervals[i][0] = -1;
                intervals[i][1] = -1;
                
                intervals[i-1][0] = intervals[i][0];
                intervals[i-1][1] = intervals[i][1];
                intervals[i][0] = prevStart;
                intervals[i][1] = prevEnd;
                
                removalCount++;
            }
            else if (intervals[i][0] < prevStart && intervals[i][1] < prevStart) {
                intervals[i-1][0] = intervals[i][0];
                intervals[i-1][1] = intervals[i][1];
                intervals[i][0] = prevStart;
                intervals[i][1] = prevEnd;
            }
            else {
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            }
        }
        
       int[][] intervalsNew = new int[rows-removalCount][2];
        int k = 0;
        for (int i = 0 ; i < rows ; i ++) {
            if (intervals[i][0] == -1 && intervals[i][1] == -1) {
                continue;
            }
            else {
                //System.out.println(intervals[i][0] + " test " + intervals[i][1]);
                intervalsNew[k][0] = intervals[i][0];
                intervalsNew[k][1] = intervals[i][1];
                k++;
            }
        }
        
        return intervalsNew;
    }
}