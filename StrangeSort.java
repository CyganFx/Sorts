/**
 * Strange sort
 *
*/

public class StrangeSort {
    public static void mergeSort(Comparable[] originalArray) {
        mergeSort(originalArray, 0, (originalArray.length - 1) / 2);
    }

    private static void mergeSort(Comparable[] originalArray, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            mergeSort(originalArray, startIndex, middleIndex);
            mergeSort(originalArray, middleIndex + 1, endIndex);
            merge(originalArray, startIndex, middleIndex, endIndex);
        }
    }

    private static void merge(Comparable[] originalArray, int startIndex, int middleIndex, int endIndex) {
        int leftSize = middleIndex - startIndex + 1;
        int rightSize = endIndex - middleIndex;
        Comparable[] arrayLeft = new Comparable[leftSize];
        Comparable[] arrayRight = new Comparable[rightSize];
        for (int i = 0; i < leftSize; i++) {
            arrayLeft[i] = originalArray[startIndex + i];
        }
        for (int i = 0; i < rightSize; i++) {
            arrayRight[i] = originalArray[middleIndex + 1 + i];
        }
        int leftIndex = 0, rightIndex = 0, mergedIndex = startIndex;
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (arrayLeft[leftIndex].compareTo(arrayRight[rightIndex]) >= 0) {
                originalArray[mergedIndex] = arrayLeft[leftIndex];
                leftIndex++;
            } else {
                originalArray[mergedIndex] = arrayRight[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }
        if (leftIndex < leftSize) {
            while (leftIndex < leftSize) {
                originalArray[mergedIndex] = arrayLeft[leftIndex];
                leftIndex++;
                mergedIndex++;
            }
        } else {
            while (rightIndex < rightSize) {
                originalArray[mergedIndex] = arrayRight[rightIndex];
                rightIndex++;
                mergedIndex++;
            }
        }
    }

    public static void quickSort(Comparable[] originalArray) {
        quickSort(originalArray, (originalArray.length - 1) / 2 + 1, originalArray.length - 1);
    }

    private static void quickSort(Comparable[] originalArray, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pi = partition(originalArray, startIndex, endIndex);
            quickSort(originalArray, startIndex, pi - 1);
            quickSort(originalArray, pi + 1, endIndex);
        }
    }

    private static int partition(Comparable[] originalArray, int startIndex, int endIndex) {
        Comparable pivot = originalArray[endIndex];
        int smallerIndex = startIndex - 1;
        for (int i = startIndex; i <= endIndex - 1; i++) {
            if (originalArray[i].compareTo(pivot) <= 0) {
                smallerIndex++;
                Comparable temp = originalArray[smallerIndex];
                originalArray[smallerIndex] = originalArray[i];
                originalArray[i] = temp;
            }
        }
        Comparable temp = originalArray[smallerIndex + 1];
        originalArray[smallerIndex + 1] = originalArray[endIndex];
        originalArray[endIndex] = temp;
        return smallerIndex + 1;
    }

    public static void strangeSort(Comparable[] array) {
        mergeSort(array);
        quickSort(array);
    }

    public static void main(String[] args) {
        Comparable[] arr = {1, 9, 2, 6, 3, 8, 4};
        strangeSort(arr);
        for (Comparable comparable : arr) {
            System.out.print(comparable + " ");
        }
    }
}
