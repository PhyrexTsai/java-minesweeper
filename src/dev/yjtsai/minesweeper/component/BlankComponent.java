/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yjtsai.minesweeper.component;

/**
 *
 * @author yjtsai
 */
public class BlankComponent implements Component {

    public static final String BLANK = "■";
    
    @Override
    public String draw() {
        return "■";
    }
    
}
