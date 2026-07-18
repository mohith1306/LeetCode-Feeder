class Solution {
    public static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
        return Math.abs(a);
    }
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0],nums[nums.length-1]);
    }
}