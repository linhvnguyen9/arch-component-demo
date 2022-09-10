package com.schoolonair.wallet.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.schoolonair.wallet.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    private var scoreAInActivity = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        viewModel.scoreA.observe(this) {
//            Log.d("MainActivity", "score A observer $it")
//
//            binding.textViewMainTeamAScore.text = viewModel.scoreA.value.toString()
//        }

//        viewModel.result.observe(this) {
//            Log.d("MainActivity", "result $it")
//        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.textViewMainTeamAScore.text = viewModel.scoreA.toString()

        Log.d("MainActivity", "scoreA setOnClick $scoreAInActivity")

        binding.buttonMainTeamAIncrement.setOnClickListener {
            viewModel.incrementScoreA()
            scoreAInActivity++
            Log.d("MainActivity", "scoreA setOnClick $scoreAInActivity")
//            binding.textViewMainTeamAScore.text = viewModel.scoreA.toString()
        }

        binding.buttonMainTeamAIncrement10.setOnClickListener {
            viewModel.incrementScoreA(10)
//                        binding.textViewMainTeamAScore.text = viewModel.scoreA.toString()
        }

        binding.buttonMainFinish.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("MainActivity", "onDestroy()")
    }
}