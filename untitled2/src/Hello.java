import java.util.HashMap;

public class Hello {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else{
            if (hashMap.containsKey(n))
                return hashMap.get(n);
            else{
                int result = climbStairs(n-1) + climbStairs(n-2);
                hashMap.put(n,result);
                return result;
            }
        }
    }
    int constant = 1000000007;
    public int fib(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        if (n < 2)
            return n;

        if (hashMap.containsKey(n))
                return hashMap.get(n);
        int first = fib(n-1) % constant;
        int second = fib(n-2) % constant;
        hashMap.put(n-1,first);
        hashMap.put(n-2,second);
        int result = (second + first)%constant;

        hashMap.put(n,result);
        return result;
    }

}
