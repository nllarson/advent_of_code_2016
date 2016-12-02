class Keypad {
  Integer value = 5
  String code = ''

  def move(String direction) {
    switch (direction) {
      case 'U':
        if (value - 3 >= 1) {
          value = value - 3
        }
        break;
      case 'D':
        if (value + 3 <= 9) {
          value = value + 3
        }
        break;
      case 'L':
        if (value % 3 != 1) {
          value = value - 1
        }
        break;
      case 'R':
        if (value % 3 != 0) {
          value = value + 1
        }
        break;
    }
  }

  void push() {
    code = "${code}${value}"
  }
}
