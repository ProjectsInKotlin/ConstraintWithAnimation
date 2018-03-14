package com.example.mylynx.animationswithconstraintlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val constraintSet1 = ConstraintSet()
        constraintSet1.clone(constraintLayoutId)
        val constraintSet2 = ConstraintSet()
        constraintSet2.clone(this, R.layout.activity_main_alt)

        var changed = false
        findViewById<Button>(R.id.MA_button).setOnClickListener {

            TransitionManager.beginDelayedTransition(constraintLayoutId)
            val constraint = if (changed) constraintSet1 else constraintSet2
            constraint.applyTo(constraintLayoutId)
            changed = !changed

        }
    }
}
