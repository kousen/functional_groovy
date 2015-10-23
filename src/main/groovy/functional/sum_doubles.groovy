package functional

List nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]

// Java approach (with side effect)
int total = 0
for (int n : nums) {
    total += n
}
assert total == 36

// 1. Java approach for doubles
total = 0
for (int n : nums) {
    total += 2 * n
}
assert total == 72

// Groovy approach for regular sum
assert 36 == nums.sum()

// 2. Groovy sum of doubles using collect
assert 72 == nums.collect { it * 2 }.sum()

// 3. Reduce to a problem already solved
assert 72 == nums.sum() * 2

// 4. Equivalent to collect
assert 72 == nums.sum { it * 2 }

// 5. Use spread-dot
assert 72 == nums*.multiply(2).sum()

// 6. Multiply the collection itself
assert 72 == (nums * 2).sum()

// 7. Use inject
assert 72 == nums.inject(0) { acc, val ->
    println "acc=$acc, val=$val"
    acc + 2 * val
}
