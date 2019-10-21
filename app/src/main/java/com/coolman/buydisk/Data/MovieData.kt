package com.coolman.buydisk.Data

import com.coolman.buydisk.Model.ModelMovie
import com.coolman.buydisk.Model.ModelMusik
import com.coolman.buydisk.R

object MovieData {
    private val movie = arrayOf(
        "Fantastc Beast The Crimes Of The Grindelwald",
        "Harry Potter",
        "cars",
        "Spiderman Homecoming",
        "Kimi No Nawa",
        "Ip Man 3"
    )
    private val deskripsi = arrayOf(
        "Fantastic Beasts: The Crimes of Grindelwald (Film tahun 2018)\n" +
        "Pemeran: Eddie Redmayne, Johnny Depp, Jude Law, Ezra Miller, Katherine Waterston, Zoë Kravitz, Dan Fogler, Alison Sudol, Claudia Kim, Callum Turner\n" +
        "yang didapat : 1 Keping DVD",
        "Harry Potter and the Goblet of Fire (2005)\n" +
        "Pemeran: Daniel Radcliffe, Rupert Grint, Emma Watson, Michael Gambon, Gary Oldman, Ralph Fiennes, Brendan Gleeson, Maggie Smith\n" +
        "yang didapat : 1 Keping DVD",
        "Cars (2006)\n" +
        "Pemeran: Owen Wilson, Paul Newman, Larry the Cable Guy\n" +
        "yang didapat : 1 Keping DVD",
        "Spiderman Homecoming (2017)\n" +
        "Pemeran: Tom Holland, Michael Keaton, Jon Favreau, Zendaya, Donald Glover, Tyne Daly, Marisa Tomei, Robert Downey Jr.\n" +
        "yang didapat : 1 Keping DVD",
        "Kimi No Nawa (2016)\n" +
        "Pemaran : Ryunosuke Kamiki, Mone Kamishiraishi, Ryo Narita, Aoi Yūki, Nobunaga Shimazaki, Kaito Ishikawa, Kanon Tani, Masami Nagasawa, Etsuko Ichihara\n" +
        "yang didapat : 1 Keping DVD dan Stiker",
        "Ip Man 3 (2015)\n" +
        "Pemeran : Donnie Yen, Zhang Jin, Lynn Hung,Patrick Tam\n" +
        "yang didapat : 1 Keping DVD"
    )

    private val price = arrayOf(
        "380000",
        "400000",
        "300000",
        "500000",
        "430000",
        "350000"
    )
    private val photo = intArrayOf(
        R.drawable.fantasticbeast,
        R.drawable.harrypotter,
        R.drawable.cars,
        R.drawable.spidermanhomecoming,
        R.drawable.kiminonawa,
        R.drawable.ipman3
    )
    val listData: ArrayList<ModelMovie>
        get() {
            val list = arrayListOf<ModelMovie>()
            for (position in MovieData.movie.indices) {
                val mm = ModelMovie()
                mm.movie= MovieData.movie[position]
                mm.price = MovieData.price[position]
                mm.deskripsi = MovieData.deskripsi[position]
                mm.photo = MovieData.photo[position]
                list.add(mm)
            }
            return list
        }
}