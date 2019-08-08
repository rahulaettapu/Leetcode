
//Source : https://leetcode.com/problems/number-of-matching-subsequences/discuss/259421/Simple-Java-solution-using-HashMap

class Solution {

    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<Integer>());
            }
            map.get(ch).add(i);
        }

        for (String word: words) {
            int index = -1;
            boolean isValid = true;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                boolean flag = false;
                if (!map.containsKey(ch)) {
                    isValid = false;
                    break;
                }
                List<Integer> list = map.get(ch);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) > index) {
                        flag = true;
                        index = list.get(j);
                        break;
                    }
                }
                if (!flag) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                count++;
            }
        }
        return count;
    }
}