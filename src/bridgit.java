import java.util.ArrayList;

class Cell {
  String color;
  Cell up;
  Cell down;
  Cell left;
  Cell right;
  
  Cell(String color) {
    this.color = color;
    this.up = null;
    this.down = null;
    this.left = null;
    this.right = null;
  }
}

class BridgItGame {
  ArrayList<ArrayList<Cell>> board;
  int n;
  String currentPlayer;
  
  BridgItGame(int n) {
    if (n % 2 == 0 || n < 3) {
      throw new IllegalArgumentException("n must be odd and greater than 3");
    }
    
    this.n = n;
    this.board = new ArrayList<>();
    this.currentPlayer = "pink";
  }
}