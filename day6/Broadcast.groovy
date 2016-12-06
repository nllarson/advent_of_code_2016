class Broadcast {
  def signal

  Map countCharacters(index) {
    def characterCounts = [:]

    signal.each{ word ->
      if (characterCounts[word[index]]) {
        characterCounts[word[index]]++
      } else {
        characterCounts[word[index]] = 1
      }
    }

    return characterCounts
  }

  String message() {
    String message = ''
    signal.max{it.length()}.length().times { index ->
      message += countCharacters(index).sort{a,b -> (a.value <=> b.value) * -1}*.key[0]
    }

    return message
  }

  String modifiedMessage() {
    String message = ''
    signal.max{it.length()}.length().times { index ->
      message += countCharacters(index).sort{a,b -> (a.value <=> b.value)}*.key[0]
    }

    return message
  }
}
