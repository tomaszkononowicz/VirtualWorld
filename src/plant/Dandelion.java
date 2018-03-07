/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plant;

import organism.Organism;
import world.Position;
import world.World;

/**
 *
 * @author Tomasz
 */
public class Dandelion extends Plant{
    
    public Dandelion(Position position, World world) {
        super(position, world);
        strength = 0;
        name = "Mlecz";
    }

    @Override
    public boolean collision(Organism agressor) {
        return true;
    }

    @Override
    public void action() {
        for (int i = 0; i<3; i++) {
            super.reproduce();
        }
    }
}
