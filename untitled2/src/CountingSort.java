import java.util.*;

public class CountingSort {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(4);
        list.add(6);
        list.add(5);

        List<Integer> sort = sort(list);
        for (int i :
                sort) {
            System.out.println(i);
        }
    }

    public int[] sortArray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).max().getAsInt();
        //桶
        int[] ints = new int[ max - min ];
        for (int a :
                nums) {
            //把值插入数组   桶是从 min 到 max   值是 a = 1 应该放到第一个位置
            //从结果看是 a - min
            ints[a-min]++;
        }
        int key = 0;
        // 对桶排序并取出
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i]; j++){
                nums[key++] = i;
            }
        }
        return nums;
    }


    public static List<Integer> sort(List<Integer> list) {
        int max = 0;
        Optional<Integer> optionalInteger = list.stream().max(Comparator.naturalOrder());
        if (optionalInteger.isPresent()) max = optionalInteger.get();
        else return null;
        int[] ints = new int[max + 1];
        for (int i : list
        ) {
            ints[i]++;
        }

        List<Integer> list1 = new ArrayList<>();
        for (int j = 0; j < ints.length; j++) {
            for (int m = 0; m < ints[j]; m++)
                list1.add(j);
        }
        return list1;
    }

}
