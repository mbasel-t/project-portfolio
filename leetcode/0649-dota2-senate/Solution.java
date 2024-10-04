class Solution {
    public String predictPartyVictory(String senate) {
        int rBanned = 0;
        int dBanned = 0;
        int numD = 0;
        int numR = 0;
        Queue<Character> queue = new LinkedList<Character>();

        for (char curr : senate.toCharArray()) {
            if(curr == 'R') {
                if (dBanned > 0) {
                    dBanned--;
                } else {
                    queue.add(curr);
                    rBanned++;
                    numR++;
                }
            } else {
                if (rBanned > 0) {
                    rBanned--;
                } else {
                    queue.add(curr);
                    dBanned++;
                    numD++;
                }
            }
        }

        while(Math.min(numD, numR) > 0) {
            if(queue.peek() == 'R') {
                if (dBanned > 0) {
                    dBanned--;
                    numR--;
                    queue.poll();
                } else {
                    queue.add(queue.poll());
                    rBanned++;
                }
            } else {
                if (rBanned > 0) {
                    rBanned--;
                    numD--;
                    queue.poll();
                } else {
                    queue.add(queue.poll());
                    dBanned++;
                }
            }
        }

        String result;

        if(numR > 0) {
            result = "Radiant";
        } else {
            result = "Dire";
        }

        return result;
    }
}
