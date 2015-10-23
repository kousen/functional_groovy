package functional

Expando e = new Expando()
e.name = 'Fido'

println e.name
e.name = 'Rover'
println e.name

e.speak = { msg = 'woof' -> "$name says $msg" }
println e.speak()
println e.speak('bow wow')
