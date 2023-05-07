public class SingleNumber {
    public int singleNumber(int[] nums) {
        int results = 0;
        for (int o :
                nums) {
            results = results ^ o;
        }
        return results;
    }

}
