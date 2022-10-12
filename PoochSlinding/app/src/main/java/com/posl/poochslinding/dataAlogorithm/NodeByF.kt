package com.posl.poochslinding.dataAlogorithm

class NodeByF: Comparator<Node> {

    // Creates a comparator for nodes based on their f-values (the A* algorithm).
    override fun compare(o1: Node?, o2: Node?): Int {
        if (o1?.getF()!! < o2?.getF()!!) {
            return -1
        } else if (o1.getF() > o2.getF()) {
            return 1
        }
        // Returns 0 if the arguments are equal (==),
        // a (-) negative number if the 1-st arg is less than the 2-nd,
        // a (+) positive number if the 1-st arg is greater than 2-nd.
        return 0
    }
}