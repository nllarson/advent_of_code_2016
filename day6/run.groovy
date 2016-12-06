def signal = ['eedadn','drvtee','eandsr','raavrd','atevrs','tsrnev','sdttsa','rasrtv','nssdts','ntnada','svetve','tesnvt','vntsnd','vrdear','dvrsen','enarar']
def testCode = new Broadcast(signal: signal)

assert testCode.message() == 'easter'
assert testCode.modifiedMessage() == 'advent'


def day6 = new Broadcast(signal: new File('input.txt').readLines())
assert day6.message() == 'gebzfnbt'
assert day6.modifiedMessage() == 'fykjtwyn'
