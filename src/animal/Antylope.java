/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import java.util.Random;
import organism.Organism;
import world.Position;
import world.World;

/**
 *
 * @author Tomasz
 */
public class Antylope extends Animal{

    public Antylope(Position position, World world) {
        super(position, world);
        strength = 4;
        initiative = 4;
        name = "Antylopa";
    }
    
    public boolean collision(Organism agressor) {
        Random generator = new Random();
        if (reproduce(agressor)) return false;
        else if (generator.nextInt(2) == 0) {
            Position tmp = getFreeAround();
            if (tmp != null) {
                moveAnimal(tmp);
            }
            
        }
        return true;
    }
    
    public void action() {
        Position newPosition = new Position(getPosition().getX(), getPosition().getY());
        newPosition.offset(2);
        super.action(newPosition);
    }
    
    public boolean reproduce(Organism agressor) {
        if (agressor instanceof Antylope) {
            Position tmp = getFreeAround();
                if (tmp != null) {
                    new Antylope(tmp, getWorld());
                    reproduceLog();
                }
            return true;
            }
        return false;
    }
    
}
