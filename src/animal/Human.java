/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_L;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_P;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_S;
import static java.awt.event.KeyEvent.VK_UP;
import organism.Organism;
import virtualworld.File;
import world.Position;
import world.World;

/**
 *
 * @author Tomasz
 */
public class Human extends Animal {

    private static final int COOLDOWN = 5;
    private static final int POWER_TIME = 5;
    private int power;
    private int key;

    public Human(Position position, World world) {
        super(position, world);
        power = -COOLDOWN;
        strength = 5;
        initiative = 4;
        name = "Czlowiek";
    }

    @Override
    public boolean reproduce(Organism agressor) {
        return false;
    }

    @Override
    public boolean collision(Organism agressor) {
        return true;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getPower() {
        return power;
    }

    public void action() {
        if (power > -COOLDOWN) {
            power--;
        }
        if (power > 0) {
            burn();
            getWorld().addLog("CALOPALENIE - pozostalo tur: " + power);
        }
        Position newPosition;
        switch (key) {
            case VK_P:
                if (power <= -COOLDOWN) {
                    power = POWER_TIME;
                    burn();
                    getWorld().addLog("Czlowiek uzyl mocy specjalnej - CALOPALENIE");
                }
                break;
            case VK_LEFT:
                newPosition = new Position(getPosition().getX() - 1, getPosition().getY());
                action(newPosition);
                break;
            case VK_RIGHT:
                newPosition = new Position(getPosition().getX() + 1, getPosition().getY());
                action(newPosition);
                break;
            case VK_UP:
                newPosition = new Position(getPosition().getX(), getPosition().getY() - 1);
                action(newPosition);
                break;
            case VK_DOWN:
                newPosition = new Position(getPosition().getX(), getPosition().getY() + 1);
                action(newPosition);
                break;

        }
        if (power > 0) {
            burn();
        }
    }

    public void burn() {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                Position tmp = new Position(getPosition().getX() + i, getPosition().getY() + j);
                if (world.inMap(tmp) && !tmp.equal(getPosition()) && world.getOrganism(tmp) != null) {
                    Organism toDie = world.getOrganism(tmp);
                    killLog(toDie);
                    toDie.deleteFromContainer();
                }
            }
        }
    }

}
