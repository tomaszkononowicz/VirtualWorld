/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_L;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_S;
import static java.awt.event.KeyEvent.VK_Z;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import virtualworld.File;
import world.World;

/**
 *
 * @author Tomasz
 */
public class KeyboardListener implements KeyListener {

    private World world;
    private Window window;

    public KeyboardListener(World world, Window window) {
        this.window = window;
        this.world = world;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getExtendedKeyCode() == VK_L) {  
            try {
                File.loadGame(window);
            } catch (IOException ex) {
                world.addLog("Odczyt z pliku nie powiodl sie");
            } catch (ClassNotFoundException ex) {
                world.addLog("Odczyt z pliku nie powiodl sie");
            }
            window.board.refreshBoard(world);
            window.logs.clear();
        } else if (e.getExtendedKeyCode() == VK_N) {
            world.newGame();
            window.board.refreshBoard(world);
            window.logs.clear();
        }
        if (e.getExtendedKeyCode() == VK_S) {
            try {
                File.saveGame(world);
            } catch (IOException ex) {
                world.addLog("Zapis do pliku nie powiodl sie");
            }
        } else {
            window.logs.clear();
            if (world.getContainer().getHuman() != null) {
                world.getContainer().getHuman().setKey(e.getExtendedKeyCode());
            }
            world.nextTurn();
            if (world.getContainer().getHuman() != null) {
                if (world.getContainer().getHuman().getPower() > 0) {
                    world.getContainer().getHuman().burn();
                }
            }
            window.logs.addLogs(world.getLogs());
            window.board.refreshBoard(world);
        }
        if (world.getOrganism(window.board.getSelected().getPosiion()) == null) {
            window.adding.setVisibility(true);
        } else {
            window.adding.setVisibility(false);
        }
        try {
        if (world.getContainer().getHuman() == null)
            throw new MyException("Brak czlowieka na planszy!");
        } catch (MyException ex) {
            window.logs.addLog("Brak czlowieka na planszy!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void worldUpdate(World world) {
        this.world = world;
    }
}
