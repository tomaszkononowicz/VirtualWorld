/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import organism.Organism;
import world.Position;
import world.World;

/**
 *
 * @author Tomasz
 */
public class Sheep extends Animal{
        public Sheep(Position position, World world) {
        super(position, world);
        strength = 4;
        initiative = 4;
        name = "Owca";
    }
    
    public boolean collision(Organism agressor) {
        if (reproduce(agressor)) return false;
        return true;
    }
    
    public void action() {
        Position newPosition = new Position(getPosition().getX(), getPosition().getY());
        newPosition.offset(1);
        super.action(newPosition);
    }
    
    public boolean reproduce(Organism agressor) {
        if (agressor instanceof Sheep) {
            Position tmp = getFreeAround();
                if (tmp != null) {
                    new Sheep(tmp, getWorld());
                    reproduceLog();
                }
            return true;
            }
        return false;
    }
}
