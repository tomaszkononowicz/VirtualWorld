/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import animal.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import organism.Container;
import organism.Organism;
import plant.*;

/**
 *
 * @author Tomasz
 */
public class World implements Serializable {
    private int turns;
    private int height;
    private int width;
    private Container container;
    private List<String> logs = new ArrayList<String>();
    private static final long serialVersionUID = 6529685098267757690L;
    
    public World(int width, int height) {
        this.width = width;
        this.height = height;
        container = new Container();
        newGame();
    }
    
    public int getTurns() {
        return turns;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public Container getContainer() {
        return container;
    }
    
    public boolean inMap(Position position) {
        if (position.getX() < 0
                || position.getX() >= width
                || position.getY() < 0
                || position.getY() >= height) return false;
        return true;
    }
    
    public Organism getOrganism(Position position) {
        for (Organism o : getContainer().getListOrganism()) {
            
            if (o != null && o.getPosition().getX() == position.getX()
                    && o.getPosition().getY() == position.getY())
                return o;
        }
    return null;
    }
    
    public void addLog(String log) {
        logs.add(log);
    }
    
    public void clearLogs() {
        logs.clear();
    }
    
    public List<String> getLogs() {
        return logs;
    }
    
    public void nextTurn(){
        clearLogs();
        getContainer().removeNulls();
	getContainer().sort();
	int size = getContainer().getSize();
	for (int i = 0; i < size; i++) {
		if (getContainer().getOrganism(i) != null)
		getContainer().getOrganism(i).action();
	}
	turns++;
    }
    
    public void newGame() {
        container.clear();
        Random generator = new Random();
        for (int i = 0; i < 16; i++) {
		int x, y;
		do {
			x = generator.nextInt(width);
			y = generator.nextInt(height);
			
		} while (getOrganism(new Position(x, y)) != null);
                Position position = new Position(x, y);
		switch (i) {
		case 0: new Human(position, this); break;
                case 1: new Antylope(position, this); break;
                case 2: new Belladona(position, this); break;
                case 3: new Belladona(position, this); break;
                case 4: new Grass(position, this); break;
                case 5: new Guarana(position, this); break;
                case 6: new Dandelion(position, this); break;
                case 7: new Wolf(position, this); break;
                case 8: new Wolf(position, this); break;
                case 9: new Sheep(position, this); break;
                case 10: new Sheep(position, this); break;
                case 11: new Tortoise(position, this); break;
                case 12: new Tortoise(position, this); break;
                case 13: new Fox(position, this); break;
                case 14: new Fox(position, this); break;
                case 15: new Antylope(position, this); break;
                }

	}
    }
}
