class LargeKeypad {
  def keys = [null,null,1,null,null,null,2,3,4,null,5,6,7,8,9,null,'A','B','C',null,null,null,'D',null,null]
  def position = 10
  def code = ''

  def move(String direction) {
    switch (direction) {
      case 'U':
        if (position - 5 >= 0) {
          if (keys[(position - 5)] != null) {
            position = position - 5
          }
        }
        break;
      case 'D':
        if (position + 5 <= 24) {
          if (keys[position + 5] != null) {
            position = position + 5
          }
        }
        break;
      case 'L':
        if (position % 5 != 0) {
          if (keys[position - 1] != null) {
            position = position - 1
          }
        }
        break;
      case 'R':
        if (position % 5 != 4) {
          if (keys[position + 1] != null) {
            position = position + 1
          }
        }
        break;
    }
  }

  void push() {
    code = "${code}${keys[position]}"
  }
}
