// TEST 1 - R2, L3
def test1 = new Player()
['R2', 'L3'].each {test1.move(it)}

// // TEST 2 - R2, R2, R2
def test2 = new Player()
['R2', 'R2', 'R2'].each {test2.move(it)}

// // TEST 3 - R5, L5, R5, R3
def test3 = new Player()
['R5', 'L5', 'R5', 'R3'].each {test3.move(it)}

// TEST 4 - L193, R2, L1, R54, R1, L1, R71, L4, R3, R191, R3, R2
def test4 = new Player()
['L193', 'R2', 'L1', 'R54', 'R1', 'L1', 'R71', 'L4', 'R3', 'R191', 'R3', 'R2'].each {test4.move(it)}

assert test1.distanceFromStart() == 5
assert test2.distanceFromStart() == 2
assert test3.distanceFromStart() == 12
assert test4.distanceFromStart() == 250

def player = new Player()
def moves = new File('input.txt').text.split(",")
moves.each {
  player.move(it.trim())
}
println "Shortest Distance: ${player.distanceFromStart()}"
println "Easter Bunny HQ Location: ${player.HQ[0]}"
println "Distance To EBHQ: ${player.distanceToHQ()}"
