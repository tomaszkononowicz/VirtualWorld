/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import organism.Organism;
import world.Position;
import world.World;

/**
 *
 * @author Tomasz
 */
abstract public class Animal extends Organism{
    Animal(Position position, World world) {
        super(position, world);
    }

    public void action(Position newPosition) {
        World worldTmp = getWorld();
        if ((worldTmp.inMap(newPosition)) && (!getPosition().equal(newPosition))) {
            Organism opponent = worldTmp.getOrganism(newPosition);
            if (opponent != null) {
                if (opponent.collision(this)) {
                    if (attack(opponent)) {
                        if (opponent instanceof Animal) killLog(opponent);
                        else eatLog(opponent);
                        opponent.deleteFromContainer();
                        moveAnimal(newPosition);
                    }
                    else {
                        if (opponent instanceof Animal) opponent.killLog(this);
                        else eatLog(opponent);
                        deleteFromContainer();
                    }
                }
            }
            else moveAnimal(newPosition);
        }
    }
    
    public void moveAnimal(Position newPosition) {
        setPosition(newPosition);
    }
    
    public boolean attack(Organism defender) {
        if (strength >= defender.getStrength()) return true;
        return false;
    }
    
    abstract public boolean reproduce(Organism agressor);
}
