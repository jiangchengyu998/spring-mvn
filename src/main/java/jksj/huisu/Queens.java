package jksj.huisu;

public class Queens {
    public static void main(String[] args) {
        Queens queens = new Queens();
        queens.cal8queens(0);

    }
    // 下标表示行，值表示queen存储在哪一行
    int[] result = new int[8];

    // 调用方式：cal8queens(0);
    public void cal8queens(int row){
        // 8个棋子都放置好了，打印结果
        if (row == 8) {
            printQueens(result);
            return;
        }

        // 每一行都有8种放法
        for (int column = 0; column < 8; column++) {
            // 有些放法不满足
            if (isOK(row, column)) {
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 判断row行column列放置是否合适
     *
     * @param row
     * @param column
     * @return
     */
    private boolean isOK(int row, int column) {
        int leftup = column - 1, rightup = column + 1;
        // 逐行往上考查每一行
        for (int i = row - 1; i >= 0; --i) {
            // 第i行的column列有棋子吗？
            if (result[i] == column) return false;
            // 考察左上对角线：第i行leftup列有棋子吗？
            if (leftup >= 0){
                if (result[i] == leftup) return false;
            }
            // 考察右上角对角线：第i行rightup列有棋子吗？
            if (rightup < 8){
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

}
