package com.coolman.buydisk.Data

import com.coolman.buydisk.Model.ModelMusik
import com.coolman.buydisk.R

object MusikData {
    val album = arrayOf(
        "Squere Up",
        "Love Yourself : Answer",
        "Divide",
        "Overexposed",
        "Eye Of The Storm",
        "Musim Yang Baik"
    )
   val artis = arrayOf(
        "Blackpink",
        "BTS",
        "Ed Sheeran",
        "Maroon 5",
        "One Ok Rock",
        "Sheila On 7"
    )
    private val deskripsi = arrayOf(
        "Daftar Lagu Album Blackpink\n" +
                "\n 1. 뚜두뚜두 (Ddu-Du Ddu-Du)\n " +
                "2. Forever Young\n " +
                "3. Really\n " +
                "4. See U Later",
        "Daftar Lagu Album BTS\n" +
                "\n 1.Euphoria\n" +
                "2.Trivia 起 : Just Dance\n" +
                "3.Serendipity (Full Length Edition)\n" +
                "4.DNA\n" +
                "5.보조개\n" +
                "6.Trivia 承 : Love\n" +
                "8.Her\n" +
                "9.Singularity\n" +
                "10.Fake Love\n" +
                "11.전하지 못한 진심 (Feat. Steve Aoki)\n" +
                "12.Trivia 轉 : Seesaw\n" +
                "13.Tear\n" +
                "14.Epiphany\n" +
                "15.I’m Fine\n" +
                "16.IDOL\n" +
                "17.Answer : Love Yourself\n" +
                "dll",
        "Daftar Lagu Album Ed Sheeran\n" +
                "1. Eraser\n" +
                "2. Castle On The Hill\n" +
                "3. Dive\n" +
                "4. Shape Of You\n" +
                "5. Perfect\n" +
                "6. Galway Girl\n" +
                "7. Happier\n" +
                "8. Hearts Don’t Break Around Here\n" +
                "9. New Man\n" +
                "10. What Do I Know?\n" +
                "11. How Would You Feel (Paean)\n" +
                "12. Supermarket Flowers",
        "Daftar Lagu Album Maroon 5\n" +
                "1.One More Night\n" +
                "2.Payphone (featuring Wiz Khalifa)\n" +
                "3.Daylight \n" +
                "4.Lucky Strike\n" +
                "5.The Man Who Never Lied\n" +
                "6.Love Somebody \n" +
                "7.Beautiful Goodbye\n" +
                "8.Fortune Teller\n" +
                "9.Sad\n" +
                "10.Ladykiller\n" +
                "11.Doin' Dirt\n" +
                "12.Tickets ",
        "Daftar Lagu Album One Ok Rock\n" +
                "1.Eye of the Storm\n" +
                "2.Stand Out Fit In\n" +
                "3.Head High\n" +
                "4.Grow Old Die Young\n" +
                "5.Push Back\n" +
                "6.Wasted Nights\n" +
                "7.Change\n" +
                "8.Letting Go\n" +
                "9.Worst In Me\n" +
                "10.In The Stars (Feat. Kiiara)\n" +
                "11.Giants\n" +
                "12.Unforgettable\n" +
                "13.The Last Time",
        "Daftar Lagu Album Sheila On 7\n" +
                "1. Selamat Datang\n" +
                "2. Satu Langkah\n" +
                "3. Buka Mata dan Telinga\n" +
                "4. Canggung\n" +
                "5. My Lovely\n" +
                "6. Beruntungnya Aku\n" +
                "7. Lapang Dada\n" +
                "8. Belum\n" +
                "9. Musim Yang Baik\n" +
                "10. Sampai Jumpa"
    )
    private val price = arrayOf(
        "500000",
        "699000",
        "650000",
        "550000",
        "450000",
        "300000"
    )

    private val photo = intArrayOf(
        R.drawable.blackpinksquereup,
        R.drawable.loveyourselfanswerbts,
        R.drawable.edsheerandivide,
        R.drawable.maroon5overexposed,
        R.drawable.oneokrockeyeofthestorm,
        R.drawable.so7musimyangbaik
    )
    val listData: ArrayList<ModelMusik>
        get() {
            val list = arrayListOf<ModelMusik>()
            for (position in album.indices) {
                val modelMusik = ModelMusik()
                modelMusik.album= album[position]
                modelMusik.artist = artis[position]
                modelMusik.price = price[position]
                modelMusik.deskripsi = deskripsi[position]
                modelMusik.photo = photo[position]
                list.add(modelMusik)
            }
            return list
        }

}