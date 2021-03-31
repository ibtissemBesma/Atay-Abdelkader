package dz.ASI.myapplication.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dz.ASI.myapplication.MainActivity
import dz.ASI.myapplication.ProduitPopup
import dz.ASI.myapplication.ProduitType
import dz.ASI.myapplication.R

class ProduitAdapter (
        val context: MainActivity,
        private val Produitliste : List<ProduitType>,
        private val layoutId: Int):RecyclerView.Adapter<ProduitAdapter.ViewHolder>(){

    // boite pour ranger tout les composants à controler
    class ViewHolder( view : View) : RecyclerView.ViewHolder(view)
    {
        val produitImage= view.findViewById<ImageView>(R.id.image_item)
        val produitname:TextView? = view.findViewById(R.id.item_name)
        val produitPrix:TextView?= view.findViewById(R.id.item_prix)
        val produitDescription :TextView?= view.findViewById(R.id.item_description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
                .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // recupérer les informations du produits
        val currentProduit = Produitliste[position]

        // utiliser glide pour récupérer les photos
        Glide.with(context).load(Uri.parse(currentProduit.imageUrl)).into(holder.produitImage)
        // mettre à jour le nom du produit
        holder.produitname?.text = currentProduit.nom
        holder.produitPrix?.text = currentProduit.prix
        holder.produitDescription?.text= currentProduit.description

        // inteeraction lors de clic sur produit
        holder.itemView.setOnClickListener {
            // afficher la popup
            ProduitPopup(this,currentProduit).show()
        }


    }
    override fun getItemCount(): Int {
        return  Produitliste.size
    }
}