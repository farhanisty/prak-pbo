/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author farhannivta
 */
public class MainFrame extends JFrame {
    private JButton motorBtn, mobilBtn;
    public MainFrame() {
        this.setTitle("Halaman Baru");

        this.setSize(400,600);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        
        this.setLayout(new FlowLayout());
        
        this.motorBtn = new JButton("Motor");
        this.mobilBtn = new JButton("Mobil");
        
        this.add(this.motorBtn);
        this.add(this.mobilBtn);
        
        this.motorBtn.addActionListener(e -> new DetailFrame());
    }
}
