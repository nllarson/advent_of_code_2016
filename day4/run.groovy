assert new RoomDecoder(encryptedData: 'aaaaa-bbb-z-y-x-123[abxyz]').isValid()
assert new RoomDecoder(encryptedData: 'a-b-c-d-e-f-g-h-987[abcde]').isValid()
assert new RoomDecoder(encryptedData: 'not-a-real-room-404[oarel]').isValid()
assert !(new RoomDecoder(encryptedData: 'totally-real-room-200[decoy]').isValid())

def validRooms = 0
def invalidRooms = 0
def sectorSum = 0


new File('input.txt').eachLine {data ->
  def decoded = new RoomDecoder(encryptedData: data)

  if (decoded.isValid()) {
    sectorSum += decoded.getSector() as int
    validRooms++
  } else {
    invalidRooms++
  }
}

println "Sector Sum: ${sectorSum} -- Valid: ${validRooms} -- Invalid: ${invalidRooms}"

assert new RoomDecoder(encryptedData: 'qzmt-zixmtkozy-ivhz-343[oarel]').decode() == 'very encrypted name'

def npSector = ''

new File('input.txt').eachLine {data ->
  def decoded = new RoomDecoder(encryptedData: data)

  if (decoded.isValid() && decoded.decode() =~ /.*north.*/) {
    println "Room Name: ${decoded.decode()} -- Sector: ${decoded.getSector()}"
    // npSector = decoded.getSector()
  }
}
