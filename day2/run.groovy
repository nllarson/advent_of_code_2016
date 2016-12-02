// Test 1
def testKeypad = new Keypad()
['ULL','RRDDD','LURDL','UUUUD'].each {sequence ->
  sequence.each {direction ->
    testKeypad.move(direction)
  }
  testKeypad.push()
}
assert testKeypad.code == '1985'


def keypad = new Keypad()

new File('input.txt').eachLine {sequence ->
  sequence.each { direction ->
    keypad.move(direction)
  }
  keypad.push()
}
println "Day 2.A - The code is: ${keypad.code}"


def testLargeKeypad = new LargeKeypad()
['ULL','RRDDD','LURDL','UUUUD'].each {sequence ->
  sequence.each {direction ->
    testLargeKeypad.move(direction)
  }
  testLargeKeypad.push()
}
assert testLargeKeypad.code == '5DB3'

def largeKeypad = new LargeKeypad()

new File('input.txt').eachLine {sequence ->
  sequence.each { direction ->
    largeKeypad.move(direction)
  }
  largeKeypad.push()
}
println "Day 2.B - The code is: ${largeKeypad.code}"
