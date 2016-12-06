import java.security.MessageDigest

class PasswordDecoder {
  String doorId

  String password1() {
    String password = ''
    Integer index = 0

    while(password.length() < 8){
      def hash = MessageDigest.getInstance("MD5").digest("${doorId}${index}".bytes).encodeHex().toString()

      if (hash =~ /^00000.*/) {
        // println "INDEX: ${index} - FOUND: ${hash[5]}"
        password += hash[5]
      }

      index++
    }

    return password
  }

  String password2() {
    def password = ['','','','','','','','']
    Integer index = 0

    while(password.join().size() < 8){
      def hash = MessageDigest.getInstance("MD5").digest("${doorId}${index}".bytes).encodeHex().toString()

      if (hash =~ /^00000.*/ && '01234567'.contains(hash[5])) {
        if (password[(hash[5] as int)] == ''){
          password[hash[5] as int] = hash[6]
        }

        // println "INDEX: ${index} - PASSWORD: ${password}"
        print '*'
      }

      index++
    }

    return password.join()
  }
}
