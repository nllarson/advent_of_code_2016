class RoomDecoder {
  private static final String ROOM_MATCH = /([a-z]*-)*/
  private static final String SECTOR_MATCH = /[0-9]+/
  private static final String CHECKSUM_MATCH = /\[[a-z]+\]/

  String encryptedData

  String getRoom() {
    return this.encryptedData.find(ROOM_MATCH)
  }

  String getSector() {
    return this.encryptedData.find(SECTOR_MATCH)
  }

  String getCheckSum() {
    return this.encryptedData.find(CHECKSUM_MATCH).replace('[','').replaceAll(']','')
  }

  Boolean isValid() {
    def characterCounts = [:]
    this.getRoom().replaceAll('-','').each{ character ->
      if (characterCounts[character]) {
        characterCounts[character]++
      } else {
        characterCounts[character] = 1
      }
    }

    def roomCheck = characterCounts.sort{a,b ->
      a.value <=> b.value == 0 ? a.key <=> b.key : (a.value <=> b.value) * -1
    }
    return roomCheck*.key[0..4].join() == this.getCheckSum()
  }

  String decode() {
    def alphabet = 'abcdefghijklmnopqrstuvwxyz'
    def shift = this.getSector() as int
    String roomName = ''
    this.getRoom().each{ character ->
      if (character == '-') {
        roomName += ' '
      } else {
        roomName += alphabet[Math.abs((alphabet.indexOf(character) + shift) % 26)]
      }
    }

    return roomName.trim()
  }

}
