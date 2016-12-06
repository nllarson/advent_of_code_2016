class Broadcast {
  def signal

  String message() {
    String message = ''
    signal.max{it.length()}.length().times { index ->
      // println "Character: ${index}"

      def characterCounts = [:]

      signal.each{ word ->
        if (characterCounts[word[index]]) {
          characterCounts[word[index]]++
        } else {
          characterCounts[word[index]] = 1
        }
      }

      // println "Character Counts: ${characterCounts.sort{a,b -> (a.value <=> b.value) * -1}}"
      message += characterCounts.sort{a,b -> (a.value <=> b.value) * -1}*.key[0]
    }

    return message
  }

  String modifiedMessage() {
    String message = ''
    signal.max{it.length()}.length().times { index ->
      // println "Character: ${index}"

      def characterCounts = [:]

      signal.each{ word ->
        if (characterCounts[word[index]]) {
          characterCounts[word[index]]++
        } else {
          characterCounts[word[index]] = 1
        }
      }

      // println "Character Counts: ${characterCounts.sort{a,b -> (a.value <=> b.value)}}"
      message += characterCounts.sort{a,b -> (a.value <=> b.value)}*.key[0]
    }

    return message
  }

}
