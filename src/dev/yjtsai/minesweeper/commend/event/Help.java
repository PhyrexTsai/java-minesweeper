/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yjtsai.minesweeper.commend.event;

/**
 *
 * @author yjtsai
 */
public class Help {
    public Help(){
        System.out.println("\"init\" : Start a new game.");
        System.out.println("\"flip\" : Flip the blank space. Use \"flip x,y\" => \"flip 0,1\" : Open the blank for (0,1).");
        System.out.println("\"flag\" : Flag the blank space the bomb you think where is. Use \"flag x,y\" => \"flag 0,1\" : Mark the blank to flag for (0,1).");
        System.out.println("\"unknown\" : Mark the blank space that you don't know what is it. Use \"unknown x,y\" => \"unknown 0,1\" : Mark the blank to unknown for (0,1).");
        System.out.println("\"quit\" : Quit game.");
    }
}
