package Heap;

public class ConvertMinHeapToMaxHeap {
    public static void main(String[] args) {
        int arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
//        int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        int n = arr.length;
        convertMinToMax(arr,n);
        printHeap(arr, n);
    }

    private static void printHeap(int[] arr, int n) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void convertMinToMax(int[] arr, int n) {
        int start = n/2-1;
        for(int i=start; i>=0; i--) {
            heapify(arr, n, i);
        }
//        int start = n/2-1;
//        for (int i=start; i>=0; i--) {
//            heapiyf(arr, n, i);
//        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(n>left && arr[left]>arr[largest]) {
            largest = left;
        }
        if(n>right && arr[right]>arr[largest]) {
            largest=right;
        }
        if(largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
//            System.out.println(arr[largest]+" "+largest);

            heapify(arr, n, largest);
        }
    }
}
