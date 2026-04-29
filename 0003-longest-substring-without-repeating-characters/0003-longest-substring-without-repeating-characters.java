class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
            
            for (int i = 0; i < s.length(); i++){
                HashSet<Character> hashSet = new HashSet<>();

                int len = findNonDuplicatedLengthRecursive(s, hashSet, i, 0);

                if (len >= max)
                    max = len;

                if (i + len >= s.length())
                    break;
            }

            return max;
    }
    public int findNonDuplicatedLengthRecursive(String s, HashSet<Character> hashSet, int index, int length){
            if (index >= s.length())
                return length;

            if (hashSet.contains(s.charAt(index)))
                return length;
            else {
                hashSet.add(s.charAt(index));
                return findNonDuplicatedLengthRecursive(s, hashSet, index + 1, length + 1);
            }
        }
}