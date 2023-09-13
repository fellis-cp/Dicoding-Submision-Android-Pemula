package com.dicoding.subs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    private lateinit var rvGirls: RecyclerView
    private val listGirls = ArrayList<Girls>() // Define a list to store girl data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the RecyclerView
        rvGirls = findViewById(R.id.rv_girls)
        rvGirls.setHasFixedSize(true)

        // Add girl data to the list using the getListGirls function
        listGirls.addAll(getListGirls())

        // Set up the RecyclerView with a LinearLayoutManager (or GridLayoutManager if you prefer)
        rvGirls.layoutManager =
            LinearLayoutManager(this) // Use LinearLayoutManager for a vertical list
        // rvGirls.layoutManager = GridLayoutManager(this, 2) // Use GridLayoutManager for a grid

        // Create the adapter and set it to your RecyclerView
        val adapter = ListGirlsAdapter(listGirls)
        rvGirls.adapter = adapter

        // Define an item click listener for the RecyclerView
        adapter.setOnItemClickCallback(object : ListGirlsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Girls) {
                // Handle item click here, for example, start a new activity with girl details
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("girlName", data.name)
                intent.putExtra("girlDescription", data.description)
                intent.putExtra("girlPhoto", data.photo)
                startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                // Handle list view selection
                rvGirls.layoutManager = LinearLayoutManager(this)
                return true
            }


            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }

    }
}

    private fun getListGirls(): ArrayList<Girls> {
        val girlsList = ArrayList<Girls>()

        girlsList.add(Girls("Piramida Giza", "Piramida Giza adalah salah satu dari tujuh keajaiban dunia kuno yang terletak di kompleks piramida Giza , dekat Kairo, Mesir. Piramida Giza juga dikenal sebagai Piramida Agung Giza . Piramida ini dibangun sekitar 4.500 tahun yang lalu oleh Firaun Khufu, yang memerintah pada periode Kerajaan Lama Mesir. Piramida Giza memiliki tinggi sekitar 146 meter dan terdiri dari sekitar 2,3 juta batu bata yang beratnya beragam , mulai dari beberapa ton hingga lebih dari 15 ton. Bangunan ini terbuat dari batu kapur putih yang mengkilap pada awalnya. Piramida Giza memiliki tiga ruangan di dalamnya , yaitu ruang pemakaman utama, ruang ratu, dan ruang bawah tanah. Piramida Giza adalah contoh keajaiban teknik arsitektur yang luar biasa pada zaman kuno. Meskipun dibangun tanpa menggunakan mesin modern, piramida ini memiliki presisi yang mengagumkan dalam hal penempatan batu-batu bata yang beratnya sangat besar. Piramida Giza juga mencerminkan kemampuan matematika dan astronomi yang maju pada masa itu. Piramida Giza adalah simbol kekuasaan dan kebesaran Firaun Mesir kuno. Selain Piramida Agung Giza, di kompleks piramida Giza juga terdapat dua piramida lainnya yang dibangun oleh firaun Khafre dan Menkaure . Selain itu, terdapat juga patung Sphinx yang terkenal, yang merupakan lambang kekuasaan firaun. Piramida Giza menjadi salah satu tujuan wisata yang paling terkenal di dunia dan menjadi simbol dari peradaban kuno Mesir. Keindahan, presisi, dan sejarahnya yang kaya membuat Piramida Giza tetap menjadi salah satu keajaiban dunia yang paling menakjubkan hingga saat ini.", R.drawable.giza))
        girlsList.add(Girls("Great Wall of China" , "Tembok Besar China adalah sebuah struktur pertahanan yang megah yang membentang sepanjang perbatasan Tiongkok. Tembok ini merupakan salah satu keajaiban dunia modern. Tembok Besar China dibangun secara bertahap selama berabad-abad oleh berbagai dinasti Tiongkok, dengan puncak pembangunannya terjadi pada masa Dinasti Ming (1368-1644). Tujuan utama pembangunan Tembok Besar China adalah untuk melindungi Tiongkok dari serangan suku-suku nomaden seperti Xiongnu , Mongol, dan lainnya. Tembok ini juga berfungsi sebagai jalur komunikasi, pengawasan, dan pemeriksaan perdagangan. Tembok Besar China terdiri dari berbagai bagian yang saling terhubung, termasuk dinding-dinding, menara-menara pengawas, gerbang-gerbang, dan benteng-benteng. Tembok Besar China memiliki panjang total sekitar 21.196 kilometer (13.171 mil), menjadikannya salah satu struktur manusia terpanjang di dunia. " ,R.drawable.china))
        girlsList.add(Girls("TajMahal" , "Taj Mahal adalah sebuah monumen megah yang terletak di kota Agra, India. Monumen ini dibangun oleh Kaisar Shah Jahan sebagai tanda cinta dan penghormatan atas kematian istrinya , Mumtaz Mahal. Taj Mahal dianggap sebagai salah satu keajaiban dunia dan merupakan salah satu situs warisan dunia UNESCO. Taj Mahal terkenal karena keindahan arsitektur dan desainnya yang memukau. Bangunan ini terbuat dari batu marmer putih yang dipahat dengan indah dan dihiasi dengan ukiran-ukiran yang rumit . Monumen ini memiliki empat menara yang menjulang tinggi di setiap sudutnya, dengan kubah besar di tengahnya. Pada malam hari, Taj Mahal terlihat sangat memukau ketika disinari oleh cahaya bulan. Di dalam Taj Mahal terdapat mausoleum yang berisi makam Mumtaz Mahal dan Shah Jahan. Interior mausoleum ini dihiasi dengan ukiran-ukiran halus dan kaligrafi dari Al-Quran. Selain itu, taman yang indah mengelilingi Taj Mahal, dengan kolam air yang mencerminkan keindahan bangunan. Taj Mahal bukan hanya merupakan sebuah monumen, tetapi juga simbol cinta abadi dan keindahan seni arsitektur. Keunikan dan keindahan Taj Mahal telah menarik perhatian pengunjung dari seluruh dunia. Monumen ini menjadi magnet wisata yang signifikan bagi India dan menjadi salah satu tujuan wisata paling populer di dunia. Taj Mahal adalah bukti cinta yang tak tergoyahkan dan keajaiban seni arsitektur yang memikat. Keindahannya yang menawan dan sejarah yang kaya menjadikan Taj Mahal sebagai salah satu situs yang paling mengagumkan di dunia." ,R.drawable.tajmahal))
        girlsList.add(Girls("patung Kristus Penebus" , "tPatung Kristus Penebus, atau dikenal dengan nama Cristo Redentor dalam bahasa Portugis, adalah patung Yesus Kristus yang terletak di Rio de Janeiro, Brasil. Patung ini merupakan salah satu ikon terkenal Brasil dan menjadi salah satu Tujuh Keajaiban Dunia Modern. Patung Kristus Penebus memiliki tinggi 38 meter dan terletak di puncak Gunung Corcovado , dengan ketinggian total 710 meter di Taman Nasional Hutan Tijuca . Patung ini didesain dalam gaya arsitektur Art Deco yang megah dan merupakan karya pemahat Paul Landowski . Pembangunan patung ini dimulai pada tahun 1922 dan selesai pada tanggal 12 Oktober 1931. Patung ini terbuat dari batu sabun yang dilapisi dengan mosaik ribuan ubin batu. Dari puncak Gunung Corcovado , patung ini menghadap ke kota Rio de Janeiro dan menjadi simbol keagamaan dan perdamaian bagi masyarakat Brasil. Patung Kristus Penebus memiliki arti dan makna yang mendalam bagi umat Kristen di Brasil dan juga sebagai daya tarik wisata yang besar. Setiap tahunnya, ribuan wisatawan dari seluruh dunia datang untuk mengunjungi patung ini dan menikmati pemandangan spektakuler dari puncak Gunung Corcovado. Patung Kristus Penebus adalah sebuah karya seni yang mengesankan dan menjadi simbol keindahan , keagungan, dan perdamaian. Keberadaannya telah mengukuhkan Brasil sebagai tujuan wisata yang menakjubkan dan meninggalkan kesan yang tak terlupakan bagi pengunjungnya." ,R.drawable.kristen))
        girlsList.add(Girls("Petra City " , "tKota Petra adalah sebuah kota kuno yang terletak di Yordania. Kota ini terkenal karena arsitektur uniknya yang terpahat di dalam tebing batu merah. Petra dikenal juga dengan sebutan \"Kota Batu Merah\" karena bangunannya yang terbuat dari batu pasir merah yang indah. Kota Petra didirikan oleh suku Nabatea pada abad ke-6 SM dan menjadi pusat perdagangan yang penting di jalur perdagangan antara Timur Tengah, Afrika, dan Asia. Kota ini mencapai masa kejayaannya pada abad pertama SM hingga abad pertama Masehi. Salah satu ciri khas Petra adalah Al-Khazneh atau \"The Treasury\", sebuah kuil megah yang terkenal dengan fasadnya yang indah dan terpahat dengan detail yang rumit. Tempat ini menjadi salah satu ikon terkenal dari Petra. Selain Al-Khazneh, Petra juga memiliki banyak bangunan dan struktur yang menakjubkan, seperti teater kuno, kuil, makam, dan sistem saluran air yang canggih. Kota ini juga memiliki jalan-jalan yang terukir indah di dalam tebing batu, menciptakan suasana yang magis dan memikat bagi para pengunjung. Petra pernah menjadi salah satu kota yang hilang selama berabad-abad, tetapi pada tahun 1812, penjelajah Swiss bernama Johann Ludwig Burckhardt menemukan kembali kota ini. Sejak itu, Petra telah menjadi salah satu tujuan wisata yang populer di dunia dan dianggap sebagai Situs Warisan Dunia UNESCO. Kota Petra memiliki sejarah yang kaya dan keindahan arsitektur yang menakjubkan. Keunikan dan keindahan kota ini telah menarik minat dan kagum dari para wisatawan yang datang dari seluruh dunia. Petra merupakan salah satu tempat yang tidak boleh dilewatkan bagi pecinta sejarah dan arkeologi." ,R.drawable.petra))
        girlsList.add(Girls("Colloseum" , "\n" +
                "6.\tKoloseum, juga dikenal sebagai Amfiteater Flavian, adalah sebuah bangunan yang terletak di Roma, Italia. Bangunan ini merupakan salah satu simbol keagungan dan kekuasaan Kekaisaran Romawi pada masa lalu. Koloseum dibangun pada abad ke-1 Masehi dan digunakan untuk pertunjukan gladiator , pertandingan binatang, dan acara hiburan publik lainnya. Koloseum memiliki bentuk elips dengan panjang sekitar 189 meter, lebar sekitar 156 meter, dan tinggi sekitar 50 meter. Bangunan ini mampu menampung sekitar 50.000 penonton pada saat itu. Koloseum terdiri dari tiga tingkat, dengan arsitektur yang megah dan terperinci. Sayangnya, seiring berjalannya waktu, Koloseum mengalami kerusakan dan perampokan. Banyak bagian bangunan yang hilang atau rusak akibat gempa bumi, perang, dan tindakan manusia. Namun, Koloseum tetap menjadi salah satu landmark yang paling ikonik di dunia dan menjadi daya tarik wisata yang populer di Roma. Pada tahun 1749, Koloseum mulai mendapatkan perhatian dalam hal pemeliharaan. Paus Benediktus XIV melarang penggunaan Koloseum sebagai tempat penambangan , dan sejak itu, upaya pemeliharaan dan restorasi dilakukan untuk menjaga keaslian dan keindahan bangunan ini. Hari ini, Koloseum menjadi salah satu situs warisan dunia " ,R.drawable.colu))
        girlsList.add(Girls("Machu Picchu" , "Machu Machu Picchu adalah sebuah situs bersejarah yang terletak di Cusco, Peru. Situs ini merupakan salah satu dari keajaiban dunia dan merupakan peninggalan dari peradaban Inca . Machu Picchu adalah sebuah kota Inca pra-Kolumbus yang terletak di Pegunungan Andes. Situs ini ditemukan pada tahun 1911 oleh Hiram Bingham , seorang arkeolog Amerika. Machu Picchu terletak di ketinggian sekitar 2.350 meter di atas permukaan laut , dan memiliki pemandangan alam yang spektakuler. Machu Picchu terdiri dari berbagai struktur arsitektur yang mengagumkan, termasuk kuil, tempat tinggal, dan sistem irigasi yang rumit. Bangunan-bangunan ini terbuat dari batu-batu besar yang dipahat dengan presisi tinggi, tanpa menggunakan bahan perekat. Situs ini memiliki beberapa bagian utama, seperti Intihuatana, yang merupakan sebuah batu yang digunakan untuk mengamati pergerakan matahari, dan Kuil Matahari, yang merupakan tempat pemujaan bagi suku Inca. Ada juga berbagai ruangan dan teras yang digunakan untuk berbagai kegiatan, termasuk pertanian. Machu Picchu memiliki nilai sejarah dan arkeologi yang sangat tinggi. Tempat ini memberikan wawasan yang mendalam tentang kehidupan dan kebudayaan suku Inca. Selain itu, pemandangan alam yang indah di sekitar Machu Picchu membuatnya menjadi salah satu tempat wisata yang paling populer di dunia. Machu Picchu adalah tempat yang menakjubkan dan memikat, dengan kombinasi yang sempurna antara keindahan alam dan keajaiban arsitektur. Bagi para pengunjung, Machu Picchu menawarkan pengalaman yang tak terlupakan dan kesempatan untuk menjelajahi dan menghargai keajaiban dunia kuno." ,R.drawable.picu))
        girlsList.add(Girls("Great Barier Reef " , "Chichen Itza adalah situs arkeologi yang terletak di Semenanjung Yucatan , Meksiko. Situs ini merupakan peninggalan dari peradaban Suku Maya yang berkembang antara abad ke-9 hingga abad ke-15 Masehi . Chichen Itza juga merupakan salah satu dari Tujuh Keajaiban Dunia. Situs ini terdiri dari kompleks candi yang luas dan mengesankan . Salah satu struktur paling terkenal di Chichen Itza adalah Piramida El Castillo atau juga dikenal sebagai Kuil Kukulkan. Piramida ini memiliki arsitektur yang unik dan menjadi simbol penting dalam kebudayaan Maya. Selain itu, terdapat juga bangunan lain seperti Kuil Para Pejuang, Lapangan Bola, Kuil Pendeta Tinggi, Las Monjas, dan El Caracol yang merupakan observatorium astronomi. Suku Maya memiliki keahlian dalam seni pahat, keramik, arsitektur, dan astronomi. Hal ini tercermin dalam keindahan dan kecermatan teknik arsitektur yang digunakan dalam bangunan-bangunan di Chichen Itza . Situs ini digunakan untuk berbagai kegiatan keagamaan, termasuk upacara pengorbanan dan pengamatan bintang. Hari ini, Chichen Itza menjadi salah satu tujuan wisata yang populer di Meksiko. Pengunjung dapat menjelajahi kompleks candi, mempelajari sejarah dan kebudayaan Maya, dan menikmati keindahan arsitektur kuno yang dipamerkan di situs ini. Chichen Itza adalah bukti megahnya peradaban Maya dan menjadi saksi sejarah yang penting bagi Amerika Tengah. Keindahan dan keunikan situs ini membuatnya menjadi tempat yang menarik untuk dikunjungi dan dipelajari." ,R.drawable.reef))
        girlsList.add(Girls("Chichen Itza " , "Candi Borobudur adalah sebuah candi Budha yang terletak di Kabupaten Magelang , Jawa Tengah, Indonesia. Candi ini dibangun pada abad ke-8 oleh Dinasti Syailendra dari Kerajaan Mataram Kuno . Borobudur merupakan candi Budha terbesar dan terbanyak reliefnya di dunia. Candi Borobudur memiliki bentuk seperti piramida dengan limas segi empat. Candi ini terdiri dari tiga tingkatan, yaitu Kamadhatu, Rupadhatu, dan Arupadhatu. Setiap tingkatan memiliki relief-relief yang menggambarkan ajaran dan kisah-kisah Budha. Candi Borobudur juga memiliki stupa-stupa yang melambangkan kesucian dan pencerahan. Stupa-stupa ini menjadi tempat penyimpanan tulang suci dan benda-benda berharga dalam agama Budha. Selain sebagai tempat ibadah umat Budha , Candi Borobudur juga menjadi tempat wisata yang populer di Indonesia. Keindahan arsitektur dan relief-relief di candi ini menarik minat wisatawan dari berbagai negara. Pada tahun 1991, Candi Borobudur diakui sebagai Warisan Budaya Dunia oleh UNESCO . Keberadaan Candi Borobudur menjadi bukti penting dari kejayaan peradaban Budha di Indonesia. Dengan sejarah yang panjang dan keindahannya yang memukau, Candi Borobudur menjadi salah satu peninggalan budaya yang patut dikunjungi dan dipelajari ." ,R.drawable.itza))
        girlsList.add(Girls("Candi Borobudur " , "Great =Great Barrier Reef adalah terumbu karang terbesar di dunia yang terletak di sepanjang pantai timur laut Australia . Terumbu karang ini membentang sejauh lebih dari 2.300 kilometer dan mencakup area seluas sekitar 344.400 kilometer persegi. Great Barrier Reef menjadi tempat tinggal bagi lebih dari 1.500 spesies ikan, 600 spesies karang, dan banyak spesies lainnya, termasuk penyu laut, lumba-lumba, hiu, dan paus. Keindahan dan keanekaragaman hayati yang luar biasa di Great Barrier Reef membuatnya menjadi salah satu tujuan wisata terkenal di dunia. Namun , Great Barrier Reef juga menghadapi beberapa tantangan yang serius. Perubahan iklim, polusi, dan kerusakan fisik akibat aktivitas manusia menjadi ancaman bagi keberlanjutan karang ini. Pemutihan karang, di mana karang kehilangan warna akibat stres lingkungan, juga menjadi masalah yang serius. Upaya konservasi dan perlindungan terhadap Great Barrier Reef sedang dilakukan untuk menjaga keberlanjutan dan keindahan alam ini. Pemerintah Australia, organisasi " ,R.drawable.candi))

        return girlsList
    }


