/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualworld;

import gui.Window;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import world.World;

/**
 *
 * @author Tomasz
 */
public class File {

    World world;

    public File(World world) {
        this.world = world;
    }

    public static void saveGame(World world) throws FileNotFoundException, IOException {
        FileOutputStream fileOut = new FileOutputStream("saved.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(world);
        out.close();
        fileOut.close();

    }

    public static void loadGame(Window window) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("saved.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        window.updateWorld((World) in.readObject());
        in.close();
        fileIn.close();
    }
}
