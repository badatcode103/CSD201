/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csdassignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    private boolean searchBookResult;

   
    public void addBook(BookNode book) {
        root = addBookRec(root, book);
    }

   
    private BookNode addBookRec(BookNode root, BookNode book) {
        if (root == null) {
            return book;
        }

        if (compareIds(book.id, root.id) < 0) {
            root.left = addBookRec(root.left, book);
        } else if (compareIds(book.id, root.id) > 0) {
            root.right = addBookRec(root.right, book);
        }

        return root;
    }

 
    public void searchBook(String id) {
        searchBookResult = searchBookRec(root, id);
    }


    private boolean searchBookRec(BookNode root, String id) {
        if (root == null) {
            return false;
        }
        if (compareIds(root.id, id) == 0) {
            return true;
        }
        return compareIds(id, root.id) < 0 ? searchBookRec(root.left, id) : searchBookRec(root.right, id);
    }

 
    public void deleteBook(String id) {
        root = deleteBookRec(root, id);
    }


    private BookNode deleteBookRec(BookNode root, String id) {
        if (root == null) {
            return root;
        }

        if (compareIds(id, root.id) < 0) {
            root.left = deleteBookRec(root.left, id);
        } else if (compareIds(id, root.id) > 0) {
            root.right = deleteBookRec(root.right, id);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.id = minValue(root.right);
            root.right = deleteBookRec(root.right, root.id);
        }

        return root;
    }


    private String minValue(BookNode root) {
        String minValue = root.id;
        while (root.left != null) {
            minValue = root.left.id;
            root = root.left;
        }
        return minValue;
    }


    private int compareIds(String id1, String id2) {  
        id1 = removeSuffixX(id1);
        id2 = removeSuffixX(id2);

        return id1.compareTo(id2); 
    }
    
    private String removeSuffixX(String id) {
        if (id.endsWith("x")) {
            return id.substring(0, id.length() - 1); 
        }
        return id;
    }

  
    public static void main(String[] args) {
        Assignment2 tree = new Assignment2(); 

       
        String fileName = "C:\\Users\\ASUS\\Documents\\Zalo Received Files"; 
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {  
                    String id = data[0];
                    String title = data[1];
                    String author = data[2];
                    String publisher = data[3];
                    String imageUrlS = data[4];
                    String imageUrlM = data[5];
                    String imageUrlL = data[6];
                    int yearOfPublic = Integer.parseInt(data[7]);
                    BookNode book = tree.new BookNode(id, title, author, publisher, imageUrlS, imageUrlM, imageUrlL, yearOfPublic); // Sửa ở đây
                    tree.addBook(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        String searchId = "765760355"; 
        long startTime = System.nanoTime();

        
        tree.searchBook(searchId);

        long endTime = System.nanoTime();
       
        if (tree.searchBookResult) {
            System.out.println(" Find book with ID " + searchId + ": found!");
        } else {
            System.out.println(" Find book with ID " + searchId + ": not found!");
        }

        System.out.println(" finding time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        
        String deleteId = "342330426X"; 
        startTime = System.nanoTime();

        tree.deleteBook(deleteId);

        endTime = System.nanoTime();
        System.out.println("️ Delete book with ID " + deleteId);
        System.out.println(" Deleting time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}
