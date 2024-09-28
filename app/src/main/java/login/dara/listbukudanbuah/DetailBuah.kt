package login.dara.listbukudanbuah

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailBuah : AppCompatActivity() {

    private lateinit var txtDetailBuah : TextView
    private lateinit var imgDetailBuah : ImageView
    private lateinit var txtlokasi : TextView
    private lateinit var txtdeskripsi : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_buah)

        txtDetailBuah = findViewById(R.id.txtDetailBuah)
        imgDetailBuah = findViewById(R.id.imgDetailBuah)
        txtlokasi = findViewById(R.id.txtlokasi)
        txtdeskripsi = findViewById(R.id.txtdeskripsi)

        // get data dari intent
        val detailTeks = intent.getStringExtra("nama")
        val detailImg = intent.getIntExtra("image", 0)
        val detaillokasi = intent.getStringExtra("lokasi")
        val detaildeskripsi = intent.getStringExtra("deskripsi")


        // set data ke widget
        txtDetailBuah.setText(detailTeks)
        imgDetailBuah.setImageResource(detailImg)
        txtlokasi.setText(detaillokasi)
        txtdeskripsi.setText(detaildeskripsi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
