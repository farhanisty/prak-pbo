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
    private JLabel title = new JLabel("Aplikasi Rental");
    
    public MainFrame() {
        this.setTitle("Halaman Baru");

        this.setSize(400,200);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new FlowLayout());
        
        this.motorBtn = new JButton("Motor");
        this.mobilBtn = new JButton("Mobil");
        
        this.motorBtn.setBounds(90, 50, 100, 30);
        this.mobilBtn.setBounds(210, 50, 100, 30);
        
        this.add(this.title);
        this.add(this.motorBtn);
        this.add(this.mobilBtn);
        
        this.setVisible(true);
        
        this.motorBtn.addActionListener(e -> new DetailFrame());
    }
}
