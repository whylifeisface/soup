import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        String s = myQueue.decodeStringSecond("3[a]2[bc]");
        System.out.println(s);
    }

    int ptr = 0;

    public String decodeStringSecond(String s) {
//        String.valueOf()
        LinkedList<String> stack = new LinkedList();

        while (ptr < s.length()) {
            char c = s.charAt(ptr);
            if (Character.isDigit(c)) {
                //数字
                String digits = getDigits(s);
                stack.addLast(digits);
            } else if (Character.isLetter(c) || c == '[') {
                //字符和左括号
                stack.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                //右括号
                LinkedList<String> strings = new LinkedList<>();

                while (!"[".equals(stack.peekLast()))
                    strings.addLast(stack.removeLast());
                Collections.reverse(strings);

                //左括号出
                stack.removeLast();
                //数字
                int ti = Integer.parseInt(stack.removeLast());

                StringBuilder string = getString(strings);

                String s1 = String.copyValueOf(string.toString().toCharArray());
                for (int i = ti - 1; i > 0; i--) {
                    string.append(s1);
                }

                stack.addLast(string.toString());

                ptr++;
            }
        }
        System.out.println();
        return getString(stack).toString();


    }

    public StringBuilder getString(LinkedList<String> s) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!s.isEmpty()) {
            stringBuilder.append(s.removeLast());
        }
        return stringBuilder;
    }

    public String getDigits(String s) {
        StringBuilder stringBuffer = new StringBuilder();

        while (Character.isDigit(s.charAt(ptr))) {
            stringBuffer.append(s.charAt(ptr++));
        }
        return stringBuffer.toString();
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack<String>();
        Pattern compile = Pattern.compile("(\\d+)");
        Matcher matcher = compile.matcher(s);
        int end = 0;
        int index = 1;
        int length = s.length();
        while (matcher.find(end)) {
            end = matcher.end();
            int start = matcher.start();
            while (index < start) {
                stack.push(s.substring(index, index + 1));
                index++;
            }
            String substring = s.substring(start, end);
            stack.push(substring);
            index = end;
        }
        if (end <= length) {
            while (index < length) {
                stack.push(s.substring(index, index + 1));
                index++;
            }
        }
        int times = 0;
        ArrayList<Integer> list = new ArrayList<>();
//        int[] a = {};
        index = 0;
        Stack<String> cu = stack;
        while (!cu.isEmpty()) {
            String current = cu.pop();
            if (current.equals("["))
                times++;
        }
        Stack<String> su = stack;
        for (int i = 0; i < times; i++) {
            int m = 0;
            int e = 0;
            while (!su.isEmpty()) {
                String pop = su.pop();
                StringBuilder str = new StringBuilder();
                if (pop.equals("[")) {
                    m++;
                    if (m == times - i)
                        str.append(pop);
                }
                if (pop.equals("[")) {
                    for (int a = 0; a <= list.get(times - i); a++)
                        str.append(str);
                    e++;
                    if (e == i)
                        break;
                }

            }
        }
        System.out.println();
        return "";
    }

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
//        if (!inStack.isEmpty())
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty())
            transfer();
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty())
            transfer();
        return outStack.peek();
    }

    public boolean empty() {
        if (outStack.isEmpty())
            transfer();
        return outStack.isEmpty() && inStack.isEmpty();
    }

    public void transfer() {
        while (!inStack.isEmpty())
            outStack.push(inStack.pop());
    }
}
