import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> studentStack = new Stack<>();

        // Mark students as attended (pushing onto the stack)
        studentStack.push("Linh");
        studentStack.push("Minh");
        studentStack.push("Tuan");
        studentStack.push("Mai");
        studentStack.push("Ly");

        // Process stack (check last student attended)
        while (!studentStack.isEmpty()) {
            System.out.println(studentStack.pop() + " has attended the class.");
        }
    }
}
