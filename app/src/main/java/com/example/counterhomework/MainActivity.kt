package com.example.counterhomework

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var mCount = 0
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setViewsValues(savedInstanceState)
        setViewsClickListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(M_COUNT_VALUE, mCount)
    }

    private fun initViews() {
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
    }

    private fun setViewsValues(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            mCount = it.getInt(M_COUNT_VALUE)
            showCount()
        }
    }

    private fun setViewsClickListeners() {
        button.setOnClickListener {
            mCount++
            showCount()
        }
    }

    private fun showCount() {
        textView.text = mCount.toString()
    }

    companion object {
        private const val M_COUNT_VALUE = "mCountValue"
    }
}