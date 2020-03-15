import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class MergeSort {

    public static void mergeSort(Comparable[] originalArray) {
        mergeSort(originalArray, 0, originalArray.length - 1);
    }

    private static void mergeSort(Comparable[] originalArray, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            mergeSort(originalArray, startIndex, middleIndex);
            mergeSort(originalArray, middleIndex + 1, endIndex);
            merge(originalArray, startIndex, middleIndex, endIndex);
        }
    }

    public static void merge(Comparable[] originalArray, int startIndex, int middleIndex, int endIndex) {
        int leftSize = middleIndex - startIndex + 1;
        int rightSize = endIndex - middleIndex;
        Comparable[] arrayLeft = new Comparable[leftSize];
        Comparable[] arrayRight = new Comparable[rightSize];

        for (int j = 0; j < leftSize; j++) {
            arrayLeft[j] = originalArray[startIndex + j];
        }
        for (int j = 0; j < rightSize; j++) {
            arrayRight[j] = originalArray[middleIndex + j + 1];
        }
        int leftIndex = 0, rightIndex = 0, mergedIndex = startIndex;
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (arrayLeft[leftIndex].compareTo(arrayRight[rightIndex]) <= 0) {
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

    public static void printArray(Comparable[] array) {
        out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            out.print(array[i] + " ");
        }
        out.print("}");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(in);
        int size = scan.nextInt();
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        mergeSort(array);
        printArray(array);
    }
}

