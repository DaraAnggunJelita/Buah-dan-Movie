package login.dara.listbukudanbuah

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnRecycleView: Button
    private lateinit var btnRecycleBuah: Button
    private lateinit var btnMovie : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnRecycleView = findViewById(R.id.btnRecycleView)
        btnRecycleBuah = findViewById(R.id.btnRecycleBuah)
        btnMovie       = findViewById(R.id. btnMovie)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnRecycleView.setOnClickListener() {
            val intentMenu = Intent(this@MainActivity, RecycleViewActivity::class.java)
            startActivity(intentMenu)
        }

        btnRecycleBuah.setOnClickListener() {
            val intentMenu = Intent(this@MainActivity, RecycleBuahActivity::class.java)
            startActivity(intentMenu)
        }

        btnMovie.setOnClickListener {
            val intentToRecycleCardMovie = Intent(this, RecycleCardMovie::class.java)
            startActivity(intentToRecycleCardMovie)
        }

    }
}