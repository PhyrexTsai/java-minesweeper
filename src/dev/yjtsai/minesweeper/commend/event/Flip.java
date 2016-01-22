/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yjtsai.minesweeper.commend.event;

import dev.yjtsai.minesweeper.commend.initial.Board;
import dev.yjtsai.minesweeper.component.BlankComponent;
import dev.yjtsai.minesweeper.component.BombComponent;
import dev.yjtsai.minesweeper.component.Component;
import dev.yjtsai.minesweeper.component.NumberComponent;
import dev.yjtsai.minesweeper.component.OpenComponent;

/**
 *
 * @author yjtsai
 */
public class Flip {
    
    public Flip(Integer x, Integer y, String[][] board, String[][] bomb) {
        // 數字只翻開單個、空白可以循序打開、炸彈就GG
        Component component = new BlankComponent();
        switch(bomb[x][y]){
            case BombComponent.BOMB : 
                component = new BombComponent();
                break;
            case "　" :
                // open other reference
                component = new OpenComponent();
                Board.draw().blankOpen(x, y);
                break;
            default : 
                component = new NumberComponent(bomb[x][y]);
        }
        Board.draw().change(x, y, component);
        Board.draw().show();
    }
    
}
