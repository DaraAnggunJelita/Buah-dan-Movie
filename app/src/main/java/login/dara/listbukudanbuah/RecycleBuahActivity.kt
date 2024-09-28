package login.dara.listbukudanbuah

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import login.dara.listbukudanbuah.Adapter.BuahAdapter
import login.dara.listbukudanbuah.Model.MockList
import login.dara.listbukudanbuah.Model.ModelBuah

class RecycleBuahActivity : AppCompatActivity() {

    private lateinit var rv_buah: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge content
        setContentView(R.layout.activity_recycle_buah)

        // Initialize RecyclerView
        rv_buah = findViewById(R.id.rv_buah)
        rv_buah.layoutManager = GridLayoutManager(this, 1) // Use 1 for single column

        // Set adapter with data from MockList
        val adapter = BuahAdapter(MockList.getModel(this) as ArrayList<ModelBuah>, this)
        rv_buah.adapter = adapter

        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets // Return the insets to continue processing
        }
    }
}
