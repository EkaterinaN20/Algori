import java.util.concurrent.TimeUnit;

public class TestClass {
    public static void main(String[] args) {
        ArrayImpl arrIml = new ArrayImpl();
        arrIml.createValues();
        // System.out.println("Изначальные значения элементов массивов 1 и 2:");
        // System.out.println(Arrays.toString(arrIml.arr1));
        long initialTimeBubble = System.nanoTime();
        arrIml.bubbleSort(arrIml.arr1);
        long finishTimeBubble = System.nanoTime();
        long durationTimeBubble = finishTimeBubble - initialTimeBubble;
        System.out.println("Время пузырьковой сортировки, мс: ");
        System.out.println(TimeUnit.NANOSECONDS.toMicros(durationTimeBubble));
        long initialTimeSelection = System.nanoTime();
        arrIml.selectionSort(arrIml.arr2);
        long finishTimeSelection = System.nanoTime();
        long durationTimeSelection = finishTimeSelection - initialTimeSelection;
        System.out.println("Время сортировки выбором, мс: ");
        System.out.println(TimeUnit.NANOSECONDS.toMicros(durationTimeSelection));
        long initialTimeInsert = System.nanoTime();
        arrIml.insertSort(arrIml.arr3);
        long finishTimeInsert = System.nanoTime();
        long durationTimeInsert = finishTimeInsert - initialTimeInsert;
        System.out.println("Время сортировки вставкой, мс: ");
        System.out.println(TimeUnit.NANOSECONDS.toMicros(durationTimeInsert));
        // System.out.println("Значения элементов массива 1 после сортировки пузырьком:");
        //System.out.println(Arrays.toString(arrIml.arr1));
        //System.out.println("Значения элементов массива 2 после сортировки выбором:");
        // System.out.println(Arrays.toString(arrIml.arr2));
        // System.out.println(Arrays.toString(arrIml.arr3));
    }

}
