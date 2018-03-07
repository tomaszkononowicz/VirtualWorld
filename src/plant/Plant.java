/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plant;

import java.io.Serializable;
import java.util.Random;
import organism.Organism;
import world.Position;
import world.World;

/**
 *
 * @author Tomasz
 */
public abstract class Plant extends Organism{
    public Plant(Position position, World world) {
        super(position, world);
        this.initiative = 0;
    }
    
    public void action(Position newPosition) {};
    
    public boolean reproduce() {
        Random generator = new Random();
        if (generator.nextInt(10) == 0) {
            Position tmp = getFreeAround();
            if (tmp != null) {
                if (this instanceof Belladona) new Belladona(tmp, world);
                else if (this instanceof Dandelion) new Dandelion(tmp, world);
                else if (this instanceof Grass) new Grass(tmp, world);
                else if (this instanceof Guarana) new Guarana(tmp, world);
                reproduceLog();
                }
            return true;
        }
        return false;
    }
}
