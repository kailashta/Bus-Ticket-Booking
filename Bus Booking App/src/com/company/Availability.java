package com.company;

import java.util.Scanner;

public class Availability {
    int[][] seats = new int[8][6];
    Scanner sc = new Scanner(System.in);
    public  void availability(){
        int seatNumber = 01;
        for (int i=0;i<8;i++){
            for (int j=0;j<6;j++){
                if (j==6/2){
                    seats[i][j] = -1;
                }
                else{
                    seats[i][j] = seatNumber++;
                }
            }
        }
    }
    public int[] Book(){
        System.out.println("Enter Seat Number");
        int[] index = new int[3];
        int seatNumber = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<8;i++){
            for (int j=0;j<6;j++){
                if (seats[i][j] == seatNumber){
                    index[0] = i;
                    index[1] = j;
                    index[2] = seatNumber;
                    seats[i][j] = 0;
                }

            }
        }
        return index;
    }

    public void cancelTicket(int seatNo,int[] arr){
        int row = arr[0];
        int col = arr[1];
        boolean deleted = false;
        for (int i=0;i<8;i++){
            for (int j=0;j<6;j++){
              /*  if (j==0 && (i==row && j==col) ){
                    seats[i][j] = seats[i-1][5] + 1;
                } */
                if(j==0 && (i==row && j==col) ){
                    deleted = true;
                    seats[i][j] = seats[i][j+1] -1;
                }
                else if( (i == row && j == col ) && seats[i][j] == 0 ){
                        deleted = true;
                        if ( j-1 == 6/2){
                            seats[i][j] = (seats[i][j-2] + 1);
                        }
                        else{
                            seats[i][j] = seats[i][j-1] +1;
                        }
                }


            }
        }
        if (deleted){
            System.out.println("\nTicket Canceled Successfully");
        }
        else if( (seatNo>=1 && seatNo<=40) && !deleted){
            System.out.println("\nThe Entered Seat Number is Not Booked yet ");
        }
        else{
            System.out.println("\nINVALID INPUT");
        }
    }
    public void seatAvailability(){

        for (int i=0;i<8;i++){
            for (int j=0;j<6;j++){

                if (i<2 && j != 6/2){
                    System.out.print(seats[i][j] + "  ");
                }
                else if (j==6/2){
                    System.out.print("  ");
                }
                else{
                    System.out.print(seats[i][j] + " ");
                }



            }
            System.out.println();
        }

    }

   /* public void message(){
        System.out.println("\n Available seats ");
        System.err.println(" \n Here , 0 =  Booked Seats \n The Remaining Are Available Seat Numbers \n ");

    } */

}
