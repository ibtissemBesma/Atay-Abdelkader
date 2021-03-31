package dz.ASI.myapplication

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import dz.ASI.myapplication.adapter.ProduitAdapter

class ProduitPopup(
        private val adapter: ProduitAdapter,
        private val currentProduit: ProduitType
) :Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_produit_desc)
        setupContent()
    }

    private fun setupContent() {
        // actualiser l'image du produit
        val produitimage= findViewById<ImageView>(R.id.image_item)
        Glide.with(adapter.context).load(Uri.parse(currentProduit.imageUrl)).into(produitimage)

        findViewById<TextView>(R.id.popup_produit_nom).text = currentProduit.nom
        findViewById<TextView>(R.id.popup_produit_description_subTitle).text = currentProduit.description
        findViewById<TextView>(R.id.popup_produit_prix_subtitle).text= currentProduit.prix




    }
}