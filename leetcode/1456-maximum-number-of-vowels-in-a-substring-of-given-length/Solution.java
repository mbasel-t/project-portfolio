class Solution {
    public int maxVowels(String s, int k) {
        char[] input = s.toCharArray();

        int numVowels = 0;
        int maxNumVowels = 0;
        int i = input.length-1;

        while(maxNumVowels < k && i + numVowels >= maxNumVowels) {
            if (input.length > i+k && (input[i+k] == 'a' || input[i+k] == 'e' || input[i+k] == 'i' || input[i+k] == 'o' || input[i+k] == 'u'))
                numVowels--;

            if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
                if(maxNumVowels == numVowels)
                    maxNumVowels++;
                numVowels++;
            }
            i--;
        }
        return maxNumVowels;
    }
}
