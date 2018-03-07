/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Tomasz
 */
public class Logs extends JScrollPane{
    JTextArea content;
    public Logs(JTextArea content) {
        super(content, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.content = content;
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(300,50));
        setFocusable(false);
        content.setEditable(false);
        content.setFocusable(false);
    }
    
    public void addLogs(List<String> logs) {
        for (String s : logs) {
            content.append(s + "\n");
        }
    }
    
    public void addLog(String log) {
        content.append(log + "\n");
    }
    
    public void clear() {
        content.setText(null);
    }
}
