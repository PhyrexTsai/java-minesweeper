/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yjtsai.minesweeper;

import dev.yjtsai.minesweeper.commend.CommendFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author yjtsai
 */
public class Minesweeper {
    public static void main(String[] args){
        System.out.println("Hello, welcome to commend line mode minesweeper.");
        System.out.println("You can start by use \"init\".");
        System.out.println("You can use \"help\" for help.");
        System.out.println("Good luck! Enjoy the game!");
        try { 
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
    
            CommendFactory commend;
            
            while (line.equalsIgnoreCase("quit") == false) {
                line = in.readLine();
                //System.out.println("line : " + line);
                
                commend = new CommendFactory(line);                
                // call function use invoke
                // invoke with method
            }
    
            in.close();
        } catch (IOException ex){
            System.out.println("Minesweeper have went wrong!");
            
        }
    }
}
