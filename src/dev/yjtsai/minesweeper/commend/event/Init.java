/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yjtsai.minesweeper.commend.event;

import dev.yjtsai.minesweeper.commend.initial.Board;

/**
 *
 * @author yjtsai
 */
public class Init {
    
    public Init() {
        Board.draw().init();
        Board.draw().show();
    }
    
}
