/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.csdassignment;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class CSDAssignment {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SolarSystem ss = new SolarSystem();
        int option = Menu();
        sc.nextLine();
        while(true){
            switch(option){
                case 1 -> {
                    ss.addPlanetAtLast();
                    break;
                }
                case 2 -> {
                    ss.deletePlanetByName();
                    break;
                }
                case 3 -> {
                    ss.displayPlanetByName();
                    break;
                }
                case 4 -> {
                    ss.sortByMass();
                    ss.displaySolarSystem();
                    break;               
                }
                case 5 -> {
                    ss.sortByEquatorialDiameter();
                    ss.displaySolarSystem();
                    break;
                }
                case 6 -> {
                    ss.displaySolarSystem();
                    break;
                    
                }
                case 7 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("Wrong input.");
                    break;
                }
            }
        }
    }
    
    
    static int Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Solar System management program.");
        System.out.println("1. Add a planet in the Solar System");
        System.out.println("2. Delete a planet in the Solar System");
        System.out.println("3. Find a planet in the Solar System");
        System.out.println("4. Sort the Solar System by planet's mass");
        System.out.println("5. Sort the Solar System by planet's equatorial diameter");
        System.out.println("6. Display the Solar System.");
        System.out.println("Press 7 to quit program.");
        System.out.println("Input your choice: ");
        return sc.nextInt();
    }
}

