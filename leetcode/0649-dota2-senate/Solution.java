class Solution {
    public String predictPartyVictory(String senate) {
        int prevSize = senate.length()+1;
        int rBanned = 0;
        int dBanned = 0;
        Queue<Character> queue = new LinkedList<Character>();

        for (char c : senate.toCharArray())
            queue.offer(c);

        while(queue.size() < prevSize) {
            prevSize = queue.size();
            for(int i = 0; i < prevSize; i++) {
                char curr = queue.poll();

                if(curr == 'R') {
                    if (dBanned > 0) {
                        dBanned--;
                    } else {
                        queue.add(curr);
                        rBanned++;
                    }
                } else {
                    if (rBanned > 0) {
                        rBanned--;
                    } else {
                        queue.add(curr);
                        dBanned++;
                    }
                }
            }
        }

        String result;

        if(dBanned == 0) {
            result = "Radiant";
        } else {
            result = "Dire";
        }

        return result;
    }
}
