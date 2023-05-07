import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Sort {
    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        int length = list.size();
        int temp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (list.get(j - 1) > list.get(j)) {
                    temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> list) {
        littleQuickSort2(list, 0, list.size() - 1);
        return list;
    }

    public static void littleQuickSort2(ArrayList<Integer> list, int low, int height) {
        Integer integer = list.get(low);
        int key = low;
        int i = low, j = height;
        while (i < j) {
            if (list.get(j) < integer && i < j) {
                list.set(key, list.get(j));
                key = j;
            } else j--;
            if (list.get(i) > integer && i < j) {
                list.set(key, list.get(i));
                key = i;
            } else i++;
        }
        list.set(key, integer);
        System.out.println();
        if (low < key - 1) {
            littleQuickSort2(list, low, key - 1);
        }

        if (key + 1 < height) {
            littleQuickSort2(list, key + 1, height);
        }

    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static void littleQuickSort(ArrayList<Integer> list, int low, int height) {
        Integer integer = list.get(low);
        int key = low;
        int i = low, j = height;
        while (i < j) {
            if (Objects.equals(list.get(i), list.get(j))) {
                if (integer <= list.get(i)) {
                    i++;
                    key = i;
                    break;
                } else {
                    j--;
                }
            }
            if (list.get(j) > integer) j--;
            else {
                list.set(j, list.get(i));
                list.set(key, 0);
                key = j;
            }
            if (list.get(i) < integer) i++;
            else {
                list.set(i, list.get(j));
                list.set(key, 0);
                key = i;
            }
        }
        list.set(key, integer);
        if (key - 1 > low)
            littleQuickSort(list, low, key - 1);
        if (key + 1 < height)
            littleQuickSort(list, key + 1, height);
    }

    public static void change(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public int[] sortArray(int[] nums) {
        littleSortArray(nums, 0, nums.length - 1);
        return nums;
    }

    public void littleSortArray(int[] nums, int low, int height) {
        Integer integer = nums[low];
        int key = low;
        int i = low, j = height;
        while (i < j) {
            if (nums[j] > integer) j--;
            else {
                nums[key] = nums[j];
                nums[j] = 0;

                key = j;
            }
            if (nums[i] < integer && i < key) i++;
            else {
                nums[key] = nums[i];
                nums[i] = 0;

                key = i;
            }
        }
        nums[key] = integer;
        if (key - 1 > low)
            littleSortArray(nums, low, key - 1);
        if (key + 1 < height)
            littleSortArray(nums, key + 1, height);

    }

    public static void countingSort() {
        return;
    }

    public static void main(String[] args) {
        int[] ints = {5, 1, 1, 2, 0, 0};
        quickSort(ints,0,ints.length);
        for (int i: ints){
            System.out.println(i);
        }
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(1);
//        list.add(1);
//        list.add(2);
//        list.add(0);
//        list.add(0);
//
////        list.add(0);
////        list.add(0);
//
//        ArrayList<Integer> list1 = quickSort(list);
//        for (int i : list1) {
//            System.out.println(i);
//        }
    }
}
