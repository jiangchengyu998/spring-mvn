package jksj.quick;


public class QuickSort {

    public static void main(String[] args) {
        int[] orderly = new int[]{2,4,3,1,5,6,1 };

        QuickSort quickSort = new QuickSort();
        quickSort.quick_sort(orderly, orderly.length);
        for (int i : orderly) {
            System.out.println(i);

        }
    }

    private void quick_sort(int[] a, int n) {
        quick_sort(a, 0, n - 1);
    }

    private void quick_sort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quick_sort(a, p, q - 1);
        quick_sort(a, q+1, r);
    }

    private int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r - 1; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i += 1;
            }
        }
        swap(a, i, r);

        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
