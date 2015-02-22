/**
 * Created by Ace on 2/10/15.
 */
public class InsertionSort {

    public static void insertionSort(int[] array) {

       for(int j = 1; j < array.length; j++){
           int key = array[j];
           int i = j-1;

           while((i>=0) && (array[i] > key)){
               array[i+1] = array[i];
               i--;
           }

           array[i+1] = key;

       }

    }

}

