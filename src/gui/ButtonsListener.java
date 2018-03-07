/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import animal.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import virtualworld.File;
import world.Position;
import world.World;

/**
 *
 * @author Tomasz
 */
public class ButtonsListener implements ActionListener {

    private World world;
    private Window window;

    public ButtonsListener(World world, Window window) {
        this.window = window;
        this.world = world;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o instanceof BoardButton) {
            ((BoardButton) o).setSelected();
            if (world.getOrganism(window.board.getSelected().getPosiion()) == null) {
                window.adding.setVisibility(true);
            } else {
                window.adding.setVisibility(false);
            }
        } else if (o instanceof JButton) {
            if (((JButton) o).getText().equals("Dodaj organizm")) {
                Position position = window.board.getSelected().getPosiion();
                switch (window.adding.getFromComboBox()) {
                    case "Antylopa":
                        new Antylope(position, world);
                        break;
                    case "Wilk":
                        new Wolf(position, world);
                        break;
                    case "Owca":
                        new Sheep(position, world);
                        break;
                    case "Zolw":
                        new Tortoise(position, world);
                        break;
                    case "Lis":
                        new Fox(position, world);
                        break;
                }
                if (world.getOrganism(window.board.getSelected().getPosiion()) == null) {
                    window.adding.setVisibility(true);
                } else {
                    window.adding.setVisibility(false);
                }
                window.board.refreshBoard(world);
            } else if (((JButton) o).getText().equals("Nowa gra")) {
                world.newGame();
                window.logs.clear();
                window.board.refreshBoard(world);
            } else if (((JButton) o).getText().equals("Zapisz gre")) {
                try {
                    File.saveGame(world);
                } catch (IOException ex) {
                    world.addLog("Zapis do pliku nie powiodl sie");
                }
            } else if (((JButton) o).getText().equals("Wczytaj gre")) {
                try {
                    File.loadGame(window);
                } catch (IOException ex) {
                    world.addLog("Odczyt z pliku nie powiodl sie");
                } catch (ClassNotFoundException ex) {
                    world.addLog("Odczyt z pliku nie powiodl sie");
                }
                window.logs.clear();
                window.board.refreshBoard(world);
            }
        }
    }

    public void worldUpdate(World world) {
        this.world = world;
    }

}
