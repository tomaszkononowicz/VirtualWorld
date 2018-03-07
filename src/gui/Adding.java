/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import organism.Organism;
import world.World;

/**
 *
 * @author Tomasz
 */
public class Adding extends JPanel {

    private JLabel field = new JLabel("Pole");
    private JLabel organism = new JLabel();
    private JLabel strength = new JLabel();
    private JLabel initiative = new JLabel();
    private JLabel age = new JLabel();
    private JLabel add = new JLabel();
    private JComboBox organisms = new JComboBox();
    private JButton addbutton = new JButton("Dodaj organizm");
    private JLabel power = new JLabel("Moc specjalna");
    private World world;
    private Window window;
    private JButton newGame = new JButton("Nowa gra");
    private JButton saveGame = new JButton("Zapisz gre");
    private JButton loadGame = new JButton("Wczytaj gre");
    private ButtonsListener buttonsListener;
    public Adding(World world, Window window) {
        this.world = world;
        this.window = window;
        buttonsListener = new ButtonsListener(world, window);
        setBackground(Color.GREEN);
        setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        setPreferredSize(new Dimension(100,100));
        fillComboBox(organisms);
        field.setFocusable(false);
        add(field);
        organism.setFocusable(false);
        add(organism);
        strength.setFocusable(false);
        add(strength);
        initiative.setFocusable(false);
        add(initiative);
        age.setFocusable(false);
        add(age);
        add.setFocusable(false);
        add(add);
        organisms.setFocusable(false);
        add(organisms);
        addbutton.setFocusable(false);
        addbutton.addActionListener(buttonsListener);
        add(addbutton);
        newGame.setFocusable(false);
        newGame.addActionListener(buttonsListener);
        add(newGame);
        saveGame.setFocusable(false);
        saveGame.addActionListener(buttonsListener);
        add(saveGame);
        loadGame.setFocusable(false);
        loadGame.addActionListener(buttonsListener);
        add(loadGame);
        
        
        
        
        if (window.board.getSelected() != null) {
            if (world.getOrganism(window.board.getSelected().getPosiion()) == null) {
                setVisibility(true);
            } else {
                setVisibility(false);
            }
        } else {
            field.setVisible(false);
            organism.setVisible(false);
            strength.setVisible(false);
            initiative.setVisible(false);
            age.setVisible(false);
            add.setVisible(false);
            organisms.setVisible(false);
            addbutton.setVisible(false);
        }

    }

    public void setVisibility(boolean adding) {
        field.setText("Wybrana pozycja: " + window.board.getSelected().getPosiion().toString());
        if (adding) {
            field.setVisible(true);
            organism.setVisible(false);
            strength.setVisible(false);
            initiative.setVisible(false);
            age.setVisible(false);
            add.setVisible(true);
            organisms.setVisible(true);
            addbutton.setVisible(true);
        } else {
            Organism o = world.getOrganism(window.board.getSelected().getPosiion());
            field.setVisible(true);
            organism.setText(o.getName());
            organism.setVisible(true);
            strength.setText("Sila: " + o.getStrength());
            strength.setVisible(true);
            initiative.setText("Inicjatywa: " + o.getInitiative());
            initiative.setVisible(true);
            age.setText("Wiek: " + (world.getTurns()-o.getBirthTurn()));
            age.setVisible(true);
            add.setVisible(false);
            organisms.setVisible(false);
            addbutton.setVisible(false);
        }

    }
    
    public void fillComboBox(JComboBox comboBox) {
        comboBox.addItem("Antylopa");
        comboBox.addItem("Wilk");
        comboBox.addItem("Owca");
        comboBox.addItem("Zolw");
        comboBox.addItem("Lis");
    }
    
    public String getFromComboBox() {
        return organisms.getSelectedItem().toString();
    }
    
    public void worldUpdate(World world) {
        buttonsListener.worldUpdate(world);
    }
}
