package functional

Closure add = { x, y -> x + y }
println add.call(3, 4)
println add(3, 4)
println add('abc', 'def')
println add(new Date(), 3)

def mult = { x, y = 2 ->
    println "x=$x, y=$y"
    x * y
}
println mult(3, 5)
println mult(3)

def multByThree = mult.curry(3)
println multByThree(2)
println multByThree()

def greet = { sal, sep, msg ->
    "$sal$sep $msg!"
}

assert "Hello, World!" == greet("Hello", ",", "World")

def hello = greet.curry('Hello')
assert "Hello, World!" == hello(',','World')

def world = greet.rcurry('World')
assert "Hello, World!" == world('Hello',',')

def withComma = greet.ncurry(1, ',')
assert "Hello, World!" == withComma("Hello", "World")