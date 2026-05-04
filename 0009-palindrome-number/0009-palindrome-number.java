class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
                return false;

            if (x < 10)
                return true;

            String str = String.valueOf(x);

            int len = str.length();

            String substr =  str.substring(0, len / 2);
            int j = 0;

            for (int i = len - 1; i > len - 1 - substr.length(); i--){
                if (str.charAt(i) != substr.charAt(j))
                    return false;

                j++;
            }

            return true;
    }
}