/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworld;

import gui.Window;
import animal.*;
import gui.KeyboardListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import organism.Organism;
import world.Position;
import world.World;

/**
 *
 * @author Tomasz
 */
public class VirtualWorld {

    /**
     * @param args the command line arguments
     */
    private static final int WIDTH = 25;
    private static final int HEIGHT = 20;
    
    public static void main(String[] args) {
        World world = new World(WIDTH,HEIGHT);
        Window window = new Window(world);
        window.getBoard().refreshBoard(world);
    }
    
}
