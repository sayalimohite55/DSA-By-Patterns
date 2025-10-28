package com.patterns.twoPointers;
/*
* Statement
* Given an array, colors, which contains a combination of the following three elements:
* 0 (Representing red)
* 1 (Representing white)
* 2 (Representing blue)
* Sort the array in place so that the elements of the same color are adjacent, and
* the final order is: red (0), then white (1), and then blue (2).
* Note: You are not allowed to use any built-in sorting functions. The goal is to solve this efficiently without extra space.
*
* Constraints:
* n == colors.length
* 1 ≤ n ≤ 300
* colors[i] is either 0, 1, or 2
* */
public class SortColors {
    static void sortColors_approachI(int[] colors) {
        //Intent - using bubble sort
        printArray(colors);
        for(int pass=1; pass<colors.length; pass++) {
            for(int i=0; i<colors.length-1-pass; i++) {
                if(colors[i] > colors[i+1]) {
                    colors[i] = colors[i] + colors[i+1];
                    colors[i+1] = colors[i] - colors[i+1];
                    colors[i] = colors[i] - colors[i+1];
                }
            }
        }
        printArray(colors);
        /*
        * Time Complexity = o(n^2)
        * Space Complexity = o(1)
        * */
    }

    static void sortColors_approachII(int[] colors) {
        //Intent - using merge sort
        printArray(colors);
        mergeSort(colors, 0, colors.length-1);
        printArray(colors);
        /*
         * Time Complexity = o(n log n)
         * Space Complexity = o(n)
         * */
    }

    static void mergeSort(int[] colors, int left, int right) {
        if(left < right) {
            int mid = left + (right - left)/2;
            mergeSort(colors, left, mid);
            mergeSort(colors, mid+1, right);

            merge(colors, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        // Merge temp arrays back into arr[l..r]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void sortColors_approachIII(int[] colors) {
        //Intent - using two-pointers technique
        printArray(colors);
        int start = 0, end = colors.length-1, current = 0;

        while(current < end) {
            if(colors[current] == 0) {
                int t = colors[current];
                colors[current] = colors[start];
                colors[start] = t;

                start ++;
                current ++;
            } else if(colors[current] == 1) {
                current ++;
            } else {
                int t = colors[current];
                colors[current] = colors[end];
                colors[end] = t;

                end --;
            }
        }

        printArray(colors);
        /*
         * Time Complexity = o(n)
         * Space Complexity = o(1)
         * */
    }

    public static void printArray(int[] arr) {
        System.out.println();
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args)  {
        /*
        * Approach Intent :
        * Brute force solution could be to use sorting algorithms to sort like
        *   - bubble sort, selection sort (Runtime - o(n^2))
        *   - merge sort, quick sort (Runtime - o(n log n))
        * Another approach could be to use two pointers technique considering we have values only of 3 types
        * which could give runtime of o(n)
        */
        System.out.println("\nApproach I : Brute Force Solution");
        sortColors_approachI(new int[]{1,0,2,1,2,2});
        sortColors_approachI(new int[]{1,0,2,1,0,2});

        System.out.println("\nApproach II : Brute Force Solution");
        sortColors_approachI(new int[]{1,0,2,1,2,2});
        sortColors_approachI(new int[]{1,0,2,1,0,2});

        System.out.println("\nApproach III : Optimised Solution");
        sortColors_approachIII(new int[]{1,0,2,1,2,2});
        sortColors_approachIII(new int[]{1,0,2,1,0,2});
    }
}
