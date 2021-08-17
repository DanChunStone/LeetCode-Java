package Problem;

public class Pro004_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Pro004_MedianOfTwoSortedArrays obj = new Pro004_MedianOfTwoSortedArrays();

        int[] nums1 = new int[] {2};
        int[] nums2 = new int[] {0};

        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 题解版本，O(log(m + n))
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length == 0)
            return 0;
        if (nums1.length == 0) {
            return nums2.length % 2 == 0
                    ? (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0
                    : nums2[nums2.length / 2];
        }
        if (nums2.length == 0) {
            return nums1.length % 2 == 0
                    ? (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0
                    : nums1[nums1.length / 2];
        }
        if (length % 2 == 0) {
            return (findKNumsSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, length / 2) +
                    findKNumsSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, length / 2 + 1)) / 2.0;
        }
        return findKNumsSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, length / 2 + 1);
    }

    public double findKNumsSortedArrays(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        int center = k / 2;

        if (center == 0) {
            return Math.min(nums1[left1], nums2[left2]);
        }
        int index1 = Math.min(left1 + center - 1, right1 - 1);
        int index2 = Math.min(left2 + center - 1, right2 - 1);
        if (nums1[index1] < nums2[index2]) {
            if (index1 == right1 - 1) {
                return nums2[left2 + k - (right1 - left1) - 1];
            }
            return findKNumsSortedArrays(nums1, left1 + center, right1, nums2, left2, right2, k - center);
        } else {
            if (index2 == right2 - 1) {
                return nums1[left1 + k - (right2 - left2) - 1];
            }
            return findKNumsSortedArrays(nums1, left1, right1, nums2, left2 + center, right2, k - center);
        }
    }

    /**
     * 自己版本，O(m + n)
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int length = nums1.length + nums2.length;
//        double center1 = 0, center2 = 0;
//
//        int index = 0, left = 0, right = 0;
//        while (index <= length / 2) {
//            center1 = center2;
//            if (right >= nums2.length) {
//                center2 = nums1[left];
//                left++;
//            } else if (left >= nums1.length) {
//                center2 = nums2[right];
//                right++;
//            } else if (nums1[left] >= nums2[right]) {
//                center2 = nums2[right];
//                right++;
//            } else {
//                center2 = nums1[left];
//                left++;
//            }
//            index++;
//        }
//
//        if (length % 2 == 0)
//            return (center1 + center2) / 2.0;
//        return center2;
//    }
}
