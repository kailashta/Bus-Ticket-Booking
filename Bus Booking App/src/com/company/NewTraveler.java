package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class NewTraveler {
    private int seatNumber;
    private String name ;
    private long phoneNumber;
    private String startPosition;
    private String destination;

    static ArrayList<Traveler> travelerDetails = new ArrayList<Traveler>();

    Scanner sc = new Scanner(System.in);

    public void newTraveler(int seatNumber , String startPosition , String destination ){
        sc.nextLine();
        System.out.println("Enter Name");
        name = sc.nextLine();
        System.out.println("Enter Phone Number");
        phoneNumber = sc.nextLong();
        this.seatNumber = seatNumber;
        this.startPosition = startPosition;
        this.destination = destination;
        Traveler traveler = new Traveler(seatNumber , name , phoneNumber , startPosition , destination);

        travelerDetails.add(traveler);
    }

    public void deleteTraveler(int seatNumber){
        for (int i=0;i<travelerDetails.size();i++){
            if (travelerDetails.get(i).getSeatNumber()==seatNumber){
                travelerDetails.remove(i);
            }
        }
    }


}
