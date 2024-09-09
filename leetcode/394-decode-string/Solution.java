class Solution {
    public String decodeString(String s) {
        char[] input = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int i = 0;

        return evaluateString(input).toString();
    }

    /* call as "evaluateCommand(Arrays.copyOfRange(input, i, j));",
     * where:
     * i = index of the integer, and
     * j = the index of the closing bracket
    */
    private char[] evaluateCommand(char[] input) {
        // find num of times to repeat input
        int i = 1;
        while(input[i] != '[') {
            i++;
        }
        int count = Integer.parseInt(new String(Arrays.copyOfRange(input, 0, i)));

        // get the thing to repeat
        char[] repeat = evaluateString(Arrays.copyOfRange(input, i+1, input.length)).toString().toCharArray();


        // actually build the output
        char[] output = new char[repeat.length * count];

        i = 0;
        while(i < output.length) {
            for (char item : repeat) {
                output[i++] = item;
            }
        }

        return output;
    }

    /* call as "evaluateString(Arrays.copyOfRange(input, i, j));",
     * where:
     * i = index of the start of the string, and
     * j = the index of the closing bracket
    */
    private StringBuilder evaluateString(char[] input) {
        StringBuilder output = new StringBuilder();

        int i = 0;
        while(i < input.length) {
            if((int)input[i] >= (int)'0' && input[i] <= (int)'9') {
                int j = i+1;

                // find the encapsulating bracket
                while(input[j] != '[') {
                    j++;
                }

                j++;

                // find the closing bracket
                Stack<Integer> counter = new Stack<Integer>();
                while(!(input[j] == ']' && counter.isEmpty())) {
                    if(input[j] == '[') {
                        counter.push(0);
                    } else if (input[j] == ']') {
                        counter.pop();
                    }
                    j++;
                }

                // process
                output.append(evaluateCommand(Arrays.copyOfRange(input, i, j)));
                i = j+1;
            } else {
                output.append(input[i++]);
            }
        }
        return output;
    }
}
