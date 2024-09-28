package login.dara.listbukudanbuah.Model

import android.content.Context
import login.dara.listbukudanbuah.R

data class ModelBuah(
    val image: Int,
    val nama: String,
    val lokasi : String,
    val deskripsi : String

)

object MockList {

    fun getModel(context : Context): List<ModelBuah> {
        val itemModel1 = ModelBuah(
            image = R.drawable.apple,
            nama = "Apple",
            "Indonesia",
            context.getString(R.string.st_apel)
        )
        val itemModel2 = ModelBuah(
            image = R.drawable.grapes,
            nama = "Anggur",
            "Malaysia",
            context.getString(R.string.st_anggur)
        )
        val itemModel3 = ModelBuah(
            image = R.drawable.orange,
            nama = "Jeruk",
            "Australia",
            context.getString(R.string.st_jeruk)
        )
        val itemModel4 = ModelBuah(
            image = R.drawable.pear,
            nama = "pear",
            "Bali",
            context.getString(R.string.st_pear)
        )
        val itemModel5 = ModelBuah(
            image = R.drawable.strawberry,
            nama = "Strawberry",
            "Bandung",
            context.getString(R.string.st_strawberry)
        )

        val itemList : ArrayList<ModelBuah> = ArrayList()
        itemList.add(itemModel1)
        itemList.add(itemModel2)
        itemList.add(itemModel3)
        itemList.add(itemModel4)
        itemList.add(itemModel5)

        return itemList

    }
}