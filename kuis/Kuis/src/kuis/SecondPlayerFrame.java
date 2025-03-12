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
public class SecondPlayerFrame extends JFrame implements ActionListener {
  private BattleDTO dto;
  private JLabel title = new JLabel("Input data player 2");
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

  private JButton battleButton = new JButton("battle");

    public SecondPlayerFrame(BattleDTO dto) {
      this.dto = dto;

      this.setTitle("player 2");
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
      group.add(gunting);
      group.add(batu);
      group.add(kertas);

      JPanel pilihanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      pilihanPanel.add(this.pilihanLabel);
      pilihanPanel.add(this.gunting);
      pilihanPanel.add(this.batu);
      pilihanPanel.add(this.kertas);

      JPanel battlePanel = new JPanel(new FlowLayout());
      battlePanel.add(this.battleButton);

      this.battleButton.addActionListener(this);

      this.add(titlePanel);
      this.add(namaPanel);
      this.add(nimPanel);
      this.add(jurusanPanel);
      this.add(pilihanPanel);
      this.add(battlePanel);

    }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == this.battleButton) {
      this.dto.secondPlayer.nama = this.namaInput.getText().trim();
      this.dto.secondPlayer.nim = this.nimInput.getText().trim();
      this.dto.secondPlayer.jurusan = this.jurusanInput.getText().trim();
      this.dto.secondPlayer.pilihan = 2;

      if(this.batu.isSelected()) {
        this.dto.secondPlayer.pilihan = 2;
      } else {
        this.dto.secondPlayer.pilihan = 3;
      }

      new ResultFrame(this.dto);
    }
  }
}
