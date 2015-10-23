package functional

def unless(boolean condition, Closure closure) {
    if (!condition) closure()
}

unless(10 < 9) {
    println "less"
}