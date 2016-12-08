// TLS TESTS
assert new IPv7(address: 'abba[mnop]qrst').supportsTLS()
assert new IPv7(address: 'abcd[bddb]xyyx').supportsTLS() == false
assert new IPv7(address: 'aaaa[qwer]tyui').supportsTLS() == false
assert new IPv7(address: 'aaaa[qwer]tyuiabba').supportsTLS()
assert new IPv7(address: 'ioxxoj[asdfgh]zxcvbn').supportsTLS()
assert new IPv7(address: 'lknaffpzamlkufgt[uvdgeatxkofgoyoi]ajtqcsfdarjrddrzo[bxrcozuxifgevmog]rlyfschtnrklzufjzm').supportsTLS()
assert new IPv7(address: 'lknaffpzamlkufgt[uvdgeatxkofgoyoi]ajtqcsfdarjrddrzo[bxrcozuxifgevmog]rlyfschtnrkluzzufjzm').supportsTLS()
assert new IPv7(address: 'lknaffpzamlkufgt[uvdgeatxkofgoyoi]ajtqcsfdarjrdzo[bxrcozuxifgevmog]rlyfschtnrkluzzufjzm').supportsTLS()
assert new IPv7(address: 'abba[mnop]laksdjfalksdjf[mklkjjlk]qrst').supportsTLS()
assert new IPv7(address: 'abba[mnop]laksdjfalksdjf[mklkjjkd]qrst').supportsTLS() == false
assert new IPv7(address: 'abba[mnop]laksdjfalksdjf[mklkjjjj]qrst').supportsTLS()
assert new IPv7(address: 'fkxezddxwnlzlarhk[mswldjncrtgjijeo]ioddubxtscouxucy[qunukqpvvgzpxukwn]fsjmsbjibbbeccux[fomhpmrdrozafwvs]izzildhimulujdo').supportsTLS()
assert new IPv7(address: 'fkxezddxwnlzlarhk[mswldjncrtgjijeo]ioddubxtscouxucy[qunukqpvvgzpxukwn]fsjmsbjibbbeccux[fomhpmrdrozafwvs]izzildhimuwqqqqlujdo').supportsTLS()
assert new IPv7(address: 'fkxezddxwnlzlarhk[mswldjncrtgjijeo]ioddubxtscouxucy[qunukqpvvvvgzpxukwn]fsjmsbjibbbeccux[fomhpmrdrozafwvs]izzildhimuwqqqqlujdo').supportsTLS()
assert new IPv7(address: 'fkxezddxwnlzlarhk[mswwsldjncrtgjijeo]ioddubxtscouxucy[qunukqpvvvvgzpxukwn]fsjmsbjibbbeccux[fomhpmrdrozafwvs]izzildhimuwqqqqlujdo').supportsTLS() == false
assert new IPv7(address: 'nnmyoxtukxhrsgt[ecovrntpmkcaekonw]ncfzdxdlawbwtxqpkik[fkkkkxidubuatpihcnc]wqxmtvyakouvijt[tjvyhgempiufanh]bcibhdmbmbmmbyyi').supportsTLS()
assert new IPv7(address: 'tivudfusgnewzshs[mausfjbgxmyibin]yponuityptavbhekrlg[qeyafuevtlqemtfa]owtdxadrwwbxbrkl[obfcyxbifipwhduubu]mjocivgvrcbrllso').supportsTLS() == false

// SSL TESTS
assert new IPv7(address: 'aba[bab]xyz').supportsSSL()
assert new IPv7(address: 'xyx[xyx]xyx').supportsSSL() == false
assert new IPv7(address: 'aaa[kek]eke').supportsSSL()
assert new IPv7(address: 'zazbz[bzb]cdb').supportsSSL()
assert new IPv7(address: 'ioup[aba]ababad[ab]xyz').supportsSSL()

int tls = 0
int ssl = 0
new File('input.txt').eachLine {line ->
  def ip = new IPv7(address: line)
  if (ip.supportsTLS()) {
    tls++
  }

  if (ip.supportsSSL()) {
    ssl++
  }
}

assert tls == 110

println "Day 7 (part1): ${tls} IP Addresses support TLS"
println "Day 7 (part2): ${ssl} IP Addresses support SSL"
