package com.example.lesson2app_last

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.lesson2app_last.databinding.ActivityMainBinding
import com.example.lesson2app_last.Character
//import java.lang.Character

class MainActivity : AppCompatActivity(), OnItemClick {

    private lateinit var binding: ActivityMainBinding
    private var data = arrayListOf<Character>()
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        adapter = CharacterAdapter(this)
        adapter.setData(data)
        binding.recycler.adapter = adapter

    }

    override fun openAlertDialog(pos: Int) {
        // build alert dialog
        val dialogBuilder = AlertDialog.Builder(this)

        // set message of alert dialog
        dialogBuilder.setMessage("Do you want to delete this item ?")

            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("YES") { dialog, id ->
                adapter.removeItem(pos)
            }
//            .setPositiveButton("YES", DialogInterface.OnClickListener {
//                    dialog, which -> {
//                        data.removeAt(pos)
//                    }

            // negative button text and action
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("AlertDialogExample")
        // show alert dialog
        alert.show()
    }


    private fun loadData() {
        data.add(
            Character(
                "Captain Jack Sparrow1",
                "https://www.seekpng.com/png/detail/388-3880363_captain-jack-sparrow-png.png"
            )
        )

        data.add(
            Character(
                "Captain Jack Sparrow2",
                "https://thumbs.dreamstime.com/b/johnny-depp-as-captain-jack-sparrow-model-figure-scale-bangkok-thailand-june-home-132076515.jpg"
            )
        )

        data.add(
            Character(
                "Captain Jack Sparrow3",
                "https://thumbs.dreamstime.com/b/johnny-depp-as-captain-jack-sparrow-model-figure-scale-bangkok-thailand-june-home-132076515.jpg"
            )
        )

    }
}