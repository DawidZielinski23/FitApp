package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.Activity2SamplesBinding
import kotlin.collections.ArrayList
import kotlin.random.Random

class Activity2_samples : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    private lateinit var binding: Activity2SamplesBinding

    private val legs:ArrayList<samples_row> = ArrayList()
    private val shoulders:ArrayList<samples_row> = ArrayList()
    private val arms:ArrayList<samples_row> = ArrayList()
    private val chest:ArrayList<samples_row> = ArrayList()
    private val back:ArrayList<samples_row> = ArrayList()
    private val stomach:ArrayList<samples_row> = ArrayList()
    private var i:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_samples)
        binding=DataBindingUtil.setContentView(this, R.layout.activity2_samples)
        val trainngs: Array<String> = arrayOf(
                "Wybierz trening",
                "Trening nóg",
                "Trening barków",
                "Trening ramion",
                "Trening klatki",
                "Trening pleców",
                "Trening brzucha")
        var adapter_trainings = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,trainngs)
        binding.activity2SamplesSpinner.adapter = adapter_trainings
        binding.activity2SamplesSpinner.onItemSelectedListener =this
        binding.activity2SamplesLabel.setText("PRZYKŁADOWE TRNENINGI")
        binding.activity2SamplesLabel2.setText("Wybierz rodzaj treningu")
        binding.activity2SamplesText.setText("Klikająć poniższy przycisk możesz wygenerować trening ogólnorozwojwy uwzględniający różne partie mieśni")

        legs.add(samples_row("Rozgrzewka","15 minut","Czas trwania","r1"))
        legs.add(samples_row("Przysiady ze sztangą","4/10","Ilość serii/powtórzeń:","l1"))
        legs.add(samples_row("Wykroki ze sztangiełkami","4/10","Ilość serii/powtórzeń:","l2"))
        legs.add(samples_row("Martwy ciąg na prostych nogach","4/10","Ilość serii/powtórzeń:","l3"))
        legs.add(samples_row("Wspięcia na łydkach","4/12","Ilość serii/powtórzeń:","l4"))
        legs.add(samples_row("Unoszenie bioder ze sztangą","3/12","Ilość serii/powtórzeń:","l5"))
        legs.add(samples_row("Rozciąganie","15 minut","Czas trwania","r2"))

        shoulders.add(samples_row("Rozgrzewka","15 minut","Czas trwania","r1"))
        shoulders.add(samples_row("Wyciskanie żołnierskie","4/10","Ilość serii/powtórzeń:","sh1"))
        shoulders.add(samples_row("Arnoldki","3/12","Ilość serii/powtórzeń:","sh2"))
        shoulders.add(samples_row("Wyciskanie ze sztangą z tyłu","4/10","Ilość serii/powtórzeń:","sh3"))
        shoulders.add(samples_row("Unoszenie ramion ze sztangełkami","3/12","Ilość serii/powtórzeń:","sh4"))
        shoulders.add(samples_row("Odwodzenie raminon w bok","3/12","Ilość serii/powtórzeń:","sh5"))
        shoulders.add(samples_row("Rozciąganie","15 minut","Czas trwania","r2"))

        arms.add(samples_row("Rozgrzewka","15 minut","Czas trwania","r1"))
        arms.add(samples_row("Ugianie ramion ze sztangą","4/10","Ilość serii/powtórzeń:","a1"))
        arms.add(samples_row("Uginanie ramion ze sztangełkami","3/12","Ilość serii/powtórzeń:","a2"))
        arms.add(samples_row("Wyciskanie francuskie sztangi","4/10","Ilość serii/powtórzeń:","a3"))
        arms.add(samples_row("Unoszenie ramion ze sztangełkami","3/12","Ilość serii/powtórzeń:","a4"))
        arms.add(samples_row("Pompki na poręczach","4/8","Ilość serii/powtórzeń:","a5"))
        arms.add(samples_row("Rozciąganie","15 minut","Czas trwania","r2"))

        chest.add(samples_row("Rozgrzewka","15 minut","Czas trwania","r1"))
        chest.add(samples_row("Wyciskanie sztangi na prostej łąwce","4/10","Ilość serii/powtórzeń:","c1"))
        chest.add(samples_row("Wyickanie sztangi na dodatniej ławce","4/10","Ilość serii/powtórzeń:","c2"))
        chest.add(samples_row("Wyciskanie sztangi na ujemnej ławce","4/10","Ilość serii/powtórzeń:","c3"))
        chest.add(samples_row("Ropiętki sztangiełkami","3/12","Ilość serii/powtórzeń:","c4"))
        chest.add(samples_row("Przenoszenie sztangiełki nad głowę","3/12","Ilość serii/powtórzeń:","c5"))
        chest.add(samples_row("Rozciąganie","15 minut","Czas trwania","r2"))

        back.add(samples_row("Rozgrzewka","15 minut","Czas trwania","r1"))
        back.add(samples_row("Wiosłowanie sztangą","4/10","Ilość serii/powtórzeń:","b1"))
        back.add(samples_row("Wiosłowanie sztangiełkami","3/12","Ilość serii/powtórzeń:","b2"))
        back.add(samples_row("Martwy ciąg","4/10","Ilość serii/powtórzeń:","b3"))
        back.add(samples_row("Podciągnaie na drążku","4/8","Ilość serii/powtórzeń:","b4"))
        back.add(samples_row("Unoszenie tułowia na ławce rzymskiej","4/8","Ilość serii/powtórzeń:","b5"))
        back.add(samples_row("Rozciąganie","15 minut","Czas trwania","r2"))

        stomach.add(samples_row("Rozgrzewka","15 minut","Czas trwania","r1"))
        stomach.add(samples_row("Brzuszki na ławce skośnej","Ilość serii/powtórzeń:","4/15","st1"))
        stomach.add(samples_row("Deska","3/1 minuta","Ilość serii/powtórzeń:","st2"))
        stomach.add(samples_row("Spięcie brzucha na maszynie","4/10","Ilość serii/powtórzeń:","st3"))
        stomach.add(samples_row("Skłony","4/12","Ilość serii/powtórzeń:", "st4"))
        stomach.add(samples_row("Unoszenie nóg w zwisie","4/12","Ilość serii/powtórzeń:", "st5"))
        stomach.add(samples_row("Rozciąganie","15 minut","Czas trwania","r2"))
        val adapter_activity1 = samples_adapter(this,legs)
        val adapter_activity2 = samples_adapter(this,shoulders)
        val adapter_activity3 = samples_adapter(this,arms)
        val adapter_activity4 = samples_adapter(this,chest)
        val adapter_activity5 = samples_adapter(this,back)
        val adapter_activity6 = samples_adapter(this,stomach)

        binding.activity2SamplesChoose.setOnClickListener {
            when(i){
                1->{
                    this.binding.activity2SamplesList.adapter = adapter_activity1}
                2->{
                    this.binding.activity2SamplesList.adapter = adapter_activity2}
                3->{
                    this.binding.activity2SamplesList.adapter = adapter_activity3}
                4->{
                    this.binding.activity2SamplesList.adapter = adapter_activity4}
                5->{
                    this.binding.activity2SamplesList.adapter = adapter_activity5}
                6->{
                    this.binding.activity2SamplesList.adapter = adapter_activity6}
                else -> i=0
            }
        }
        val duration = Toast.LENGTH_SHORT
        val message= Toast.makeText(this,"Wygenerwoano trening",duration)
        val auto:ArrayList<samples_row> = ArrayList()
        binding.activity2SamplesAuto.setOnClickListener(){
            if(!auto.isEmpty())
                auto.clear()
            auto.add(legs.get(0))
            var j:Int =Random.nextInt(1,5)
            auto.add(legs.get(j))
            j=Random.nextInt(1,5)
            auto.add(shoulders.get(j))
            j=Random.nextInt(1,5)
            auto.add(arms.get(j))
            j=Random.nextInt(1,5)
            auto.add(chest.get(j))
            j=Random.nextInt(1,5)
            auto.add(back.get(j))
            j=Random.nextInt(1,5)
            auto.add(stomach.get(j))
            auto.add(legs.get(6))
            i=7
            val auto_adapter =samples_adapter(this,auto)
            this.binding.activity2SamplesList.adapter = auto_adapter
            message.show()
        }
        binding.activity2SamplesList.setOnItemClickListener{ parent:AdapterView<*> ?, view: View?, position :Int, id: Long ->
            var intent = Intent(this, Activity2_record::class.java)
            var storage = ""
            when(i){
                1 -> storage=legs[position].name
                2 -> storage=shoulders[position].name
                3 -> storage=arms[position].name
                4 -> storage=chest[position].name
                5 -> storage=back[position].name
                6 -> storage=stomach[position].name
                7 -> storage=auto[position].name
            }
            intent.putExtra("name",storage)
            startActivity(intent)
        }




    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(parent==binding.activity2SamplesSpinner)
            i=parent.selectedItemPosition
    }

}