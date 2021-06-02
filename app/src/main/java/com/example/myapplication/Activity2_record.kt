package com.example.myapplication

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.Activity2MainBinding
import com.example.myapplication.databinding.Activity2RecordBinding

class Activity2_record: AppCompatActivity() {
    private lateinit var binding: Activity2RecordBinding
    private var index :Int =0
    private val id_array : Array<String> = arrayOf(
            "r1","r2",
            "l1","l2","l3","l4","l5",
            "sh1","sh2","sh3","sh4","sh5",
            "a1","a2","a3","a4","a5",
            "c1","c2","c3","c4","c5",
            "b1","b2","b3","b4","b5",
            "st1","st2","st3","st4","st5"
    )
    private val url_array : Array<String> = arrayOf(
            "https://www.fabrykasily.pl/cwiczenia/mobilizacje", //r1
            "https://www.fabrykasily.pl/rozciaganie", //r2
            "https://www.fabrykasily.pl/cwiczenia/czworoglowe-uda/przysiad-ze-sztanga-trzymana-na-plecach", //l1
            "https://www.fabrykasily.pl/cwiczenia/czworoglowe-uda/zakroki-w-miejscu-z-hantelkami", //l2
            "https://www.fabrykasily.pl/cwiczenia/dwuglowe-uda/martwy-ciag-na-prostych-nogach-barbell", //l3
            "https://www.fabrykasily.pl/cwiczenia/na-lydki/wspiecia-na-palcach-stojac-z-hantlami", //l4
            "https://www.fabrykasily.pl/atlas-cwiczen/dwuglowe-uda/unoszenie-bioder-ze-sztanga", //l5
            "https://www.fabrykasily.pl/cwiczenia/na-barki/wyciskanie-sztangi-nad-glowe-standing-front", //sh1
            "https://www.fabrykasily.pl/cwiczenia/na-barki/wznosy-ramion-w-bok-w-opadzie", //sh2
            "https://www.fabrykasily.pl/cwiczenia/na-barki/wyciskanie-sztangi-zza-glowy-stojac-standing" , //sh3
            "https://www.fabrykasily.pl/cwiczenia/na-barki/unoszenie-ramion-w-przod-ze-sztangielkami", //sh4
            "https://www.fabrykasily.pl/cwiczenia/na-barki/odwodzenie-ramion-w-bok-ze-sztangielkami", //sh5
            "https://www.fabrykasily.pl/cwiczenia/na-biceps/zginanie-przedramion-w-waskim-chwycie", //a1
            "https://www.fabrykasily.pl/atlas-cwiczen/biceps/uginanie-ramion-z-hantlami-z-rotacja", //a2
            "https://www.fabrykasily.pl/atlas-cwiczen/triceps/wyciskanie-francuskie-z-przenoszeniem-ramion-za-glowe", //a3
            "https://www.fabrykasily.pl/cwiczenia/na-triceps/prostowanie-przedramienia-w-pionie-ze-sztangielka", //a4
            "https://www.fabrykasily.pl/atlas-cwiczen/triceps/pompki-na-poreczach-z-guma", //a5
            "https://www.fabrykasily.pl/cwiczenia/na-klatke-piersiowa/wyciskanie-sztangi-na-lawce-plaskiej-barbell", //c1
            "https://www.fabrykasily.pl/cwiczenia/na-klatke-piersiowa/wyciskanie-sztangi-na-lawce-dodatniej-incline", //c2
            "https://www.fabrykasily.pl/atlas-cwiczen/klatka-piersiowa/wyciskanie-sztangi-na-lawce-skosnej-glowa-w-dol", //c3
            "https://www.fabrykasily.pl/cwiczenia/na-klatke-piersiowa/rozpietki-z-hantlami-na-lawce-plaskiej", //c4
            "https://www.fabrykasily.pl/cwiczenia/na-klatke-piersiowa/przenoszenie-sztangielki-za-glowe-bentarm-dumbbell", //c5
            "https://www.fabrykasily.pl/atlas-cwiczen/plecy/wioslowanie-sztanga-nachwytem-w-pelnym-opadzie-tulowia", //b1
            "https://www.fabrykasily.pl/atlas-cwiczen/plecy/wioslowanie-w-oparciu-reka-o-laweczke", //b2
            "https://www.fabrykasily.pl/atlas-cwiczen/dwuglowe-uda-posladki/klasyczny-martwy-ciag-z-podwyzszenia", //b3
            "https://www.fabrykasily.pl/atlas-cwiczen/plecy/podciaganie-nachwytem-z-pomoca-gumy-oporowej", //b4
            "https://www.fabrykasily.pl/cwiczenia/na-plecy/unoszenie-tulowia-na-lawce-rzymskiej-hyperextensions", //b5
            "https://www.fabrykasily.pl/cwiczenia/na-brzuch/spiecia-brzucha-z-nogami-opartymi", //st1
            "https://www.fabrykasily.pl/cwiczenia/na-brzuch/izometryczny-skurcz-miesni-brzucha-w-podporze", //st2
            "https://www.fabrykasily.pl/cwiczenia/na-brzuch/zginanie-tulowia-na-maszynie-siedzac-spiecia", //st3
            "https://www.fabrykasily.pl/atlas-cwiczen/brzuch/scyzoryk", //st4
            "https://www.fabrykasily.pl/cwiczenia/na-brzuch/przyciaganie-kolan-do-klatki-w-zwisie-2" //st5
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_record)
        binding= DataBindingUtil.setContentView(this, R.layout.activity2_record)
        val id = intent.getStringExtra("id").toString()
        for(i in id_array.indices){
            if(id==id_array[i])
                index = i
        }
        val web = WebView(this)
        setContentView(web)
        web.loadUrl(url_array.get(index))
    }
}