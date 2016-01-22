/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yjtsai.minesweeper.commend;

import dev.yjtsai.minesweeper.commend.initial.Board;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yjtsai
 */
public class CommendFactory {
    
    private String REG_EXP = "";
    private String commend;
    
    public CommendFactory(String commend) {
        this.commend = commend;
        if(Board.draw().isAlive() || commend.equals("init")){
            parse();
        }else if(!commend.equals("quit")){
            Board.draw().gameover();
        }
    }
    
    private void parse(){
        try {
            String[] commends = commend.split(" ");
            if(commends.length > 2 || commends.length == 0){ 
                System.out.println("Undefind commend. If you need any help, use \"help\".");
                return;
            }
            String commend_0 = commends[0];
            //Class.forName(className)
            String[] coordinate = null;
            if(commends.length > 1){
                coordinate = commends[1].split(",");
            }
            Constructor c;
            switch(commend_0){
                case "init" :
                    Class.forName("dev.yjtsai.minesweeper.commend.event.Init").newInstance();
                    break;
                case "flag" :
                    c = Class.forName("dev.yjtsai.minesweeper.commend.event.Flag").getConstructor(Integer.class, Integer.class, String[][].class, String[][].class);
                    c.newInstance(Integer.valueOf(coordinate[0]), Integer.valueOf(coordinate[1]), Board.draw().getBoard(), Board.draw().getBomb());
                    break;
                case "flip" :
                    c = Class.forName("dev.yjtsai.minesweeper.commend.event.Flip").getConstructor(Integer.class, Integer.class, String[][].class, String[][].class);
                    c.newInstance(Integer.valueOf(coordinate[0]), Integer.valueOf(coordinate[1]), Board.draw().getBoard(), Board.draw().getBomb());
                    break;
                case "unknown" :
                    c = Class.forName("dev.yjtsai.minesweeper.commend.event.Unknown").getConstructor(Integer.class, Integer.class, String[][].class, String[][].class);
                    c.newInstance(Integer.valueOf(coordinate[0]), Integer.valueOf(coordinate[1]), Board.draw().getBoard(), Board.draw().getBomb());
                    break;
                case "help" :
                    Class.forName("dev.yjtsai.minesweeper.commend.event.Help").newInstance();
                    break;
                case "quit" :
                    System.out.println("Thank you! Bye-bye!");
                    break;
                default :
                    System.out.println("Undefind commend. If you need any help, use \"help\".");
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(CommendFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CommendFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommendFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CommendFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(CommendFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CommendFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CommendFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
