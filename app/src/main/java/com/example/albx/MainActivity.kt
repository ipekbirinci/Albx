package com.example.albx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import data.model.StockResponse
import data.repo.StockRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
