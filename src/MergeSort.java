import java.util.Random;

public class MergeSort {

    public static void mergeSort(Material[] array) {
        if (array.length < 2) {
            return; // Mảng đã được sắp xếp
        }
        int mid = array.length / 2;
        Material[] left = new Material[mid];
        Material[] right = new Material[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(Material[] result, Material[] left, Material[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].mark <= right[j].mark) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
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