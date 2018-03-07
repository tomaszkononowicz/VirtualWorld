/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organism;

import java.io.Serializable;
import world.Position;
import world.World;

/**
 *
 * @author Tomasz
 */
abstract public class Organism implements Serializable {
    protected int strength;
    protected int initiative;
    protected int birthTurn;
    protected String name;
    protected Position position;
    protected World world;
    
    public Organism(Position position, World world) {
        this.position = position;
        this.birthTurn = world.getTurns();
        this.world = world;
        this.addToContainer();
    }
    
    public int getInitiative() {
        return initiative;
    }
    
    public int getStrength() {
        return strength;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBirthTurn() {
        return birthTurn;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public World getWorld() {
        return world;
    }
    
    public void setStrength(int strength) {
        this.strength = strength;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }
    
    public void setPosition(int x, int y) {
        position = new Position(x, y);
    }
    
    public void addToContainer() {
        world.getContainer().add(this);
    }
    
    public void deleteFromContainer() {
        world.getContainer().delete(this);
    }
    
    public Position getFreeAround() {
        for (int i=-1; i<2; i++) {
            for (int j= -1; j<2; j++) {
                Position tmp = new Position(getPosition().getX() + i, getPosition().getY() + j);
                if (world.inMap(tmp)) {
                    if (world.getOrganism(tmp)  == null) return tmp;
                }
            }
        }
        return null;
    }
    
    abstract public boolean collision(Organism agressor);
    abstract public void action();
    
    public void eatLog(Organism organism) {
        String log = new String(getName() + " zjadl " + organism.getName());
        world.addLog(log);
    }
    
    public void killLog(Organism organism) {
        String log = new String(getName() + " zabil " + organism.getName());
        world.addLog(log);
    }
    
    public void reproduceLog() {
        String log = new String(getName() + " rozmnozyl sie");
        world.addLog(log);
    }
    
}
