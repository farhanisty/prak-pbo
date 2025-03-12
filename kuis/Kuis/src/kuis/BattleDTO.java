/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kuis;

/**
 *
 * @author farhannivta
 */
public class BattleDTO {
  public PlayerOption firstPlayer;
  public PlayerOption secondPlayer;

  public BattleDTO(PlayerOption first, PlayerOption second) {
    this.firstPlayer = first;
    this.secondPlayer = second;
  }
}
