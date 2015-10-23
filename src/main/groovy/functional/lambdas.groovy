package functional

import java.util.stream.Stream

[3, 1, 4, 1, 5, 9].stream()
        .map { it * 2 }
        .filter { it % 3 == 0 }
        .forEach(System.out.&println)

[3, 1, 4, 1, 5, 9].stream()
        .map { it * 2 }
        .filter { it % 3 == 0 }
        .forEach { println it }

def random = Math.&random
def printer = System.out.&println
def doubler = { it * 2 }
def divisibleBy3 = { it % 3 == 0 }

[3, 1, 4, 1, 5, 9].stream()
        .map(doubler)
        .filter(divisibleBy3)
        .forEach(printer)

println Stream.generate(Math.&random)
        .limit(1000)
        .mapToInt { (int) (it * 100) }
        .filter { it % 3 == 0 }
        .summaryStatistics()