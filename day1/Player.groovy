class Player {
  int x = 0
  int y = 0
  String directionFacing = 'N'
  def breadcrumbs = []
  def HQ = []

  def turn(String direction) {
    // println "Turning ${direction}"
    switch (directionFacing) {
      case 'N':
        directionFacing = direction == 'R' ? 'E' : 'W'
        break
      case 'E':
        directionFacing = direction == 'R' ? 'S' : 'N'
        break
      case 'S':
        directionFacing = direction == 'R' ? 'W' : 'E'
        break
      case 'W':
        directionFacing = direction == 'R' ? 'N' : 'S'
        break;
      default:
        break
    }

    // println "Now facing ${directionFacing}"
  }

  def walk(int distance) {
    // println "Walking ${directionFacing} - ${distance} blocks"
    switch (directionFacing) {
      case 'N':
        distance.times {walkNorth()}
        break
      case 'E':
        distance.times {walkEast()}
        break
      case 'S':
        distance.times {walkSouth()}
        break
      case 'W':
        distance.times {walkWest()}
        break;
      default:
        break
    }
    // println "Player's current location: [${x},${y}]."
  }

  def recordLocation() {
    if (breadcrumbs.contains("$x:$y")) {
        HQ << "$x:$y"
    }

    breadcrumbs << "$x:$y"
  }

  def walkNorth() {
      y++
      recordLocation()
  }

  def walkEast() {
      x++
      recordLocation()
  }

  def walkSouth() {
      y--
      recordLocation()
  }

  def walkWest() {
      x--
      recordLocation()
  }

  def move(String instruction) {
    turn(instruction[0])
    walk(instruction[1..-1] as int)
  }

  int distanceFromStart() {
    // println "Player's current location: [${x},${y}]."
    return Math.abs(x) + Math.abs(y)
  }

  int distanceToHQ() {
    def actualHQ = HQ[0]
    return Math.abs(actualHQ.split(':')[0] as int) + Math.abs(actualHQ.split(':')[1] as int)
  }
}
