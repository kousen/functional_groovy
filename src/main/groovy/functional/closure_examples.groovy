package functional

10.downto(7, { println it }) // Speaking Groovy with a Java accent
10.downto(7) { println it }  // Typical Groovy idiom
10.downto 7, { println it }

(0..10).each { println Integer.toBinaryString(it).padLeft(4, '0') }
// [0..10].each { println Integer.toBinaryString(it).padLeft(4, '0') }

def nums = [3, 1, 4, 1, 5, 9]
(0..5).each { println it }
nums.eachWithIndex { val, idx ->
    println "index $idx maps to $val"
}

println nums.any { it % 3 == 0 }
println nums.every { it % 3 == 0 }
println nums.find { it % 2 == 0 }
println nums.findAll { it % 3 == 0 }

def map = [a:1, b:2, c:2]
map.each { e -> println "${e.key} maps to ${e.value}" }
map.each { k,v -> println "$k maps to $v" }

