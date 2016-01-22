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
import dev.yjtsai.minesweeper.component.FlagComponent;

/**
 *
 * @author yjtsai
 */
public class Flag {
    
    public Flag(Integer x, Integer y, String[][] board, String[][] bomb) {
        Component component = new FlagComponent();
        Board.draw().change(x, y, component);
        Board.draw().show();
    }
}
