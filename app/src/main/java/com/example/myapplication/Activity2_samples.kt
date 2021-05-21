package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.Activity2SamplesBinding

class Activity2_samples : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    private lateinit var binding: Activity2SamplesBinding

    private val legs:ArrayList<samples_row> = ArrayList<samples_row>()
    private val shoulders:ArrayList<samples_row> = ArrayList<samples_row>()
    private val arms:ArrayList<samples_row> = ArrayList<samples_row>()
    private val chest:ArrayList<samples_row> = ArrayList<samples_row>()
    private val back:ArrayList<samples_row> = ArrayList<samples_row>()
    private val stomach:ArrayList<samples_row> = ArrayList<samples_row>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_samples)
        binding=DataBindingUtil.setContentView(this, R.layout.activity2_samples)
        val training = arrayOf("Trening nóg","Trening barków","Trening ramion","Trening klatki","Trening pleców","Trening brzucha")
        var adapter_trainings = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,training)
        binding.activity2SamplesSpinner.adapter = adapter_trainings

        legs.add(samples_row("Rozgrzewka","15 minut","r1"))
        legs.add(samples_row("Przysiady ze sztangą","4/10","l1"))
        legs.add(samples_row("Wykroki ze sztangiełkami","4/10","l2"))
        legs.add(samples_row("Martwy ciąg na prostych nogach","4/10","l3"))
        legs.add(samples_row("Wspięcia na łydkach","4/12","l4"))
        legs.add(samples_row("Unoszenie bioder ze sztangą","3/12","l5"))
        legs.add(samples_row("Rozciąganie","15 minut","r2"))

        shoulders.add(samples_row("Rozgrzewka","15 minut","r1"))
        shoulders.add(samples_row("Wyciskanie żołnierskie","4/10","sh1"))
        shoulders.add(samples_row("Arnoldki","3/12","sh2"))
        shoulders.add(samples_row("Wyciskanie ze sztangą z tyłu","4/10","sh3"))
        shoulders.add(samples_row("Unoszenie ramion ze sztangełkami","3/12","sh4"))
        shoulders.add(samples_row("Odwodzenie raminon w bok","3/12","sh5"))
        shoulders.add(samples_row("Rozciąganie","15 minut","r2"))

        arms.add(samples_row("Rozgrzewka","15 minut","r1"))
        arms.add(samples_row("Ugianie ramion ze sztangą","4/10","a1"))
        arms.add(samples_row("Uginanie ramion ze sztangełkami","3/12","a2"))
        arms.add(samples_row("Wyciskanie francuskie sztangi","4/10","a3"))
        arms.add(samples_row("Unoszenie ramion ze sztangełkami","3/12","a4"))
        arms.add(samples_row("Pompki na poręczach","4/8","a5"))
        arms.add(samples_row("Rozciąganie","15 minut","r2"))

        chest.add(samples_row("Rozgrzewka","15 minut","r1"))
        chest.add(samples_row("Wyciskanie sztangi na prostej łąwce","4/10","c1"))
        chest.add(samples_row("Wyickanie sztangi na dodatniej ławce","4/10","c2"))
        chest.add(samples_row("Wyciskanie sztangi na ujemnej ławce","4/10","c3"))
        chest.add(samples_row("Ropiętki sztangiełkami","3/12","c4"))
        chest.add(samples_row("Przenoszenie sztangiełki nad głowę","3/12","c5"))
        chest.add(samples_row("Rozciąganie","15 minut","r2"))

        back.add(samples_row("Rozgrzewka","15 minut","r1"))
        back.add(samples_row("Wiosłowanie sztangą","4/10","c1"))
        back.add(samples_row("Wiosłowanie sztangiełkami","3/12","c2"))
        back.add(samples_row("Martwy ciąg","4/10","c3"))
        back.add(samples_row("Podciągnaie na drążku","4/8","c4"))
        back.add(samples_row("Unoszenie tułowia na ławce rzymskiej","4/8","c5"))
        back.add(samples_row("Rozciąganie","15 minut","r2"))

        stomach.add(samples_row("Rozgrzewka","15 minut","r1"))
        stomach.add(samples_row("Brzuszki na ławce skośnej","4/15","st1"))
        stomach.add(samples_row("Deska","3/1 minuta","st2"))
        stomach.add(samples_row("Spięcie brzucha na maszynie","4/10","st3"))
        stomach.add(samples_row("Skłony","4/12","st4"))
        stomach.add(samples_row("Unoszenie nóg w zwisie","4/12","st5"))
        stomach.add(samples_row("Rozciąganie","15 minut","r2"))



    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position:Int, id:Long){
        if(parent == binding.activity2SamplesSpinner){
            var training:String=parent.getItemAtPosition(position).toString()
            var i:Int
            when(training){
                "Trening nóg" -> i=1
                "Trenig barków" -> i=2
                "Trening ramion" -> i=3
                "Trening klatki" -> i=4
                "Trneing pleców" -> i=5
                "Trneing brzucha" -> i=6
                else -> i=0
            }
            when(i){
                1->{val adapter_activity1 = samples_adapter(this,legs)
                    binding.activity2SamplesList.adapter = adapter_activity1}
                2->{val adapter_activity2 = samples_adapter(this,shoulders)
                    binding.activity2SamplesList.adapter = adapter_activity2}
                3->{val adapter_activity3 = samples_adapter(this,arms)
                    binding.activity2SamplesList.adapter = adapter_activity3}
                4->{val adapter_activity4 = samples_adapter(this,chest)
                    binding.activity2SamplesList.adapter = adapter_activity4}
                5->{val adapter_activity5 = samples_adapter(this,back)
                    binding.activity2SamplesList.adapter = adapter_activity5}
                6->{val adapter_activity6 = samples_adapter(this,stomach)
                    binding.activity2SamplesList.adapter = adapter_activity6}
                else -> i=0
            }
        }
    }
}