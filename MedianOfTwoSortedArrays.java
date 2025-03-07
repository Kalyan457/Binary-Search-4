public class MedianOfTwoSortedArrays {
    // TC: O(log Math.min(m, n)) where m is length of nums1, n is length of nums2;
    // SC: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int left = 0, right = n1;
        int totalLen = n1 + n2;
        while (left <= right) {
            int partX = left + (right - left) / 2;
            int partY = totalLen / 2 - partX;
            int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            if (l1 <= r2 && l2 <= r1) {
                if (totalLen % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l2 > r1) {
                left = partX + 1;
            } else {
                right = partX - 1;
            }
        }
        return -1;
    }
}
