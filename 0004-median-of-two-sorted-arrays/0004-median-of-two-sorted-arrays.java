class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0))
                return 0.0;

            if ((nums1 == null || nums1.length == 0)){
                int n = nums2.length;
                int m = n / 2;

                return (n % 2 == 0) ? (nums2[m - 1] + nums2[m]) / 2.0 :  nums2[m];
            }
            if ((nums2 == null || nums2.length == 0)){
                int n = nums1.length;
                int m = n / 2;

                return (n % 2 == 0) ? (nums1[m - 1] + nums1[m]) / 2.0 :  nums1[m];
            }

            List<Integer> list = new ArrayList<>(Arrays.stream(nums1)
                    .boxed()
                    .toList());

            int lastIndex = 0;
            // nums1에 num2를 순차적으로 오름차순으로 sorting
            for (int i : nums2) {
                for (int j = lastIndex; j < list.size(); j++) {
                    if (i <= list.get(j)) {
                        list.add(j, i);
                        lastIndex = j;
                        break;
                    }

                    if (j == list.size() - 1) {
                        list.add(i);
                        lastIndex = list.size() - 1;
                        break;
                    }
                }
            }

            int n = list.size();
            int m = n / 2;

            return (n % 2 == 0)
                    ? (list.get(m - 1) + list.get(m)) / 2.0
                    : list.get(m);
        
    }
}