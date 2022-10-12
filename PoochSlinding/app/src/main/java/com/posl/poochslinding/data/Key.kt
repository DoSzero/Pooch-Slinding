package com.posl.poochslinding.data

enum class Key {
    // // The keys used in handling bundles and (SP) shared preferences.
    KEY_TILE_POSITION, // relate position during shuffling
    KEY_PROGRESS,      // related to the progress of the shuffling.
    KEY_FEWEST_MOVES,  // SP related to the fewest number of moves taken by the user to solve the puzzle.
    KEY_FASTEST_TIME,  // SP related to the fastest time taken by user to solve a puzzle.
    KEY_PUZZLE_IMAGE   // SP related to the most recent puzzle image selected by the user.
}