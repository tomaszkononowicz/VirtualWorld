/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import animal.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.BOTH;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import organism.Organism;
import plant.*;
import world.Position;
import world.World;

/**
 *
 * @author Tomasz
 */
public class Board extends JPanel{
    private BoardButton[][] boardButtons;
    private BoardButton selected;
    private ButtonsListener boardListener;
    public Board(World world, Window window) {
        setBackground(Color.GREEN);
        setLayout(new GridBagLayout());
        setFocusable(false);
        setBorder(new EmptyBorder(15,15,15,15));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.insets = new Insets(1,1,1,1);
        boardListener = new ButtonsListener(world, window);
        boardButtons = new BoardButton[world.getWidth()][];
        for (int x=0; x<world.getWidth(); x++) {
            boardButtons[x]=new BoardButton[world.getHeight()];
            for (int y=0; y<world.getHeight(); y++) {
                boardButtons[x][y]=new BoardButton(x,y,window);
                boardButtons[x][y].addActionListener(boardListener);
                gridBagConstraints.gridx = x;
                gridBagConstraints.gridy = y;
                add(boardButtons[x][y], gridBagConstraints);
                boardButtons[x][y].setVisible(true);
                boardButtons[x][y].setFocusable(false);
                selected = boardButtons[x][y];
            }
        }
    }
    
    public void setSelected(BoardButton selected) {
        this.selected = selected;
    }
    
    public BoardButton getSelected() {
        return selected;
    }
    
    public void refreshBoard(World world) {
        Position position = new Position(0,0);
        ImageIcon iI = new ImageIcon("empty.png");
        for (int x=0; x<world.getWidth(); x++) {
            for (int y=0; y<world.getHeight(); y++) {
                position.setX(x);
                position.setY(y);
                BoardButton bb = boardButtons[x][y];
                Organism o = world.getOrganism(position);
                if (o != null) {
                    if (o instanceof Antylope) iI = new ImageIcon("antylope.png");
                    else if (o instanceof Fox) iI = new ImageIcon("fox.png");
                    else if (o instanceof Sheep) iI = new ImageIcon("sheep.png");
                    else if (o instanceof Tortoise) iI = new ImageIcon("tortoise.png");
                    else if (o instanceof Wolf) iI = new ImageIcon("wolf.png");
                    else if (o instanceof Dandelion) iI = new ImageIcon("dandelion.png");
                    else if (o instanceof Belladona) iI = new ImageIcon("belladona.png");
                    else if (o instanceof Grass) iI = new ImageIcon("grass.png");
                    else if (o instanceof Guarana) iI = new ImageIcon("guarana.png"); 
                    else if (o instanceof Human) iI = new ImageIcon("human1.png");
                    else iI = new ImageIcon("empty.png");
                }
                else iI = new ImageIcon("empty.png");
                bb.setIcon(iI);
            }
        }
    }
    
    public void worldUpdate(World world) {
        boardListener.worldUpdate(world);
    }
}
