import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int nums[] = {10, 5000, 30, 40, 60};
//
//        Integer a = 123;
//        String s = a.toString();
//        char[] chars = s.toCharArray();
        sort(nums);
        for (int num :
                nums) {
            System.out.println(num);
        }
//        int num = getNum(10, 2, 2);
//        System.out.println(num);
//        int count = getCount(10);
//        System.out.println(count);
    }

    private static int getCountInList(int[] nums, int count) {
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            int num = nums[i];
            if (num < 0) num = Math.abs(num);
            while (true) {
                if (num != 0) temp++;
                else {
                    if (temp > count) {
                        count = temp;
                    }
                    break;
                }
                num = num / 10;
            }
        }
        return count;
    }

    private static int getCount(int num) {
        int count = 0;
        while (true) {
            count++;
            num = num / 10;
            if (num == 0) {
                break;
            }
        }
        return count;
    }

    private static void sort(int[] nums) {
        int[][] bucket = new int[nums.length][10];
        // 获得位数 十位百位的标识 数组中最大 一位 1 两位 2 三位 3
        int count = 0;
        count = getCountInList(nums, count);
        //循环count次

        for (int i = 0; i < count; i++) {
            //用来插入不同位置 防止覆盖  也可以直接在二维数组的同一个x轴下找到空位放下
            int index = 0;
            //填充二维数组
            for (int k : nums) {
                int num = getNum(k, i, getCount(k));
                bucket[num][index] = k;
                index++;
            }
            System.out.println();
            //还原  把结果返回原数组
            renew(nums, bucket);
            //重置二维数组
            bucket = new int[10][10];
        }
    }

    private static void renew(int[] nums, int[][] bucket) {
        int index = 0;
        int num = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i].length; j++) {
                num = bucket[i][j];
                //如果没填充数组 数组默认会把每个数初始化为0
                if (num != 0) {
                    nums[index++] = num;
                }
            }
        }
    }

    //获得 个位 十位 百位的数字 123  0 3  1 2  2 1     10  2  4   3
    // 参数  当前数组值  循环次数 即取哪一位
    // 数组值的位数  eg num = 10 i = 1  count = 2(10有个位十位)
    private static int getNum(int num, int i, int count) {
        //两种解法
        //1// 用的是 减去小的值 再取模 eg 123 取百位  先减去 23 再取模 10 ^ 2
        // 23  = （123 mod 1 ） * 1  + (123 mod 2) * 10
        // 2 // 把数组转字符串 再取.charAt 再转数字 可以参考我的上一篇文章
        if (i > count) return 0;
        do {
            double temp = Math.pow(10, count - 1);
            if (num >= temp) {
                int interge = (int) (num / temp);
                if (i + 1 < count)
                    num = num - (int) (interge * temp);
                else num = num / (int) temp;
            }
            count--;
        } while (i <= count);
        System.out.println();
        return num;
    }

    private static void ret(int[][] ints, int[] nums) {

    }

}
