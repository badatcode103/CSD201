/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csdassignment;

/**
 *
 * @author ASUS
 */
public class Assignment2 {

    private class BookNode {

        private String id, title, author, publisher, imageUrlS, imageUrlM, imageUrlL;
        private int yearOfPublic;
        private BookNode left, right;

        public BookNode(String id, String title, String author, String publisher, String imageUrlS, String imageUrlM, String imageUrlL, int yearOfPublic) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.publisher = publisher;
            this.imageUrlS = imageUrlS;
            this.imageUrlM = imageUrlM;
            this.imageUrlL = imageUrlL;
            this.yearOfPublic = yearOfPublic;
            left = right = null;
        }
    }
    
    private BookNode root;
    
    public void addBook(BookNode book){
        
    }
    
    public void addBookRec(BookNode root, BookNode book){
        
    }
    
    public void searchBook(String id){
        
    }
    
    public void searchBookRec(String id, BookNode root){
        
    }

    public static void main(String[] args) {

    }
}
