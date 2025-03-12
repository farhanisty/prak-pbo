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
public class DetailFrame extends JFrame {
    private JLabel lnama = new JLabel("Nama Penyewa");
    private JTextField fnama = new JTextField(20);
    private JLabel lTelepon = new JLabel("Nomor Telepon");
    private JTextField fTelepon = new JTextField(15);
    private JRadioButton option1, option2, option3;
    
    public DetailFrame() {
        this.setTitle("Frame Detail");
        
        this.setSize(400, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        ButtonGroup btnGroup = new ButtonGroup();
        
        this.option1 = new JRadioButton("Yamaha");
        btnGroup.add(this.option1);
        
        
        this.setVisible(true);
        
        this.setLayout(new GridLayout(2,2));
        
        this.add(this.lnama);
        this.add(this.fnama);
        this.add(this.lTelepon);
        this.add(this.fTelepon);
        
        this.add(option1);
    }
}
