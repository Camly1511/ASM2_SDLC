import java.util.Random;

public class BubbleSort {

    public static void bubbleSort(Material[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].mark > array[j + 1].mark) {
                    // Hoán đổi
                    Material temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Phương thức tạo mảng vật liệu ngẫu nhiên với điểm là số nguyên
    public static Material[] generateRandomMaterials(int size) {
        Random random = new Random();
        Material[] materials = new Material[size];
        for (int i = 0; i < size; i++) {
            int materialId = i + 1;
            String materialName = "Material " + materialId;
            int materialMark = random.nextInt(11); // Điểm ngẫu nhiên từ 0 đến 10
            materials[i] = new Material(materialId, materialName, materialMark);
        }
        return materials;
    }
}