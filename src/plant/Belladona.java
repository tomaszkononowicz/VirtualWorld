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
public class Belladona extends Plant{

    public Belladona(Position position, World world) {
        super(position, world);
        strength = 99;
        name = "Wilcza jagoda";
    }

    @Override
    public boolean collision(Organism agressor) {
        agressor.setStrength(getStrength()-1);
        return true;
    }

    @Override
    public void action() {
            super.reproduce();
    }
    
}
