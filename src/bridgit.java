import java.util.ArrayList;

import tester.Tester;

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

  void initializeBoard() {
    // white cells
    for (int i = 0; i < n; i++) {
      ArrayList<Cell> row = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        row.add(new Cell("white")); 
      }
      board.add(row);
    }

    // left and right columns as pink
    for (int i = 1; i < n; i += 2) {
      board.get(i).get(0).color = "pink";
      board.get(i).get(n - 1).color = "pink";
    }

    // first row and last row as magenta 
    for (int j = 1; j < n; j += 2) {
      board.get(0).get(j).color = "magenta";
      board.get(n - 1).get(j).color = "magenta";
    }

    // link cells in cyclic structure
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i > 0) board.get(i).get(j).up = board.get(i-1).get(j);  // Set up neighbor
        if (i < n-1) board.get(i).get(j).down = board.get(i+1).get(j);  // Set down neighbor
        if (j > 0) board.get(i).get(j).left = board.get(i).get(j-1);  // Set left neighbor
        if (j < n-1) board.get(i).get(j).right = board.get(i).get(j+1);  // Set right neighbor
      }
    }
  }
}

