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
public class Fox extends Animal{
    
    public Fox(Position position, World world) {
        super(position, world);
        strength = 3;
        initiative = 7;
        name = "Lis";
    }
    
    public boolean collision(Organism agressor) {
        if (reproduce(agressor)) return false;
        return true;
    }
    
    public void action() {
        Position newPosition = new Position(getPosition().getX(), getPosition().getY());
        newPosition.offset(1);
        if (world.inMap(newPosition))
            if ((world.getOrganism(newPosition)) == null
                    || (world.getOrganism(newPosition) != null
                        && (world.getOrganism(newPosition).getStrength() <= strength))) 
                        super.action(newPosition);
    }
    
    public boolean reproduce(Organism agressor) {
        if (agressor instanceof Fox) {
            Position tmp = getFreeAround();
                if (tmp != null) {
                    new Fox(tmp, getWorld());
                    reproduceLog();
                }
            return true;
            }
        return false;
    }
}
