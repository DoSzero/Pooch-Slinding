package com.posl.poochslinding.interfaces

import com.posl.poochslinding.data.FlingDirection

interface OnFlingListener {
    fun onFling (
        direction: FlingDirection,
        position: Int
    )
}