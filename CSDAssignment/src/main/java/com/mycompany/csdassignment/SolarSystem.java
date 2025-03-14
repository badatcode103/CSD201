/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csdassignment;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nguyen_Huu_Minh( DE190686 )
 */

/*
Link file trả lời câu hỏi 1 và 2 trong assignment: https://docs.google.com/document/d/1er0RDzNo7o2IYhqGbAq91lWK-Tbn4zFwnPJdy7_yrxg/edit?tab=t.0
*/

/*
Applying Singly LikedList
 */


public class SolarSystem {

    class Planet {

        String name;
        Double equatorialDiameter, mass, semiMajorAxis, orbitalPeriod;
        Planet next;

        public Planet(String name, Double equatorialDiameter, Double mass, Double semiMajorAxis, Double orbitalPeriod) {
            this.name = name;
            this.equatorialDiameter = equatorialDiameter;
            this.mass = mass;
            this.semiMajorAxis = semiMajorAxis;
            this.orbitalPeriod = orbitalPeriod;
            next = null;
        }

        @Override
        public String toString() {
            return "Planet{" + "name=" + name + ", equatorialDiameter=" + equatorialDiameter + ", mass=" + mass + ", semiMajorAxis=" + semiMajorAxis + ", orbitalPeriod=" + orbitalPeriod + ", next=" + next + '}';
        }
    }

    Planet head, tail;
    

    public SolarSystem(Planet head) {
        this.head = head;
        this.tail = head;
        
    }

    public SolarSystem() {
        
    }

    boolean isEmpty() {
        return head == null;
    }
    
    void displaySolarSystem(){
        if(isEmpty()){
            System.out.println("The Solar System is empty, input planet to diaplay.");
        }
        Planet temp = head;
        while(temp != null){
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    void addPlanetAtLast() {
        Planet p = inputPlanetInfor();
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    void add(Planet p) {
        if (isEmpty()) {
            head = tail = p;
        }
        tail.next = p;
        tail = p;

    }

    void sortByMass() {
        if (isEmpty()) {
            System.out.println("No planet to sort. Please input planet!");
        }
        Planet temp = head;
        Double[] arr = new Double[10];
        int i = 0;
        int length = 0;
        while (temp != null) {
            arr[i] = temp.mass;
            temp = temp.next;
            length = i + 1;
            i++;
        }
        boolean check = false;
        for (int j = 0; j < length; j++) {
            for (int q = 0; q < length - j - 1; q++) {
                if (arr[q] > arr[q + 1]) {
                    Double temp1 = arr[q + 1];
                    arr[q + 1] = arr[q];
                    arr[q] = temp1;
                    check = true;
                }

            }
            if (!check) {
                System.out.println("Already sorted.");
                return;
            }
        }

        SolarSystem tempList = new SolarSystem();

        for (int k = 0; k < length; k++) {
            Planet found = getPlanetByMass(arr[k]);
            if (found != null) {
                tempList.add(new Planet(found.name, found.equatorialDiameter, found.mass, found.semiMajorAxis, found.orbitalPeriod));
            }
        }

        head = tempList.head;

    }

    Planet getPlanetByMass(Double mass) {
        Planet temp = head;
        while (temp != null) {
            if (Double.compare(temp.mass, mass) == 0) {
                return temp;
            } else {
                temp = temp.next;
            }
        }
        return null;
    }

    void sortByEquatorialDiameter() {
        if (isEmpty()) {
            System.out.println("No planet to sort. Please input planet!");
        }
        Planet temp = head;
        Double[] arr = new Double[10];
        int i = 0;
        int length = 0;
        while (temp != null) {
            arr[i] = temp.equatorialDiameter;
            temp = temp.next;
            length = i + 1;
            i++;
        }
        boolean check = false;
        for (int j = 0; j < length; j++) {
            for (int q = 0; q < length - j - 1; q++) {
                if (arr[q] > arr[q + 1]) {
                    Double temp1 = arr[q + 1];
                    arr[q + 1] = arr[q];
                    arr[q] = temp1;
                    check = true;
                }

            }
            if (!check) {
                System.out.println("Already sorted.");
                return;
            }

        }

        SolarSystem tempList = new SolarSystem();

        for (int k = 0; k < length; k++) {
            Planet found = getPlanetByMass(arr[k]);
            if (found != null) {
                tempList.add(new Planet(found.name, found.equatorialDiameter, found.mass, found.semiMajorAxis, found.orbitalPeriod));
            }
        }
        head = tempList.head;
    }

    Planet getPlanetByEquatorialDiameter(Double equatorialDiameter) {
        Planet temp = head;
        while (temp != null) {
            if (Double.compare(temp.equatorialDiameter, equatorialDiameter) == 0) {
                return temp;
            } else {
                temp = temp.next;
            }
        }
        return null;
    }

    void displayPlanetByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter planet name: ");
        String name = sc.nextLine();
        Planet temp = head;
        boolean check = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.toString());
                check = true;
            } else {
                temp = temp.next;
            }
        }
        if (!check) {
            System.out.println("Planet not found.");
        }
    }

    void deletePlanetByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter planet name: ");
        String name = sc.nextLine();
        boolean check = false;
        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            check = true;
        }
        if (head == tail) {
            if (head.name.equalsIgnoreCase(name)) {
                head = head.next;
                check = true;
            }
        }
        Planet temp = head;
        while (temp != null && temp.next != null) {

            if (temp.name.equalsIgnoreCase(name)) {
                temp.next = temp.next.next;
                if (temp.next == null) {
                    tail = temp;
                }
                check = true;
                break;
            } else {
                temp = temp.next;
            }
        }
        if (!check) {
            System.out.println("Planet not found.");
        }
    }

    Planet inputPlanetInfor() {
        String name;
        Double eDiameter, mass, smAxis, oPeriod;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Input planet name: ");
                name = sc.nextLine();

                System.out.println("Input planet equatorial diameter: ");
                eDiameter = sc.nextDouble();
                System.out.println("Input planet mass: ");
                mass = sc.nextDouble();
                System.out.println("Input planet semi major axis: ");
                smAxis = sc.nextDouble();
                System.out.println("Input planet orbital period: ");
                oPeriod = sc.nextDouble();
                sc.nextLine();
                return new Planet(name, eDiameter, mass, smAxis, oPeriod);
            } catch (InputMismatchException e) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine();
            }
        }
    }
}
