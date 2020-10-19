package jksj;

public class Reduce {

    private static int num = 0;

    public static int orderly(int[] orderly) {
        int length = orderly.length;
        int nums = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (orderly[i] > orderly[j]) {
                    nums++;
                }
            }
        }

        return nums;
    }

    /**
     *
     * @param a 数组
     * @param p 数组的第一位
     * @param r 数组的最后一位
     */
    private static void mergeSortCounting(int[] a, int p, int r) {
        if (p >= r) return;
        int q = (p+r) / 2;  // 中位数
        mergeSortCounting(a, p, q);
        mergeSortCounting(a, q + 1, r);

        merge(a, p, q, r);
    }

    /**
     *  合并函数：
     *  合并数组a中的p-q位，和q+1到r位
     *
     * @param a 原始数组
     * @param p 数组的第一位
     * @param q 数组的中位数
     * @param r 数组的最后一位数
     */
    private static void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                num += q - i + 1;
                tmp[k++] = a[j++];
            }
        }
        while (i <= q) {
            tmp[k++] = a[i++];
        }
        while (j <= r) {
            tmp[k++] = a[j++];
        }
        for (i = 0; i <= r - p; i++) {
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] orderly = new int[]{2,4,3,1,5,6,1 };

        System.out.println(Reduce.orderly(orderly));
        Reduce.mergeSortCounting(orderly, 0, orderly.length - 1);
        for (int i : orderly) {
            System.out.println(i);
        }
        System.out.println(Reduce.num);
    }
}




















