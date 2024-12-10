import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> studentQueue = new LinkedList<>();

        // Add students to the queue
        studentQueue.add("Minh");
        studentQueue.add("Linh");
        studentQueue.add("Tuan");
        studentQueue.add("Mai");
        studentQueue.add("Ly");

        // Process the queue (call roll)
        while (!studentQueue.isEmpty()) {
            System.out.println(studentQueue.poll() + " is marked present.");
        }
    }
}
