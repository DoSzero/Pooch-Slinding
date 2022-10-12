package com.posl.poochslinding

import android.view.MotionEvent
import com.posl.poochslinding.data.FlingDirection
import kotlin.math.PI
import kotlin.math.atan2

class FlingDetector {

    /*  Boundary angles in radians for distinguishing the direction of a fling gesture.
        *  FlingDirection.DOWN if the angle is in [0.25π, 0.75π).
        *  FlingDirection.UP if the angle is in [1.25π, 1.75π).
        *  FlingDirection.RIGHT if the angle is in [0.75π, 1.25π).
        *  FlingDirection.LEFT if the angle is in [0, 0.25π) or [1.75π, 2π) */

    companion object {

        private val BOUNDARY_ANGLES = doubleArrayOf(
                0.0,
                0.25 * PI,
                0.75 * PI,
                1.25 * PI,
                1.75 * PI,
                2 * PI
        )

        fun getDirection( e1: MotionEvent, e2: MotionEvent): FlingDirection {
            val angle: Double = getAngle(e1.x, e1.y, e2.x, e2.y)

            if (isUp(angle)) {
                return FlingDirection.UP
            }
            if (isDown(angle)) {
                return FlingDirection.DOWN
            }
            if (isLeft(angle)) {
                return FlingDirection.LEFT
            }
            if (isRight(angle)) {
                return FlingDirection.RIGHT
            }
            return FlingDirection.INVALID
        }

        private fun getAngle(x1: Float, y1: Float, x2: Float, y2: Float): Double {
            return atan2((y1 - y2).toDouble(), (x2 - x1).toDouble()) + PI
        }

        // Checks angle between the points defined by the coordinates of the pertinent
        private fun isUp(angle: Double): Boolean {
            return BOUNDARY_ANGLES[3] <= angle && angle <= BOUNDARY_ANGLES[4]
        }

        private fun isDown(angle: Double): Boolean {
            return BOUNDARY_ANGLES[1] <= angle && angle <= BOUNDARY_ANGLES[2]
        }

        private fun isLeft(angle: Double): Boolean {
            return BOUNDARY_ANGLES[0] <= angle && angle <= BOUNDARY_ANGLES[1]
                    || BOUNDARY_ANGLES[4] <= angle && angle <= BOUNDARY_ANGLES[5]
        }

        private fun isRight(angle: Double): Boolean {
            return BOUNDARY_ANGLES[2] <= angle && angle <= BOUNDARY_ANGLES[3]
        }
    }
}