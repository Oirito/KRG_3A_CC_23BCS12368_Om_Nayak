import java.util.*;

class exp10_1 {

    static class Pair {
        int val, index;
        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1, result);
        return result;
    }

    private static  void mergeSort(Pair[] arr, int left, int right, int[] result) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, result);
        mergeSort(arr, mid + 1, right, result);
        merge(arr, left, mid, right, result);
    }

    private static void merge(Pair[] arr, int left, int mid, int right, int[] result) {
        Pair[] temp = new Pair[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[j].val < arr[i].val) {
                rightCount++;
                temp[k++] = arr[j++];
            } else {
                result[arr[i].index] += rightCount;
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            result[arr[i].index] += rightCount;
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {5, 2, 6, 1};

        int[] result = countSmaller(nums);

        System.out.println("Output:");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}

