/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javafx.scene.layout.Border;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import world.World;

/**
 *
 * @author Tomasz
 */
public class Window extends JFrame{
    Adding adding;
    Board board;
    Logs logs;
    World world;
    KeyboardListener keyboardListener;
    public Window(World world) {
        setTitle("Tomasz Kononowicz s160839");
        this.world = world;
        board = new Board(world, this);
        adding = new Adding(world, this);
        logs = new Logs(new JTextArea());
        keyboardListener = new KeyboardListener(world, this);
        addKeyListener(keyboardListener);
        setSize(1200,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        setLayout(new BorderLayout());
        contentPane.setBackground(Color.yellow);
        contentPane.add(board, BorderLayout.CENTER);
        contentPane.add(logs, BorderLayout.LINE_END);
        contentPane.add(adding, BorderLayout.PAGE_END);
        this.setFocusable(true);
        
        


        setVisible(true);
    }
    
    public Board getBoard() {
        return board;
    }
    
    public void updateWorld(World world) {
        this.world = world;
        keyboardListener.worldUpdate(world);
        board.worldUpdate(world);
        adding.worldUpdate(world);
    }
    
}
