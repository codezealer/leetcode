package me.codezealer.leetcode;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *       ↑   ↑
 */

public class _461_HammingDistance {


    /**
     * 通过异或运算得到一个数，这个数就是包含所有不相同的位
     * 然后通过取模得到不一致的位数
     * @param x
     * @param y
     * @return
     */

    public static int hammingDistance(int x, int y) {
        int res = x ^ y;
        int sum = 0;
        while (res > 0) {
            int mod = res % 2;
            if (mod != 0) {
                sum ++;
            }
            res = res >> 1;
        }
        return sum;
    }

    /**
     * 异或之后，直接用Integer的bitCount函数
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
