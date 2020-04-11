https://app.codesignal.com/interview-practice/task/uX5iLwhc6L5ckSyNC/solutions

char firstNotRepeatingCharacter(String s) {
    char ans = '_';

    int [] check = new int[26];
    int [] index = new int[26];
    int len = s.length();

    for (int i = 0 ; i < len ; i ++) {
        int curr = (int) s.charAt(i);
        check[curr-97]++;
        index[curr-97] = i;
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0 ; i < 26 ; i++) {
        if (check[i] == 1 && index[i] < min) {
            min = index[i];
            ans = s.charAt(min);
        }
    }

    

    return ans;
}
