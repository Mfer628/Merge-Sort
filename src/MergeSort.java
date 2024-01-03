public class MergeSort {

    public static void main(String[] args) {

        int[] arrayToSort = {
                -12, 79, -42, 55, 38, -53, -64, -7, -92, 0,
                -25, -69, -48, 24, -87, -36, -76, -15, 53, -16,
                97, -96, 89, -99, -17, -22, 23, 34, 6, 94,
                -83, -41, -46, -28, 74, 33, 85, -98, -57, 27,
                -59, -18, 41, 100, 44, -49, 5, 68, 1, 14,
                -38, -30, -75, -8, 42, 51, -81, -71, -95, -3,
                90, -85, -90, -35, 66, -19, 76, 56, -29, -5,
                -61, -73, -78, -55, 57, -43, -63, 16, 64, -21,
                39, -84, -66, -65, -80, 10, 92, -2, -79, -6,
                20, 7, -70, -32, -72, -20, -47, 19, -9, -45
        };

        mergeSort(arrayToSort);

        System.out.println(arrayToSort.length);

        long startTime = System.nanoTime(); // Registra el tiempo de inicio
        mergeSort(arrayToSort);
        long endTime = System.nanoTime(); // Registra el tiempo de finalización

        for (int num : arrayToSort) {
            System.out.print(num + " ");
        }

        double seconds = (endTime - startTime) / 1e9; // Convierte nanosegundos a segundos

        System.out.println("\nTiempo de ejecución: " + seconds + " segundos");
    }
    public static void mergeSort(int[] a) {
        int tmpArray[] = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    private static void mergeSort(int a[], int tmpArray[],int left, int right ){

        if(left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    private static void merge(int a[],int tmpArray[],int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while(leftPos <= leftEnd && rightPos <= rightEnd){ // Main loop
            if(a[leftPos] < (a[rightPos])){
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }
        while(leftPos <= leftEnd){ // Copy rest of first half
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while(rightPos <= rightEnd){ // Copy rest of right half
            tmpArray[tmpPos++] = a[rightPos++];
        }
        for(int i = 0; i < numElements; i++, rightEnd--){ // Copy TmpArray back
            a[rightEnd] = tmpArray[rightEnd];
        }
    }
}
