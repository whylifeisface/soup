import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMap {

    public HashMap<Integer, String> hashMap = null;

    public TestMap() {
        this.hashMap = new HashMap<>();

    }

    public void init() {
        hashMap.put(1, "China");
        hashMap.put(2, "India");
        hashMap.put(3, "USA");
    }

    public void delete(int key) {
        hashMap.remove(key);
    }

    public void add(int key, String value) {
        hashMap.put(key, value);
    }

    public void print1() {
//        hashMap.forEach();
        System.out.println("Entry");
        for (Map.Entry<Integer, String> next : hashMap.entrySet()) {
            System.out.println("key " + next.getKey() +"  "
                    + " value" +"  " + next.getValue());
        }
    }

    public void print2() {
//        hashMap.forEach();
        System.out.println("forEach");
        hashMap.forEach((k,v)->{
            System.out.println("key " + k +"  "
                    + " value" +"  " + v);
        });
    }
    public void print3() {
        System.out.println("iterator");
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println("key " + next +"  "
                    + " value" +"  " + hashMap.get(next));

        }
    }

    public static void main(String[] args) {
        TestMap testMap = new TestMap();
        testMap.init();
        testMap.print1();
        testMap.delete(3);
        testMap.print2();

        testMap.add(4, "Canada");
        testMap.print3();

    }

}
