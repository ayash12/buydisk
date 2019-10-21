package com.coolman.buydisk.Data

import com.coolman.buydisk.Model.ModelMovie
import com.coolman.buydisk.Model.ModelSoft
import com.coolman.buydisk.R

object SoftData {
    private val soft = arrayOf(
        "Adobe Premiere Pro CC",
        "Avira",
        "Coreldraw X8",
        "Office 2016",
        "Windows 10",
        "Photoshop CC 2015"
    )

    private val price = arrayOf(
        "4000000",
        "3000000",
        "8000000",
        "7500000",
        "8500000",
        "3000000"
    )

    private val deskripsi = arrayOf(
        "Deskripsi Software \n" +
                "Release : 2015\n" +
                "yang didapatkan : 1.Keping DVD",
        "Deskripsi Software \n" +
                "Release : 2019\n" +
                "yang didapatkan : 1.Keping DVD",
        "Deskripsi Software \n" +
                "Release : 2016\n" +
                "yang didapatkan : 1.Keping DVD",
        "Deskripsi Software \n" +
                "Release : 2015\n" +
                "yang didapatkan : 1.Keping DVD",
        "Deskripsi Software \n" +
                "Release : 2018\n" +
                "yang didapatkan : 1.Keping DVD",
        "Deskripsi Software \n" +
                "Release : 2015\n" +
                "yang didapatkan : 1.Keping DVD"

    )

    private val photo = intArrayOf(
        R.drawable.adobepremiereprocc,
        R.drawable.avira,
        R.drawable.coreldrawx8,
        R.drawable.office2016,
        R.drawable.widows10,
        R.drawable.photoshopcc2015
    )
    val listData: ArrayList<ModelSoft>
        get() {
            val list = arrayListOf<ModelSoft>()
            for (position in soft.indices) {
                val ms = ModelSoft()
                ms.soft= soft[position]
                ms.price = price[position]
                ms.deskripsi = deskripsi[position]
                ms.photo = photo[position]
                list.add(ms)
            }
            return list
        }
}