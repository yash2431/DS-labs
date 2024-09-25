public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                  
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                  
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sorter = new SortColors();
        
        
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        sorter.sortColors(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); 

    
        int[] nums2 = {2, 0, 1};
        sorter.sortColors(nums2);
        System.out.println(java.util.Arrays.toString(nums2));
    }
}
