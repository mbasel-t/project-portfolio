class Solution {
    public int maxArea(int[] height) {
        int highestArea = 0;
        int bottomPoint = 0;
        int topPoint = height.length-1;

        while (bottomPoint < topPoint) {
            if (height[bottomPoint] < height[topPoint]) {
                highestArea = Math.max(highestArea, height[bottomPoint] * (topPoint - bottomPoint));
                bottomPoint++;
            } else {
                highestArea = Math.max(highestArea, height[topPoint] * (topPoint - bottomPoint));
                topPoint--;
            }
        }

        return highestArea;
    }

    private static int computeArea(int height1, int height2, int diff) {
        return Math.min(height1, height2) * diff;
    }
}
