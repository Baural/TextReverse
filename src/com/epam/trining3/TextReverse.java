package com.epam.trining3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextReverse {
    public static void main (String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean success = false;
        String filename = "input.txt";
        String str = null;

        while ( !success ) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ( (line = br.readLine()) != null) {
                    sb.append(line);
                }
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
                    str = sb.toString();
                    System.out.println("Put some words");
                    Scanner scanner = new Scanner(System.in);
                    str = str + scanner.nextLine();
                    bw.write(sb.reverse().toString());
                    success = true;
                }
            } catch (FileNotFoundException e) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("default.txt"))) {
                    bw.write("Hello Java!");
                    filename = "default.txt";
                } catch (IOException f) {

                }
            } catch (IOException e) {

            }
        }

        System.out.println(str);

    }
}
