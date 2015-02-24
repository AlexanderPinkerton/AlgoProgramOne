/**
 * Created by Alexander Pinkerton on 2/11/15.
 */
public class InsertionSort {

    public static void insertionSort(int[] array) {

       for(int j = 1; j < array.length; j++){
           //Assign the key to the current loop index.
           int key = array[j];
           //The swap index.
           int i = j-1;

           //If array[i] is greater than the key, swap until correct positioning.
           while((i>=0) && (array[i] > key)){
               array[i+1] = array[i];
               i--;
           }

           array[i+1] = key;

       }

    }

}

