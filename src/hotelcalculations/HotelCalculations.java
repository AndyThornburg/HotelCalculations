/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelcalculations;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * testFile Rational
* Test File Rational
* For my test file I created one instance for lodging, dining, Conferences, Receptions, and Spa for every month. 
* After this I would run the project and see if the results were in the right place on the answers file. 
* After that I added another instance of each (lodging, dining, conferences, receptions, and spa) to see if they were adding together. 
* After that worked I calculated the totals on a calculator to see if they matched the program output, 
* and when I found out that all of that was working, I concluded that the program was working.

 * 
 * 
 * 
 * 
 *
 * @author Andy Thornburg
 * 
 * 
 * ALGORITHM
 * 1)allocate space for rows and columns
 * 2)declare printwriter for hotelAnswers.txt
 * 3)declare Scanner of hotel.txt
 * 4)create months on right side of printing document
 * 5)get the month out of the string given in the hotel.txt file (parseint)(substing)
 * 6)Print header
 * 7)create totals for each month and instance (lodging, dining,conferences, receptions, spa)
 * 8)calculate totals on right side
 * 9)place println(-----------) to create a even table
 * 10)print totals at bottom of chart
 */
public class HotelCalculations {

    public static int ROW = 12;
    public static int COLUMN = 6;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        PrintWriter outFile = new PrintWriter("hotelAnswers.txt");
        Scanner inFile = new Scanner(new File("hotel.txt"));
        double[][] table = new double[ROW][COLUMN];

        String[] month = {"January |", "February |", "March |", "April |", "May |", "June |", "July |", "August |", "September |", "October |", "November |", "December |"};
        while (inFile.hasNextLine()) {
            String inputLine = inFile.nextLine();
            String[] a = inputLine.split(" ");
            int serviceCode = Integer.parseInt(a[1]);
            String monthString = a[2].substring(0,2);
            int m = Integer.parseInt(monthString);
            double price = Double.parseDouble(a[3]);

            while (m < 13) {
                table[m - 1][serviceCode] += price;
                table[m - 1][COLUMN - 1] += price;
                break;
            }
        }

        outFile.println("Hotel 2012 Receipt");
        outFile.println("Totals by Month and Service Type");
        outFile.println("Produced by Andy Thornburg");
        outFile.println("Date: May 6, 2013");
        outFile.println();
        outFile.println("           |         Lodging |      Dining     |   Conferences  |  Receptions |        Spa    |    Total    |");
        outFile.println("-------------------------------------------------------------------------------------------------------------");

        for (int q = 0; q < 12; q++) {
            outFile.printf("%12s", month[q].toString());
            for (int v = 0; v <= 5; v++) {
                outFile.printf("%16.2f", table[q][v]);
            }
            outFile.println();

        }
	double[] totalBottom = new double[6];
        for(int v=0;v<=5;v++){
        	for(int q=0;q<12;q++){
        		totalBottom[v]+=table[q][v];
        	}
        }
        outFile.println("----------------------------------" +
        		"---------------------------------------------------------------------------");
    	outFile.printf("%12s","Total |");
    	for(int v=0;v<=5;v++){
    		outFile.printf("%16.2f",totalBottom[v]);
    	}
    	outFile.println();
    	outFile.close();
    }
    
    }


