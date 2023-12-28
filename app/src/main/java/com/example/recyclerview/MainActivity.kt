package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var newsArray : ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv)

        val imgArray = arrayOf(R.drawable.elon, R.drawable.mark, R.drawable.modi, R.drawable.download,R.drawable.salmankhan,R.drawable.leone,R.drawable.prabhas,R.drawable.rahul,R.drawable.srk)
        val desArray = arrayOf("Elon Musk's Starlink satellite internet service is now available in India for pre-orders. The service is expected to be available in the country by 2022. The pre-booking amount is ₹7,300 and the total cost of the Starlink kit is ₹60,000. The kit includes a user terminal, a tripod, and a Wi-Fi router.",
            "Facebook CEO Mark Zuckerberg has said that the company will transform itself from a social media company to a metaverse company. Zuckerberg said that the metaverse will be the successor to the mobile internet. He added that the metaverse will be accessible across all platforms including VR, AR, PCs, and mobile devices.",
            "Prime Minister Narendra Modi on Thursday launched e-RUPI, a cashless and contactless digital payment system. The e-RUPI voucher is a QR code or SMS string-based e-voucher, which is delivered to the mobile of the beneficiaries. It is a person and purpose-specific payment system. The payment system has been developed by the National Payments Corporation of India (NPCI).",
            "The Indian government has banned 43 more Chinese apps in the country, including AliExpress. The apps have been banned under Section 69A of the Information Technology Act. The government said that the apps were engaged in activities that are prejudicial to the sovereignty and integrity of India, defence of India, the security of the state, and public order.",
            "Salman Khan has filed a defamation complaint against actor Kamaal R Khan in a Mumbai court. The complaint states that Kamaal has been publishing defamatory allegations against Salman on social media and YouTube. The complaint also states that Kamaal has been spreading malicious rumours about Salman, his films, and his business ventures.",
            "Sunny Leone has bought a new Maserati car. She shared a picture of herself posing with the car on Instagram. Sunny wrote, \"Nothing like being home in Kerala and starting my day with a beautiful bike ride.\" She added, \"A great way to start my day, making it my kind of beautiful.\"",
            "Prabhas has shared a new poster of his upcoming film 'Radhe Shyam'. The poster features Prabhas and Pooja Hegde in a romantic pose. The poster also features a glimpse of the Italian city of Venice. The film is set to release on January 14, 2022. It will be released in Telugu, Tamil, Hindi, Kannada, and Malayalam.",
            "Congress leader Rahul Gandhi on Thursday said that the government should not be scared of the Pegasus issue if it has not done anything wrong. He added that the government should allow a discussion on the issue in Parliament. \"If the government has not done anything wrong, then it should not be scared of a discussion in Parliament,\" Rahul said.",
            "Sharukh khan is the king of bollywood. He is the most popular actor in the world. He is the most richest actor in the world. He is husband of Gauri Khan. He has 3 children.")

        rv.layoutManager = LinearLayoutManager(this)

        newsArray = arrayListOf<News>()
        for (i in imgArray.indices) {
            val news = News(desArray[i],imgArray[i])
            newsArray.add(news)
        }

        val adapter = MyAdapter(newsArray,this)
        rv.adapter = adapter
        adapter.setOnClickListener(object: MyAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                if (position >= 0 && position < newsArray.size) {
                    val intent = Intent(applicationContext, NewsContent::class.java)
                    intent.putExtra("text", newsArray[position].text)
                    intent.putExtra("img", newsArray[position].img)
                    startActivity(intent)
                } else {
                    Log.e("Click Listener", "Invalid position clicked: $position")
                }
            }
        })


    }
}