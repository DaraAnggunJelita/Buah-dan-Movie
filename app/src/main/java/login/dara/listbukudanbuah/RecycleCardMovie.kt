package login.dara.listbukudanbuah

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import login.dara.listbukudanbuah.Adapter.MovieAdapter
import login.dara.listbukudanbuah.Model.ModelMovie

class RecycleCardMovie : AppCompatActivity() {
    private lateinit var recycleview: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private var movieList = mutableListOf<ModelMovie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_card_movie)

        recycleview = findViewById(R.id.rv_movie)

        movieAdapter = MovieAdapter(this, movieList) { position ->
            // Menampilkan dialog gambar detail ketika item di-klik
            showDetailDialog(position)
        }

        val layoutManager = GridLayoutManager(this, 2)
        recycleview.layoutManager = layoutManager
        recycleview.adapter = movieAdapter

        prepareMovieList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareMovieList() {
        var movie = ModelMovie("Avatar", R.drawable.avatar)
        movieList.add(movie)

        movie = ModelMovie("Batman", R.drawable.batman)
        movieList.add(movie)
        movie = ModelMovie("End Game", R.drawable.end_game)
        movieList.add(movie)
        movie = ModelMovie("Hulk", R.drawable.hulk)
        movieList.add(movie)
        movie = ModelMovie("Inception", R.drawable.inception)
        movieList.add(movie)
        movie = ModelMovie("Jumanji", R.drawable.jumanji)
        movieList.add(movie)
        movie = ModelMovie("Lucy", R.drawable.lucy)
        movieList.add(movie)
        movie = ModelMovie("Jurassic World", R.drawable.jurassic_world)
        movieList.add(movie)
        movie = ModelMovie("Spider Man", R.drawable.spider_man)
        movieList.add(movie)
        movie = ModelMovie("Venom", R.drawable.venom)
        movieList.add(movie)

        movieAdapter!!.notifyDataSetChanged()
    }

    private fun showDetailDialog(position: Int) {
        val intent = Intent(this, photodetail::class.java) // Pastikan kelas "PhotoDetail" benar
        intent.putExtra("imageResId", movieList[position].image) // Mengirim imageResId ke Activity PhotoDetail
        intent.putExtra("title", movieList[position].title)
        startActivity(intent)
        }
}
