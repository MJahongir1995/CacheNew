package com.example.cashenew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.`cache-new`.databinding.ActivityMainBinding
import com.example.cashenew.utils.MySharedPreference

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var count1 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)
        count1 = MySharedPreference.count
        binding.txt.text = count1.toString()

        binding.counter.setOnClickListener {
            count1++
            MySharedPreference.count = count1
            binding.txt.text = count1.toString()
        }

        binding.reset.setOnClickListener {
            count1 = 0
            MySharedPreference.count = count1
            binding.txt.text = count1.toString()
        }
    }
}