package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Filter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.Activity2LibraryBinding

class Activity2_library: AppCompatActivity() {
    private lateinit var binding: Activity2LibraryBinding
    private val activities:ArrayList<library_row> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_library)
        binding = DataBindingUtil.setContentView(this,R.layout.activity2_library)
        binding.activity2LibraryLabel.setText("BIBLIOTEKA TRENINGÓW")

        activities.add(library_row("Brzuszki","Rodzaj treningu","Trening brzucha","st1"))
        activities.add(library_row("Deska","Rodzaj treningu","Trening brzucha","st2"))
        activities.add(library_row("Martwy ciąg","Rodzaj treningu","Trening pleców","b3"))
        activities.add(library_row("Martwy ciąg na prostych nogach","Rodzaj treningu","Trening nóg","l3"))
        activities.add(library_row("Odwodzenie raminon w bok","Rodzaj treningu","Trening barków","sh5"))
        activities.add(library_row("Podciągnaie na drążku","Rodzaj treningu","Trening pleców","b4"))
        activities.add(library_row("Pompki na poręczach","Rodzaj treningu","Trening ramion","a5"))
        activities.add(library_row("Przenoszenie sztangiełki nad głowę","Rodzaj treningu","Trening klatki","c5"))
        activities.add(library_row("Przysiady ze sztangą","Rodzaj treningu","Trening nóg","l1"))
        activities.add(library_row("Ropiętki sztangiełkami","Rodzaj treningu","Trening klatki","c4"))
        activities.add(library_row("Rozciąganie","Rodzaj treningu","Ogólnorowojowy","r2"))
        activities.add(library_row("Rozgrzewka","Rodzaj treningu","Ogólnorowojowy","r1"))
        activities.add(library_row("Scyzoryk","Rodzaj treningu","Trening brzucha","st4"))
        activities.add(library_row("Spięcie brzucha na maszynie","Rodzaj treningu","Trening brzucha","st3"))
        activities.add(library_row("Ugianie ramion ze sztangą","Rodzaj treningu","Trening ramion","a1"))
        activities.add(library_row("Uginanie ramion ze sztangełkami","Rodzaj treningu","Trening ramion","a2"))
        activities.add(library_row("Unoszenie bioder ze sztangą","Rodzaj treningu","Trening nóg","l5"))
        activities.add(library_row("Unoszenie nóg w zwisie","Rodzaj treningu","Trening brzucha","st5"))
        activities.add(library_row("Unoszenie ramion ze sztangełkami","Rodzaj treningu","Trening ramion","a4"))
        activities.add(library_row("Unoszenie ramion ze sztangełkami","Rodzaj treningu","Trening barków","sh4"))
        activities.add(library_row("Unoszenie tułowia na ławce rzymskiej","Rodzaj treningu","Trening pleców","b5"))
        activities.add(library_row("Wiosłowanie sztangą","Rodzaj treningu","Trening pleców","b1"))
        activities.add(library_row("Wiosłowanie sztangiełkami","Rodzaj treningu","Trening pleców","b2"))
        activities.add(library_row("Wspięcia na łydkach","Rodzaj treningu","Trening nóg","l4"))
        activities.add(library_row("Wyciskanie francuskie sztangą","Rodzaj treningu","Trening ramion","a3"))
        activities.add(library_row("Wycikanie sztangi na dodatniej ławce","Rodzaj treningu","Trening klatki","c2"))
        activities.add(library_row("Wyciskanie sztangi na prostej łąwce","Rodzaj treningu","Trening klatki","c1"))
        activities.add(library_row("Wyciskanie sztangi na ujemnej ławce","Rodzaj treningu","Trening klatki","c3"))
        activities.add(library_row("Wyciskanie ze sztangą z tyłu","Rodzaj treningu","Trening barków","sh3"))
        activities.add(library_row("Wyciskanie żołnierskie","Rodzaj treningu","Trening barków","sh1"))
        activities.add(library_row("Wykroki ze sztangiełkami","Rodzaj treningu","Trening nóg","l2"))
        activities.add(library_row("Wznosy ramion","Rodzaj treningu","Trening barków","sh2"))

        val activities_adapter = library_adapter(this,activities)
        binding.activity2LibraryList.adapter=activities_adapter
        binding.activity2LibraryList.setOnItemClickListener{ parent: AdapterView<*>?, view: View?, position :Int, id: Long ->
            var intent = Intent(this, Activity2_record::class.java)
            var id:String = activities[position].Id
            intent.putExtra("id",id)
            startActivity(intent)
        }
    }
}