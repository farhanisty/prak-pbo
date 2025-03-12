/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kuis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author farhannivta
 */
public class LoginFrame extends JFrame implements ActionListener {
  private JLabel loginLabel = new JLabel("Login");
  private JLabel usernameLabel = new JLabel("Username: ");
  private JTextField usernameInput = new JTextField(20);
  private JLabel passwordLabel = new JLabel("Password: ");
  private JTextField passwordInput = new JTextField(20);
  private JButton loginButton = new JButton("Login");
  private JLabel notifLabel = new JLabel("");

  public LoginFrame() {
    this.setTitle("Login");


    this.setSize(300,400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);

    this.setLayout(new FlowLayout());

    this.loginButton.addActionListener(this);


    this.add(this.loginLabel);
    this.add(this.loginLabel);
    this.add(this.usernameLabel);
    this.add(this.usernameInput);
    this.add(this.passwordLabel);
    this.add(this.passwordInput);
    this.add(this.loginButton);
    this.add(this.notifLabel);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == this.loginButton) {
      String username = this.usernameInput.getText().trim();
      String password = this.passwordInput.getText().trim();

      if(username != "farhan" && password != "139") {
        new FirstPlayerFrame();
        this.notifLabel.setText("Username atau Password Salah");
      } else {
        new FirstPlayerFrame();
      }
    }
  }
}
