package com.example.practice7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = ViewModelProvider(this)
        viewModel = provider.get(MainActivityViewModel::class.java)

        observeViewModel()

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            viewModel.checkB.value = if(isChecked) true else false }
        toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            viewModel.togleB.value = if(isChecked) true else false }

        button.setOnClickListener{
        viewModel.textV.value = editText.text.toString() + "\n" + viewModel.onButClicked()
        }
}

    fun observeViewModel() {
//        viewModel.editT.observe(this, Observer { editText.setText(it) })
        viewModel.checkB.observe(this, Observer { checkBox.setChecked(it) })
        viewModel.togleB.observe(this, Observer { toggleButton.setChecked(it) })
        viewModel.r1.observe(this, Observer { radioButton.setChecked(it) })
        viewModel.r2.observe(this, Observer { radioButton2.setChecked(it) })
        viewModel.textV.observe(this, Observer { textView.setText(it) })
    }

    fun radioClick(view: View) {
        when (view.getId()) {
            R.id.radioButton ->{
                viewModel.r1.value = true
                viewModel.r2.value = false
            }
            R.id.radioButton2 -> {
                viewModel.r2.value = true
                viewModel.r1.value = false
            }
        }
    }
}

