
import java.io.*;

/**
 * Created by Ace on 2/11/15.
 */
public class Driver {

    public static void main(String[] args) {

        BufferedReader br;
        String line;

        int counter = 1, larger = 0, x = 0;
        int[] array;

        try {
            //Read the contents of the file in line by line.
            br = new BufferedReader(new FileReader("INPUT.txt"));
            while ((line = br.readLine()) != null) {
                // if it is the first line of the file, obtain x.
                if (counter == 1) {
                    x = Integer.parseInt(line);
                }
                //Increment the line counter
                counter++;
            }

            //Create an array of the size of the file - 1;
            array = new int[counter - 2];
            //Restart the counter for the second looping.
            counter=1;
            br = new BufferedReader(new FileReader("INPUT.txt"));

            //Loop through the file once again to put all of the contents into an array.
            while ((line = br.readLine()) != null) {
                // process the line.
                if(counter != 1) {
                    array[counter - 2] = Integer.parseInt(line);
                    if(Integer.parseInt(line) <= x){
                        larger++;
                    }
                }
                counter++;
            }


            br.close();


            //InsertionSort.insertionSort(array);
            QuickSort.quickSort(array,0,array.length-1);


            FileWriter writer = new FileWriter("OUTPUT.txt");
            writer.append(larger + "\n");


            System.out.println(larger);

            for(int i=0;i<array.length;i++){
                System.out.println(array[i]);
                writer.append(array[i]+"\n");
            }

            writer.close();


        }catch (IOException e){
            e.printStackTrace();
        }


    }

}
