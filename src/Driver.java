
import javax.swing.*;
import java.io.*;

/**
 * Created by Alexander Pinkerton on 2/11/15.
 */
public class Driver {

    public static void main(String[] args) {

        BufferedReader br;
        String line;

        int counter = 1, lessThan = 0, x = 0;
        int[] array;

        try {

            //====================================LOOP ONE   O( n )=========================================
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

            //====================================LOOP TWO   O( n )=========================================
            //Loop through the file once again to put all of the contents into an array of correct size.
            while ((line = br.readLine()) != null) {
                // process the line.
                if(counter != 1) {
                    array[counter - 2] = Integer.parseInt(line);
                    //While inserting values into array, increment a counter if the value was less or equal to x.
                    if(Integer.parseInt(line) <= x){
                        lessThan++;
                    }
                }
                counter++;
            }

            //close the buffered reader.
            br.close();



            //Prompt the user for the sorting type and then sort the array.

            String[] options = {"Quick Sort","Insertion Sort"};
            int choice = JOptionPane.showOptionDialog(null, //Component parentComponent
                    "Quick Sort or Insertion Sort?", //Object message,
                    "Choose an option", //String title
                    JOptionPane.YES_NO_OPTION, //int optionType
                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                    null, //Icon icon,
                    options, //Object[] options,
                    options[0]);//Object initialValue
            if(choice == 0 ){
                System.out.println(options[0]);
                QuickSort.quickSort(array,0,array.length-1);
            }else{
                System.out.println(options[1]);
                InsertionSort.insertionSort(array);
            }



            //==================================== OUTPUT  O( n ) =========================================
            //Output the processed data.
            FileWriter writer = new FileWriter("OUTPUT.txt");
            //Write the number of numbers less than or equal to x
            writer.append(lessThan + "\n");

            //debug output
            System.out.println(lessThan);

            for(int i=0;i<array.length;i++){
                //debug output
                System.out.println(array[i]);
                //Write the sorted array line by line
                writer.append(array[i]+"\n");
            }

            //close the writer
            writer.close();


        }catch (IOException e){
            e.printStackTrace();
        }


    }

}
