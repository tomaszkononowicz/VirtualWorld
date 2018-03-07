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
public class Grass extends Plant {
        public Grass(Position position, World world) {
        super(position, world);
        strength = 0;
        name = "Trawa";
    }

    @Override
    public boolean collision(Organism agressor) {
        return true;
    }

    @Override
    public void action() {
            super.reproduce();
    }
}
