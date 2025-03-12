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
public class ResultFrame extends JFrame {
  private JLabel title = new JLabel("Hasil Pertandingan");
  private JLabel subtitle = new JLabel("");
  private BattleDTO dto;

  public ResultFrame(BattleDTO dto) {
    this.setTitle("Login");
    this.dto = dto;

    this.setSize(450,300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    
    this.setLayout(new GridLayout(0,1));

    JPanel titlePanel = new JPanel(new FlowLayout());
    titlePanel.add(this.title);

    JPanel subtitlePanel = new JPanel(new FlowLayout());
    subtitlePanel.add(this.subtitle);

    this.add(titlePanel);
    this.add(subtitlePanel);

    if(dto.firstPlayer.pilihan == dto.secondPlayer.pilihan) {
      this.subtitle.setText("Sayangnya kedua player sama-sama imbang/kalah");
    } else {
      PlayerOption winner = this.getWinner();

      this.subtitle.setText("Selamat, Player " + winner.nama + " telah memenangkan");

      JLabel namaLabel = new JLabel("Nama : " + winner.nama);
      JPanel namaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      namaPanel.add(namaLabel);

      JLabel nimLabel = new JLabel("NIM : " + winner.nim);
      JPanel nimPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      nimPanel.add(nimLabel);

      JLabel jurusanLabel = new JLabel("jurusan : " + winner.jurusan);
      JPanel jurusanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      jurusanPanel.add(jurusanLabel);

      JLabel pilihanLabel = new JLabel("");

      if(winner.pilihan == 1) {
        pilihanLabel.setText("pilihan : kertas");
      } else if(winner.pilihan == 2) {
        pilihanLabel.setText("pilihan : batu");
      } else {
        pilihanLabel.setText("pilihan : gunting");
      }

      JPanel pilihanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      pilihanPanel.add(pilihanLabel);

      this.add(namaPanel);
      this.add(nimLabel);
      this.add(jurusanLabel);
      this.add(pilihanLabel);
    }
  }

  private PlayerOption getWinner() {
    int firstOption = this.dto.firstPlayer.pilihan;
    int secondOption = this.dto.secondPlayer.pilihan;

    if(firstOption == 1) {
      if(secondOption == 2) {
        return this.dto.firstPlayer;
      } else {
        return this.dto.secondPlayer;
      }
    } else if(firstOption == 2) {
      if(secondOption == 1) {
        return this.dto.secondPlayer;
      } else {
        return this.dto.firstPlayer;
      }
    } else {
      if(secondOption == 1) {
        return this.dto.firstPlayer;
      } else {
        return this.dto.secondPlayer;
      }
    }
  }
}
