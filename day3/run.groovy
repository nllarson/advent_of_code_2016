class Triangle {
  Integer a
  Integer b
  Integer c

  boolean isValid() {
    return ((a+b>c) && (a+c>b) && (b+c>a))
  }
}

Integer part1valid = 0

new File('input.txt').eachLine {dimensions ->
  def measurements = dimensions.findAll('\\s*\\d+')

  def triangle = new Triangle(
    a: measurements[0].trim() as int,
    b: measurements[1].trim() as int,
    c: measurements[2].trim() as int)

  if (triangle.isValid()) {
    part1valid++
  }

}

println "Part 1: There are ${part1valid} valid triangles!"

Integer part2valid = 0
def a,b,c

new File('input.txt').eachWithIndex {line, index ->
  def measurements = line.findAll('\\s*\\d+')

  switch (index % 3) {
    case 0:
      a = new Triangle(a: measurements[0].trim() as int)
      b = new Triangle(a: measurements[1].trim() as int)
      c = new Triangle(a: measurements[2].trim() as int)
      break;
    case 1:
      a.b = measurements[0].trim() as int
      b.b = measurements[1].trim() as int
      c.b = measurements[2].trim() as int
      break;
    case 2:
      a.c = measurements[0].trim() as int
      b.c = measurements[1].trim() as int
      c.c = measurements[2].trim() as int

      part2valid = part2valid + (a.isValid() ? 1 : 0)
      part2valid = part2valid + (b.isValid() ? 1 : 0)
      part2valid = part2valid + (c.isValid() ? 1 : 0)

      break
  }
}

println "Part 2: There are ${part2valid} valid triangles!"
