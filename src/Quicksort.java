//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Quicksort {

    static int[] werte = {1, 2, 3, 4, 5, 8, 3, 6, 10, 24, 12, 45, 66, 70};


    static int[] sortedArray = new int[werte.length];

    public static void main(String[] args) {
        long start = System.nanoTime();

        System.out.println("Unsortiertes Array: " + java.util.Arrays.toString(werte));

        quicksort(werte);
        System.out.println("test");
        System.out.println("Sortiertes Array: " + java.util.Arrays.toString(sortedArray));


        long end = System.nanoTime();
        long duration = (end - start);  //divide by 1000000 to get milliseconds.
        System.out.println("Dauer: " + duration + " Nanosekunden");

    }

    //ich möchte mehrere quicksort methoden miteinander vergleichen
    //mithilfe einer Methode kann ich große random arrays erstellen
    public static int mean(int[] array) {
        int summe = 0;
        int pivot = 0;
        for (int i = 0; i < 2; i++) {
            summe = summe + array[i];
            System.out.println("Summe:" + summe);
        }
        int mean = summe / 2;
        System.out.println("Mittelwert: " + mean);

        for (int i = 0; i < 2; i++) {
            if (array[i] <= mean && array[i] > pivot) {
                pivot = array[i];

            }
        }
        System.out.println("Pivot: " + pivot);
        System.out.println("test2");
        return pivot;

    }

    public static void quicksort(int[] array, int pivot, int length) {
        if (array == null || array.length == 0) {
            return;
        }
        int smallCounter = 1;
        int bigCounter = 1;
        int pivot = 0;
        int[] arraySmall = new int[array.length];
        int[] arrayBig = new int[array.length];

        for (int i = 0; i < array.length - 1; i++) {
            pivot = mean(array);

            if (array[i] > pivot) {
                bigCounter++;
                arrayBig[i] = array[i];
                System.out.println("Array Big: " + java.util.Arrays.toString(arrayBig));


            } else if (array[i] <= pivot) {

                smallCounter++;
                arraySmall[i] = array[i];
                System.out.println("Array Small: " + java.util.Arrays.toString(arraySmall));

            }
        }


        if (arraySmall.length > 1 || (arraySmall.length >= 2 && arraySmall[0] != arraySmall[1])) {
            return quicksort(arraySmall);
        }
        if (arrayBig.length > 1 || (arrayBig.length >= 2 && arrayBig[0] != arrayBig[1])) {
            return quicksort(arrayBig);
        }

        if (array[0] >= sortedArray[0]) {
            System.arraycopy(array, 0, sortedArray, array.length - 1, array.length);
            return array;
        } else if (array[0] <= sortedArray[0]) {
            System.arraycopy(array, 0, sortedArray, 0, array.length);
            return array;
        } else {
            sortedArray = array;
            return array;

        }
    }
}