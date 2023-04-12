package com.example.localpresistenceonzoom.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.localpresistenceonzoom.R
import com.example.localpresistenceonzoom.databinding.ActivityUserBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserActivity : AppCompatActivity() {

    lateinit var  binding : ActivityUserBinding
    lateinit var userMan : UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userMan = UserManager(this)

        binding.btnSave.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val umur = binding.etUmur.text.toString()

            GlobalScope.launch {
                userMan.saveData(nama, umur.toInt())
            }
        }
    }
}