import java.util.Arrays;

/**
 * Lab 1 — Arrays & loops. Implement the bodies.
 * See ../README.md
 */
public class ArrayLoopsLab {

    /** Reverse array in place. */
    public static int[] reverse(int[] data) {

        int arr_len = data.length;
        int temp = 0;
        // Move the boundry of the unsorted array
        if (arr_len>0) {
            for(int i =0; i<arr_len-1; i++) {

                int maxIndex = i;
                //Find the largest value amongst the current working set
                for(int j=i; j<arr_len; j++){
                    if (data[j]>data[maxIndex]) {
                        maxIndex = j;
                    }
                }

                // Swap the current element with the largest elements in the current working set
                temp = data[maxIndex];
                data[maxIndex] = data[i];
                data[i] = temp;

            }

        }

        return data;
    }

    /** Smallest element; illegal if null or empty. */
    public static int min(int[] data) {

        int arr_len = data.length;
        int minElement = Integer.MAX_VALUE;
        // Move the boundry of the unsorted array
        if (arr_len>0) {
            for(int i =0; i<arr_len-1; i++) {
                if (data[i]<minElement) {
                    minElement = data[i];
                }
            }

        }

        return minElement;
    }

    /** Largest element; illegal if null or empty. */
    public static int max(int[] data) {

        int arr_len = data.length;
        int maxElement = Integer.MIN_VALUE;
        // Move the boundry of the unsorted array
        if (arr_len>0) {
            for(int i =0; i<arr_len-1; i++) {
                if (data[i]>maxElement) {
                    maxElement = data[i];
                }
            }

        }

        return maxElement;
    }

    /** In-place ascending sort using nested loops only (no Arrays.sort). */
    public static int[] sortAscending(int[] data) {

        int arr_len = data.length;
        int temp = 0;
        // Move the boundry of the unsorted array
        if (arr_len>0) {
            for(int i =0; i<arr_len-1; i++) {

                int minIndex = i;
                //Find the smallest value amongst the current working set
                for(int j=i; j<arr_len; j++){
                    if (data[j]<data[minIndex]) {
                        minIndex = j;
                    }
                }

                // Swap the current element with the smallest element in the current working set
                temp = data[minIndex];
                data[minIndex] = data[i];
                data[i] = temp;

            }

        }

        return data;
    }

    public static void main(String[] args) {

        int[] data = {500, 600, 800, 900, 4000, 2000, 23};

        int[] org_data = {500, 600, 800, 900, 4000, 2000, 23};
        int minEle = min(data);
        int maxEle = max(data);

        System.out.println("The Original Array : "+Arrays.toString(data)+" \n");

        reverse(data);

        System.out.println("The Reverse-Sorted Array : "+Arrays.toString(data)+" \n\n");

        System.out.println("The Original Array : "+Arrays.toString(org_data)+" \n");

        System.out.println("The Minimum Element In The Array : "+minEle+" \n\n");

        System.out.println("The Original Array : "+Arrays.toString(org_data)+" \n");

        System.out.println("The Maximum Element In The Array : "+maxEle+" \n\n");

        System.out.println("The Original Array : "+Arrays.toString(org_data)+" \n");

        sortAscending(data);

        System.out.println("The Sorted Array : "+Arrays.toString(data)+" \n\n");
    }
}
