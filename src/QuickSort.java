/**
 * Created by Ace on 1/31/15.
 */


public class QuickSort {


    public static int[] quickSort(int[] data, int first, int last){

        if(first < last){
            //Partition the data to obtain pivot
            int pivot = partition(data, first, last);
            //Sort the Left Side
            quickSort(data,first,pivot-1);
            //Sort the Right Side
            quickSort(data,pivot+1,last);
        }


        return data;
    }


    private static int partition(int[] data, int first, int last){

        //Set the pivot to the last element
        int pivot = data[last];
        int temp;

        int i = first - 1;

        for(int j = first; j<last; j++){

            //Find values smaller than pivot and swapping them behind the pivot. Work on dat explan.
            if(data[j] <= pivot){
                i++;

                //Swap data[i] and data[j]
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;
            }
        }

        //Swap the pivot with the last remaining larger number.
        temp = data[i+1];
        data[i+1] = data[last];
        data[last] = temp;


        return i+1;
    }


}
