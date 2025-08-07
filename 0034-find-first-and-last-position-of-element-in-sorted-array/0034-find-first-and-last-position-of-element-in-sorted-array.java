class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurance(nums, target, 0);
        int last = lastOccurance(nums, target, 0);
        return new int[]{first, last};
    }

    public int firstOccurance(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        } else if (arr[i] == key) {
            return i;
        }
        return firstOccurance(arr, key, i + 1);
    }

    public int lastOccurance(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        int found = lastOccurance(arr, key, i + 1);
        if (found == -1 && arr[i] == key) {
            return i;
        }
        return found;
    }
}
