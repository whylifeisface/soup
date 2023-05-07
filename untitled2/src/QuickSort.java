
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    // 快速排序是什么 快速排序是对插入排序的一种优化  插入排序是对整个数组
    // 它是把数组在逻辑上慢慢变短
    // 最终实现了有序
    // (我不知道为什么 短的部分有序整个就有序了 大佬会的话可以解释一下) 实现的排序
    // 时间复杂度? 时间复杂度 nlog 在最好的情况下  log 在最坏的情况下
    // 如何实现 在数组中选择一个数作为标志位
    // 逻辑上把它放到最中间
    // 2让其他元素小于它的放到它的左边 3大于它的放到它的右边 4
    //  一直这样直到子数组的中间是本身的最右或最左
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public int[] sortArray2(int[] nums) {

        quickSort2(nums, 0, nums.length - 1);
        return nums;
    }

    //
    public void quickSort(int[] nums, int start, int end) {
        //递归实现
        if (start < end) {
            int port = port(nums, start, end);
            System.out.println();
            quickSort(nums, start, port - 1);
            quickSort(nums, port + 1, end);
        }
    }

    public void quickSort2(int[] nums, int start, int end) {
        if (start < end) {
            int port = port2(nums, start, end);
            System.out.println();
            quickSort2(nums, start, port - 1);
            quickSort2(nums, port + 1, end);
        }
    }

    public int[] randomArray(int end, int time) {
        int[] nums = new int[time];
        for (int i = 0; i < time; i++) {
            nums[i] = (int) (Math.random() * end);
        }
        return nums;
    }

    public static void main(String[] args) {
        //{4, 2, 5, 3, 6}; ok
        //{5,2,3,1}
        QuickSort quickSort = new QuickSort();
        int[] a = quickSort.randomArray(20, 8);
        quickSort.show(a);
        quickSort.sortArray2(a);
        quickSort.show(a);
    }

    public void show(int[] nums) {
        for (int a :
                nums) {
            System.out.println(a);
        }

    }

    // 单指针 一遍快排  排序开始点 结束点  // 为什么单指针有两个
    public int port(int[] nums, int start, int end) {
//       int[] a = {4, 2, 5, 3, 6};
//      排序的标志位
        int pivot = nums[start];
        //从标志位的下一位开始遍历   如果不加一 刚开始标志位 应该会等于 nums[low]
        int low = start + 1;
        int height = end;
        while (low <= height) {
            //小于标志位的说明正确  大于标志位往右边放
            if (nums[low] <= pivot) {
                low++;
            } else {
                swap(nums, low, height);
                height--;
            }
        }
        // 把标志位放到中间
        swap(nums, start, height);
        return height;
    }

    public int port2(int[] nums, int start, int end) {
//
        int pivot = nums[start];
        int low = start + 1;
        int height = end;
        while (low <= height) {
            //把左边大于标志位和（右边小于标志位的(可能) // 右边有可能全大于) 交换
            while (nums[start] <= pivot && low <= height) low++;
            while (nums[end] > pivot && low <= height) height--;
            // 亲测 没有if数组越界
            if (low < height)
                swap(nums, low, height);
        }
        swap(nums, start, height);
        return height;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
