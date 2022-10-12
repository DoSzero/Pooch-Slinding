package com.posl.poochslinding.utils

import com.posl.poochslinding.data.StatePair

class ShuffleUtil {

    // Companion object containing the methods for shuffling the puzzle tiles.
    companion object {
        fun getValidShuffledState(
            puzzleState: ArrayList<Int>,
            goalPuzzleState: ArrayList<Int>,
            blankTileMarker: Int
        ): StatePair {
            while (puzzleState == goalPuzzleState) {
                puzzleState.shuffle()
                // If puzzle is not solvable
                if (!PuzzleUtil.isSolvable(puzzleState, blankTileMarker)) {
                    PuzzleUtil.swapTiles(puzzleState, blankTileMarker)
                }
            }
            return StatePair(puzzleState, puzzleState.indexOf(blankTileMarker))
        }
    }
}