/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filehandling;

/**
 *
 * @author L12Y16W32
 */
import java.io.*;
import java.util.*;

public class SubClass implements SuperClass {
    private ArrayList<String> listOf = new ArrayList<>();
    private final String FILE_NAME = "data.txt"; 

    @Override
    public void Add(String text) {
        listOf.add(text);
        writeToFile();  
        System.out.println("Successfully added!");
    }

    @Override
    public void indexChecker(int index) {
        if (index < 0 || index >= listOf.size()) {
            System.out.println("Index does not exist!");
            throw new IllegalArgumentException("\nInvalid index");
        }
    }

    @Override
    public void Edit(int index, String text) {
        if (index >= 0 && index < listOf.size()) {
            listOf.set(index, text);
            writeToFile();  
            System.out.println("Value updated!");
        } else {
            System.out.println("Invalid index!");
        }
    }

    @Override
    public void Delete(String text) {
        if (listOf.remove(text)) {
            writeToFile();  
            System.out.println("Successfully removed!");
        } else {
            System.out.println("Non-existing value!");
        }
    }

    @Override
    public void Display() {
        int i = 0;
        for (String s : listOf) {
            System.out.println(i + " - " + s);
            i++;
        }
    }

    @Override
    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String item : listOf) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
