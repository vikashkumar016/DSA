
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;

        // Merge the two arrays
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }

        // Add remaining elements
        while (i < n) {
            list.add(nums1[i]);
            i++;
        }

        while (j < m) {
            list.add(nums2[j]);
            j++;
        }

        // Find median
        int size = list.size();

        if (size % 2 == 1) {
            return list.get(size / 2);
        } else {
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
        }
    }
}