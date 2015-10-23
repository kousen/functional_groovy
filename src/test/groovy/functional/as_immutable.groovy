package functional

import groovy.transform.Immutable
import static groovy.test.GroovyAssert.*

def nums = [3, 1, 4, 1, 5, 9].asImmutable()

shouldFail(UnsupportedOperationException) {
    nums << 2
}

@Immutable
class Person {
    String first
    String last
}

Person p1 = new Person('Tom', 'Brady')
shouldFail(ReadOnlyPropertyException) {
    p1.first = 'Peyton'
}