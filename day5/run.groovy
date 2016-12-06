def testDoor = new PasswordDecoder(doorId: 'abc')
def puzzleDoor = new PasswordDecoder(doorId: 'ffykfhsq')

assert testDoor.password1() == '18f47a30'
assert puzzleDoor.password1() == 'c6697b55'

assert testDoor.password2() == '05ace8e3'
assert puzzleDoor.password2() == '8c35d1ab'
