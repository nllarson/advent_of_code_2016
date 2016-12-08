class IPv7 {
  String address

  private static final String ABBA_MATCHER = /(.)(.)\2\1/
  private static final String HYPERNET_MATCHER = /\[(.+?)\]/
  private static final String HYPER_MATCHER = /\[.*(.)(.)\2\1.*\]/
  private static final String AAAA_MATCHER = /(.)\1\1\1/
  private static final String ABA_BAB_MATCHER = /(^|\])[a-z ]*(.)(.)\2.*\[[a-z ]*\3\2\3|\[[a-z ]*(.)(.)\4.*\][a-z ]*\5\4\5/


  Boolean supportsTLS() {
    def supports = true

    address.findAll(HYPERNET_MATCHER).each {
      if (hasABBA(it)) {
          supports = false
      }
      // stripped = stripped.replace(it, '|')
    }

    if (supports) {
      supports = hasABBA(address)
    }

    return supports
  }

  Boolean supportsSSL() {
    return address.find(ABA_BAB_MATCHER) != null
  }

  Boolean hasABBA(abbaMaybe) {
    return abbaMaybe.findAll(ABBA_MATCHER) - abbaMaybe.findAll(AAAA_MATCHER)
  }

}
