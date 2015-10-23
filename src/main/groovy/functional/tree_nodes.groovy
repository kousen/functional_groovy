package functional

class TreeNode {
    def name
    def children = []

    boolean isLeaf() {
        return !children
    }

    void walkTree(Closure c) {
        walkTree(0, c)
    }

    void walkTree(int currDepth, Closure c) {
        // First, execute the closure for this node. If the closure takes
        // two arguments we pass the current depth as well as the node.
        if (c.maximumNumberOfParameters == 2) {
            c(this, currDepth)
        } else {
            c(this)
        }

        // Next, call walkTree on the children
        children.each { it.walkTree(currDepth + 1, c) }
    }
}

def root = new TreeNode(name: "Fred", children: [
        new TreeNode(name: "Janet", children: [
                new TreeNode(name: "Mark"),
                new TreeNode(name: "Anne", children: [new TreeNode(name: "Simon")]),
                new TreeNode(name: "Kelly")
        ]),
        new TreeNode(name: "Nigel")
])

// Count the number of leaf nodes (i.e. those without children) in the above
// test tree.
def leafCount = 0
root.walkTree { node -> if (node.leaf) leafCount++ }

assert leafCount == 4

// Walk the tree, creating a string representation of it.
def treeString = new StringBuilder()
root.walkTree { node, indent ->
    treeString << "  " * indent << node.name << "\n"
}

println treeString
