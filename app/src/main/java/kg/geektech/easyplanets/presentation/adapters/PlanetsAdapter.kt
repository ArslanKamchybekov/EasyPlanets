package kg.geektech.easyplanets.presentation.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.easyplanets.R
import kg.geektech.easyplanets.data.models.PlanetData
import kg.geektech.easyplanets.databinding.ItemViewBinding
import kg.geektech.easyplanets.presentation.planetDetail.PlanetDetailActivity
import java.util.*

class PlanetsAdapter(private val planets: MutableList<PlanetData>) :
    RecyclerView.Adapter<PlanetsAdapter.ViewHolder>() {

    var dummyImage: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(planets[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlanetDetailActivity::class.java)
            intent.putExtra("planet", planets[position])
            intent.putExtra("planetImage", dummyImage)
            holder.itemView.context.startActivity(intent)
        }
    }

    inner class ViewHolder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(planetData: PlanetData) {

            binding.title.text = planets[position].title + " m/ss"
            binding.distance.text = planets[position].distance + " m|km"
            binding.galaxy.text = planets[position].galaxy
            binding.gravity.text = planets[position].gravity

            when (planets[position].title?.lowercase(Locale.getDefault())) {
                "mars" -> {
                    dummyImage = R.drawable.ic_mars
                }
                "neptune" -> {
                    dummyImage = R.drawable.ic_neptune
                }
                "earth" -> {
                    dummyImage = R.drawable.ic_earth
                }
                "moon" -> {
                    dummyImage = R.drawable.ic_moon
                }
                "venus" -> {
                    dummyImage = R.drawable.ic_venus
                }
                "jupiter" -> {
                    dummyImage = R.drawable.ic_jupiter
                }
                "saturn" -> {
                    dummyImage = R.drawable.ic_saturn
                }
                "uranus" -> {
                    dummyImage = R.drawable.ic_uranus
                }
                "mercury" -> {
                    dummyImage = R.drawable.ic_mercury
                }
                "sun" -> {
                    dummyImage = R.drawable.ic_sun
                }
            }
            dummyImage?.let { binding.planetImg.setImageResource(it) }
        }
    }

    override fun getItemCount(): Int {
        return planets.size
    }
}