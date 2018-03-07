/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organism;

import animal.Human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Tomasz
 */
public class Container implements Serializable  {
    private List<Organism> organisms;
    
    public Container() {
         organisms = new ArrayList<Organism>();
    }
    
    public void add(Organism organism) {
        organisms.add(organism);
    }
    
    public void delete(Organism organism){
        organisms.set(organisms.indexOf(organism), null);
    }
    
    public void removeNulls() {
        for (int i = 0; i < organisms.size(); i++) {
            if (organisms.get(i) == null) {
                organisms.remove(i);
                i--;
            }
        }
    }
    
    public void sort() {
        for (int i=0; i<organisms.size(); i++) {
            for (int j=0; j<i; j++) {
                if (organisms.get(j).getInitiative() < organisms.get(j+1).getInitiative()
                        || (organisms.get(j).getInitiative() == organisms.get(j+1).getInitiative()
                            && organisms.get(j).getBirthTurn() > organisms.get(j+1).getBirthTurn())) Collections.swap(organisms, j, j+1);
            }
        }
    }
    
    public int getSize() {
        return organisms.size();
    }
    
    public Organism getOrganism(Organism organism) {
        for (Organism o : organisms) {
            if (organism.equals(o)) return o;
        }
        return null;
    }
    
    public Organism getOrganism(int i) {
        return organisms.get(i);
    }
    
    public Human getHuman() {
        for (Organism o : organisms) {
            if (o instanceof Human) return ((Human)o);
        }
        return null;
    }
    
    public void clear() {
        organisms.clear();
    }
    
    public List<Organism> getListOrganism() {
        return organisms;
    }
}
