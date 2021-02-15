import java.util.Arrays;

public class ArraysImpl {

    private final int ARRAY_CAPACITY = 100000;
    private final int ARRAY_MAX = 1001;

    int[] arr1 = new int[ARRAY_CAPACITY];
    int[] arr2 = new int[ARRAY_CAPACITY];
    int[] arr3 = new int[ARRAY_CAPACITY];

    public void createValues() {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int)(Math.random()*ARRAY_MAX);
        }
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
    }

    public void printArray(int[] arr) {
        for (int x : arr1) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public void swap (int a, int b, int [] arr) {
        int min = arr[a];
        arr[a] = arr[b];
        arr[b] = min;
    }

    public void bubbleSort(int[] arr) {
        for (int i = ARRAY_CAPACITY - 1; i >= 1; i--) {
            for (int y = 0; y < i; y++) {
                if (arr[y] > arr[y+1])
                    swap(y, y + 1, arr);
            }
        }
    }

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minInd = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }
            swap(i, minInd, arr);
        }
    }

    public void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minInd = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }
            swap(i, minInd, arr);
        }
    }

}
