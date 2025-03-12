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
public class FirstPlayerFrame extends JFrame implements ActionListener {
  private JLabel title = new JLabel("Input data player 1");
  private JLabel namaLabel = new JLabel("Nama");
  private JLabel nimLabel = new JLabel("Nim");
  private JLabel jurusanLabel = new JLabel("Jurusan");
  private JLabel pilihanLabel = new JLabel("Pilihan");

  private JTextField namaInput = new JTextField(20);
  private JTextField nimInput = new JTextField(20);
  private JTextField jurusanInput = new JTextField(20);

  private JRadioButton gunting = new JRadioButton("gunting");
  private JRadioButton batu = new JRadioButton("batu");
  private JRadioButton kertas = new JRadioButton("kertas");

  private JButton nextButton = new JButton("next");

    public FirstPlayerFrame() {
      this.setTitle("Player 1");
      this.setVisible(true);
      this.setSize(300, 400);
      this.setLocationRelativeTo(null);

      this.setLayout(new GridLayout(0,1));

      JPanel titlePanel = new JPanel(new FlowLayout());
      titlePanel.add(this.title);

      JPanel namaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      namaPanel.add(this.namaLabel);
      namaPanel.add(this.namaInput);

      JPanel nimPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      nimPanel.add(this.nimLabel);
      nimPanel.add(this.nimInput);


      JPanel jurusanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      jurusanPanel.add(this.jurusanLabel);
      jurusanPanel.add(this.jurusanInput);

      ButtonGroup group = new ButtonGroup();
      group.add(gunting); group.add(batu);
      group.add(kertas);

      JPanel pilihanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      pilihanPanel.add(this.pilihanLabel);
      pilihanPanel.add(this.gunting);
      pilihanPanel.add(this.batu);
      pilihanPanel.add(this.kertas);

      JPanel nextPanel = new JPanel(new FlowLayout());
      nextPanel.add(this.nextButton);

      this.nextButton.addActionListener(this);

      this.add(titlePanel);
      this.add(namaPanel);
      this.add(nimPanel);
      this.add(jurusanPanel);
      this.add(pilihanPanel);
      this.add(nextPanel);

    }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == this.nextButton) {

      int pilihan = 1;

      if(this.batu.isSelected()) {
        pilihan = 2;
      } else {
        pilihan = 3;
      }

      PlayerOption firstPlayer = new PlayerOption(this.namaInput.getText().trim(), this.nimInput.getText().trim(), this.jurusanInput.getText().trim(), pilihan);
      PlayerOption secondPlayer = new PlayerOption(this.namaInput.getText().trim(), this.nimInput.getText().trim(), this.jurusanInput.getText().trim(), 1);

      new SecondPlayerFrame(new BattleDTO(firstPlayer, secondPlayer));
    }
  }
}
