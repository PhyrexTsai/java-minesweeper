/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yjtsai.minesweeper.commend.initial;

import dev.yjtsai.minesweeper.component.BlankComponent;
import dev.yjtsai.minesweeper.component.BombComponent;
import dev.yjtsai.minesweeper.component.Component;
import dev.yjtsai.minesweeper.component.FlagComponent;
import dev.yjtsai.minesweeper.component.OpenComponent;

/**
 *
 * @author yjtsai
 */
public class Board {
    
    private Integer width = 8;
    private Integer height = 8;
    private Integer bombSize = 10;
    private String[][] board;
    private String[][] bomb;
    private Boolean[][] done;
    private static Board thisBoard = new Board();
    private boolean alive = true;
    
    public static Board draw() {
        return thisBoard;
    }
    
    public void init() {
        alive = true;
        Component blank = new BlankComponent();
        board = new String[width][height];
        bomb = new String[width][height];
        done = new Boolean[width][height];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                board[j][i] = blank.draw();
                bomb[j][i] = "";
                done[j][i] = false;
            }
        }
        renderBomb();
    }
    
    public String[][] now() {
        return board;
    }
    
    public void change(Integer x, Integer y, Component component) {
        board[x][y] = component.draw();
        if(component.draw().equals(BombComponent.BOMB)){
            alive = false;
        }
    }
    
    public void show() {
        show(board);
        //show(bomb);
        if(!alive){
            gameover();
        }
        if(isWin()){
            win();
        }
    }
    
    private void show(String[][] template){
        for(int x=-1;x<width;x++){
            if(x == -1){
                System.out.print("　 ");
            }else{
                String xStr = "";
                if(x < 10){
                    xStr += "0" + x;
                }
                System.out.print(xStr + " ");
            }
        }
        System.out.print("\r\n");
        for(int i=0;i<height;i++){
            for(int j=-1;j<width;j++){
                if(j == -1){
                    String yStr = "";
                    if(i < 10){
                        yStr += "0" + i;
                    }
                    System.out.print(yStr + " ");
                }else{
                    System.out.print(template[j][i] + " ");
                }
            }
            System.out.print("\r\n");
        }
    }
    
    private void renderBomb() {
        for(int i=0;i<bombSize;i++){
            putBomb();
        }
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                putNumber(j, i);
            }
        }
    }
    
    private void putBomb() {
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);
        if(bomb[x][y].equals(BombComponent.BOMB)){
            putBomb();
        }else{
            bomb[x][y] = BombComponent.BOMB;
        }
    }
    
    private void putNumber(int x, int y) {
        if(bomb[x][y].equals(BombComponent.BOMB)){
            return;
        }
        int xStart = (x - 1 >= 0) ? x - 1 : x;
        int xEnd = (x + 1 < width) ? x + 1 : x;
        int yStart = (y - 1 >= 0) ? y - 1 : y;
        int yEnd = (y + 1 < height) ? y + 1 : y;
        int bombCount = 0;
        
        String str = "";
        for(int i = yStart; i <= yEnd; i++){
            for(int j = xStart; j <= xEnd; j++){
                //System.out.println("bomb[" + j + "][" + i + "] = " + bomb[j][i]);
                if(bomb[j][i].equalsIgnoreCase(BombComponent.BOMB)){
                    bombCount++;
                }
            }
        }
        switch(bombCount){
            case 1 : 
                str = "１";
                break;
            case 2 : 
                str = "２";
                break;
            case 3 : 
                str = "３";
                break;
            case 4 : 
                str = "４";
                break;
            case 5 : 
                str = "５";
                break;
            case 6 : 
                str = "６";
                break;
            case 7 : 
                str = "７";
                break;
            case 8 : 
                str = "８";
                break;
            default : 
                str = "　";
        }
        bomb[x][y] = str;
    }

    public void blankOpen(Integer x, Integer y) {
        if(done[x][y] == true){
            return ;
        }
        int xStart = (x - 1 >= 0) ? x - 1 : x;
        int xEnd = (x + 1 < width) ? x + 1 : x;
        int yStart = (y - 1 >= 0) ? y - 1 : y;
        int yEnd = (y + 1 < height) ? y + 1 : y;
        done[x][y] = true;
        for(int i = yStart; i <= yEnd; i++){
            for(int j = xStart; j <= xEnd; j++){
                board[j][i] = bomb[j][i];
                if( !bomb[j][i].equals(BombComponent.BOMB) && 
                    bomb[j][i].equals(OpenComponent.OPEN) && 
                    !(i == y && j == x)){
                    blankOpen(j, i);
                }
            }
        }
    }
    
    public String[][] getBoard() {
        return board;
    }
    
    public String[][] getBomb() {
        return bomb;
    }
    
    public boolean isAlive() {
        return alive;
    }
    
    public boolean isWin() {
        boolean win = true;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(board[j][i].equals(BlankComponent.BLANK)){
                    win = false;
                }
                if(win == true && bomb[j][i].equals(BombComponent.BOMB) && !board[j][i].equals(FlagComponent.FLAG)){
                    win = false;
                }
            }
        }
        return win;
    }
    
    public void gameover() {
        System.out.println("Game Over!You have trigger the bomb!");
        System.out.println("If you want play again, use \"init\" to start a new game.");
    }
    
    public void win() {
        System.out.println("Congratulations you have done this!");
        System.out.println("If you want play again, use \"init\" to start a new game.");
    }
}
