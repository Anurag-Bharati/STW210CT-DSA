package main.java.gui;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // extra dependency // add the dependency from lib if line 13 throws an error :).
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setResizable(false);
        gui.setLocation(225, 30);
        gui.setSize(1100, 750);
        gui.setTitle("Optimal Route Finder");
        gui.setVisible(true);
    }
}
