/**
 * Pair exercise — implement linearSearch and binarySearch.
 * Precondition: sorted ascending, may contain duplicates; return any matching index.
 */
public class SearchLib {

    public static int linearSearch(int[] sorted, int target) {
        for (int v=0; v<sorted.length; v++) {
            if(sorted[v]==target) {
                return v;
            }

        }
        return -1;
        
    }



    public static int binarySearch(int[] sorted, int target) {

        return searchRange(sorted, target, 0, sorted.length-1);

    }


    public static int searchRange(int[] a, int target, int lo, int hi){
        if (lo>hi){
            return -1;
        }
        int mid = lo + (hi-lo) / 2;
        int v = a[mid];
        if(v==target) {
            return mid;
        }
        if(v<target) {
            return searchRange(a, target, mid+1, hi);
        }
        return searchRange(a, target, lo, mid-1);
    }

}
