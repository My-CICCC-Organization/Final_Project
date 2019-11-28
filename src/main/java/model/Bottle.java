package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Bottle {


        public static void set_Size(String info){
            try (FileWriter fw = new FileWriter("bottle", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)){
                 out.println(info);
                System.out.println("*Data Saved in memo.txt");
                bw.close();
                out.close();
            } catch (IOException e) {
                System.out.println("Some Problems bro!");
            }
        }

}
