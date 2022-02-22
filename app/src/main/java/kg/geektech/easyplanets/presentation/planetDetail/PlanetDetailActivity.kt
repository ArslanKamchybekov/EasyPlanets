package kg.geektech.easyplanets.presentation.planetDetail

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.easyplanets.R
import kg.geektech.easyplanets.data.models.PlanetData
import kg.geektech.easyplanets.databinding.ActivityPlanetDetailBinding

class PlanetDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlanetDetailBinding
    private lateinit var obj: PlanetData
    private var planetImg: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        obj = intent.getParcelableExtra("planet")!!
        planetImg = intent.getIntExtra("planetImage", -1)
        setData(obj, planetImg!!)
    }

    @SuppressLint("SetTextI18n")
    private fun setData(obj: PlanetData, planetImg: Int) {
        binding.titleInfo.text = obj.title
        binding.distanceInfo.text = obj.distance + "m km"
        binding.gravityInfo.text = obj.gravity + "  m/ss"
        binding.overviewInfo.text = obj.overview
        binding.galaxyInfo.text = obj.galaxy
        binding.planetImgInfo.setImageResource(planetImg)
    }
}