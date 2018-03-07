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
public class Tortoise extends Animal{
    private int waitForChangePosition;
    public Tortoise(Position position, World world) {
        super(position, world);
        strength = 2;
        initiative = 1;
        name = "Zolw";
        waitForChangePosition = 0;
        
    }
    
    public boolean collision(Organism agressor) {
        if (reproduce(agressor)) return false;
        else if (agressor.getStrength() < 5) return false;
        return true;
    }
    
    public void action() {
        waitForChangePosition = ++waitForChangePosition % 4;
        Position newPosition = new Position(getPosition().getX(), getPosition().getY());
        newPosition.offset(1);
        if (waitForChangePosition == 0) super.action(newPosition);
    }
    
    public boolean reproduce(Organism agressor) {
        if (agressor instanceof Wolf) {
            Position tmp = getFreeAround();
                if (tmp != null) {
                    new Tortoise(tmp, getWorld());
                    reproduceLog();
                 }
            return true;
            }
        return false;
    }

}
