package login.dara.listbukudanbuah.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import login.dara.listbukudanbuah.Model.ModelMovie
import login.dara.listbukudanbuah.R
import login.dara.listbukudanbuah.RecycleCardMovie

class MovieAdapter(
    private val activity: RecycleCardMovie, // changed variable name for clarity
    private val movieList: List<ModelMovie>,
    private val itemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtMovie: TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_car, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.txtMovie.text = movie.title // Use `nama` instead of `title`
        holder.imgMovie.setImageResource(movie.image)

        // Set click event
        holder.itemView.setOnClickListener {
            itemClickListener(position)
        }
    }
}
