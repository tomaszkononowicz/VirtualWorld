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
public class Guarana extends Plant{
        public Guarana(Position position, World world) {
        super(position, world);
        strength = 0;
        name = "Guarana";
    }

    @Override
    public boolean collision(Organism agressor) {
        agressor.setStrength(agressor.getStrength()+3);
        return true;
    }

    @Override
    public void action() {
            super.reproduce();
    }
}
