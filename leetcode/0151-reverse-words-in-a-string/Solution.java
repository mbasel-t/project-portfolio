class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        int i = words.length-1;
        
        while (result.length() == 0 && i >= 0) {
            result.append(words[i--]);
        }
        while (i >= 0) {
            if (!words[i].equals("")) {
                result.append(" ");
                result.append(words[i]);
            }
            i--;
        }

        return result.toString();
    }
}
