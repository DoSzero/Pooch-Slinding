package com.posl.poochslinding.dataAlogorithm

import com.posl.poochslinding.data.StatePair

data class Node (
    val puzzleStatePair: StatePair,
    val parent: Node?,
    var g: Int,
    private var h: Int
) {

    // Returns a hash code for the puzzle state of this node.To ensure uniqueness
    companion object {
        fun hashState(puzzleState: ArrayList<Int>): Int {
            var hash = 0
            for (tile in puzzleState) {
                hash = hash * 10 + tile
            }
            return hash
        }
    }

    // F values = Sum of G and H values in the node (A* algorithm)
    fun getF(): Int {
        return g + h
    }

    // Indicates whether some other object is "equal to" this one
    override fun equals(other: Any?): Boolean {
        return this.puzzleStatePair.puzzleState == (other as Node).puzzleStatePair.puzzleState
    }

    //  Overridden ensures that the hash code is dependent solely on the  puzzle state of this node.
    override fun hashCode(): Int {
        return hashState(puzzleStatePair.puzzleState)
    }
}