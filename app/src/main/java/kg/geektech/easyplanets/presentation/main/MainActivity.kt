package kg.geektech.easyplanets.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.easyplanets.data.local.SetData
import kg.geektech.easyplanets.databinding.ActivityMainBinding
import kg.geektech.easyplanets.presentation.adapters.PlanetsAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        val adapter = PlanetsAdapter(SetData.setPlanets())
        binding.myRecycler.adapter = adapter
    }
}