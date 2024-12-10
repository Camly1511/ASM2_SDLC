import java.util.Arrays;
import java.util.Scanner;

public class Comparing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Cho phép người dùng nhập số lượng học sinh
        while (true) {
            System.out.print("Enter the number of materials (0 to 10000): ");
            n = scanner.nextInt();
            if (n >= 0 && n <= 10000) {
                break; // Thoát vòng lặp nếu số lượng hợp lệ
            } else {
                System.out.println("Please enter a number between 0 and 10000.");
            }
        }

        // Tạo mảng vật liệu ngẫu nhiên
        Material[] materialsForBubbleSort = BubbleSort.generateRandomMaterials(n);
        Material[] materialsForMergeSort = MergeSort.generateRandomMaterials(n);

        // So sánh thời gian thực hiện của Bubble Sort
        long startTimeBTS = System.nanoTime();
        BubbleSort.bubbleSort(materialsForBubbleSort);
        long endTimeBTS = System.nanoTime();
        long durationBTS = endTimeBTS - startTimeBTS;

        // So sánh thời gian thực hiện của Merge Sort
        long startTimeMergeSort = System.nanoTime();
        MergeSort.mergeSort(materialsForMergeSort);
        long endTimeMergeSort = System.nanoTime();
        long durationMergeSort = endTimeMergeSort - startTimeMergeSort;

        // In kết quả
        System.out.println("Time taken by Bubble Sort: " + durationBTS + " ns");
        System.out.println("Time taken by Merge Sort: " + durationMergeSort + " ns");

        // In ra top 5 vật liệu có điểm cao nhất của Merge Sort
        if (n > 0) { // Kiểm tra nếu có vật liệu
            System.out.println("Top 5 materials with highest scores using Merge Sort:");
            Arrays.sort(materialsForMergeSort, (m1, m2) -> Double.compare(m2.mark, m1.mark));
            for (int i = 0; i < Math.min(5, n); i++) {
                System.out.println(materialsForMergeSort[i]);
            }
        } else {
            System.out.println("No materials to display.");
        }
    }
}