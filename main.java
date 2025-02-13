/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filehandling;

/**
 *
 * @author L12Y16W32
 */
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int choice = -1;
        String text = "";
        boolean isValid;
        
        SubClass operate = new SubClass();
        
        while (choice != 5) {
            isValid = true;
            while (isValid) {
                try {
                    System.out.println("Press 1 - To Add");
                    System.out.println("Press 2 - To Edit");
                    System.out.println("Press 3 - To Delete");
                    System.out.println("Press 4 - To Display");
                    System.out.println("Press 5 - To Exit");
                    
                    System.out.print("Enter choice: ");
                    choice = scan.nextInt();
                    scan.nextLine();
                    
                    if (choice < 1 || choice > 5) {
                        System.out.println("Invalid choice! input must be within 1 - 5");
                    } else {
                        isValid = false;
                    }                    
                } catch (Exception e) {
                    System.out.println("Error input: " + e);
                    scan.nextLine();
                }
            }
            
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to add: ");
                    text = scan.nextLine();
                    operate.Add(text);     
                }
                
                case 2 -> {
                    int index = -1; 
                    isValid = false; 
                    while (!isValid) {
                        try {
                            System.out.print("Enter index number: ");
                            index = scan.nextInt();   
                            operate.indexChecker(index);
                            scan.nextLine();
                            isValid = true; 
                        } catch (Exception e) {
                            System.out.println("Error: " + e);
                            scan.nextLine(); 
                        }
                    }
                    System.out.print("Enter updated value: ");
                    text = scan.nextLine(); 
                    operate.Edit(index, text);
                }
                
                case 3 -> {
                    System.out.print("Enter value to delete: ");
                    text = scan.nextLine();
                    operate.Delete(text);
                }
                
                case 4 -> {
                    System.out.println("The contents of the file:");
                    operate.Display();
                }
                
                case 5 -> {
                    System.out.println("Good bye!");
                }
            }
        }
    }
}
