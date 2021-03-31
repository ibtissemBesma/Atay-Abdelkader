package dz.ASI.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dz.ASI.myapplication.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // charger main respository
        //val repo=ProduitsRepository()

        // mettre a jour la liste des produits
      //  repo.udpateData{
            //injecter le fragment dans notre boite  }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment(this))
        transaction.addToBackStack(null)
        transaction.commit()



    }
}