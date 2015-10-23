package functional

List<String> strings = 'this is a list of strings'.split()
println strings

// Java natural sort (Java 7 and below)
Collections.sort(strings)
println strings
checkSort(strings)

// Java 8 natural sort
println strings.stream()
        .sorted()
        .collect()
checkSort(strings)

// Java 7 length sort
Collections.sort(strings, new Comparator<String>() {
    int compare(String s1, String s2) {
        return s1.size() - s2.size()
    }
})
checkSort(strings*.size())

println strings

// Groovy replaces anonymous inner classes with closures
// Reverse sort to show we actually did something
Collections.sort(strings) { String s1, String s2 -> s2.size() - s1.size() }
checkSort(strings*.size().reverse())

println strings

// Groovy natural sort
def sorted = strings.sort(false)
println sorted
checkSort(sorted)

// Groovy length sort with 2 params
sorted = strings.sort(false) { s1, s2 -> s2.size() <=> s1.size() }
println sorted
checkSort(sorted*.size().reverse())

// Groovy length sort with 1 param
sorted = strings.sort(false) { it.size() }
println sorted
checkSort(sorted*.size())

// Groovy sort by length, then equal lengths alphabetical
sorted = strings.sort(false) { s1, s2 ->
    s1.size() <=> s2.size() ?: s2 <=> s1
}
println sorted

// testing method
void checkSort(list) {
    list.inject { prev, curr ->
        assert prev <= curr
        curr
    }
    true
}