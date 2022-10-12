package com.posl.poochslinding

import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.posl.poochslinding.data.Key
import java.util.concurrent.atomic.AtomicInteger

// Runnable class related to shuffling the puzzle tiles
class ShuffleRunnable(
        private val handler: Handler,
        private val tilePosition: Int,
        private val numTiles: Int
) : Runnable {

    companion object {
        private val progress = AtomicInteger(0)
    }

    // Executing thread.
    override fun run() {
        val message = Message.obtain()
        val bundle = Bundle()
        bundle.putInt(Key.KEY_TILE_POSITION.name, tilePosition)
        bundle.putInt(Key.KEY_PROGRESS.name, progress.incrementAndGet())

        /* Subtract 1 to take blank tile into account. */
        progress.compareAndSet(numTiles - 1, 0)

        message.data = bundle
        handler.sendMessage(message)
    }
}