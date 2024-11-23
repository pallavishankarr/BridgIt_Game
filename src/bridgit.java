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