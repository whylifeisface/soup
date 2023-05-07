import java.util.Objects;
import java.util.Stack;

public class IsValid {
    // ((   // )) ()
//"(){}}{"
    public boolean isValid(String s) {
        boolean signIf = false;

        boolean result = true;
        if (s.length() == 1) return false;
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        if ((s.length() & 1) != 0) //
            return false;
        for (char c :
                chars) {
            if (c == '{' || c == '(' || c == '[') {
            stack.push(String.valueOf(c));
            } else {
                signIf = true;
                if (!stack.isEmpty())
                    result = result && one(String.valueOf(c), stack.pop());
                else result = false;
            }
        }
        if(!stack.isEmpty()) return false;
        if (!signIf) return false;

        return result;
    }

    public boolean one(String o, String two) {
        if (Objects.equals(o, "{") && Objects.equals(two, "}"))
            return true;
        if (Objects.equals(two, "{") && Objects.equals(o, "}"))
            return true;
        if (Objects.equals(o, "[") && Objects.equals(two, "]"))
            return true;
        if (Objects.equals(o, "]") && Objects.equals(two, "["))
            return true;
        if (Objects.equals(o, "(") && Objects.equals(two, ")"))
            return true;
        if (Objects.equals(o, ")") && Objects.equals(two, "("))
            return true;
        return false;
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        boolean valid = isValid.isValid("[[[]");
        System.out.println(valid);
    }
}
