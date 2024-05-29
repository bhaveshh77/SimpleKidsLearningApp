package com.myapp.simplekidslearningapp


import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.myapp.simplekidslearningapp.model.Animals

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private val animalsList: List<Animals> = arrayListOf(
        Animals(R.drawable.horse_image, "Horses are powerful and graceful animals known for their speed and agility. They are among the fastest land animals, capable of reaching speeds up to 55 miles per hour. Horses are found worldwide, primarily in plains, grasslands, and farms where they are domesticated. They have been used by humans for various purposes, including transportation, agriculture, sports, and therapy. Horses are also popular in equestrian sports such as racing, show jumping, and dressage, showcasing their speed, strength, and elegance. Their versatility and strong bond with humans make them one of the most cherished animals in history."),
        Animals(R.drawable.cow_image, "Cows are domesticated animals known for their gentle demeanor and agricultural importance. They are found worldwide, primarily in grasslands, farms, and rural areas where they are raised for their milk, meat, and hides. Cows play a crucial role in agriculture, providing dairy products like milk, cheese, and butter fo consumption. They are also used in various cultures for draft work, helping to plow fields and transport goods. Cows are revered in many societies for their contributions to human livelihoods, making them one of the most valuable domesticated animals in the world.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewPager = findViewById<ViewPager2>(R.id.viewPager)
//        val buttonPrevious = findViewById<ImageButton>(R.id.buttonPrevious)
//        val buttonNext = findViewById<ImageButton>(R.id.buttonNext)

//        animals.add(Animals(com.myapp.simplekidslearningapp.R.drawable.horse_image, "Description of Product 1")
//        animals.add(Animals("Product 2", "Description of Product 2")
//        animals.add(Animals("Product 3", "Description of Product 3")

        viewPagerAdapter = ViewPagerAdapter(this@MainActivity, animalsList)
        viewPager.setAdapter(viewPagerAdapter)


        // Disable user swiping
        viewPager.setUserInputEnabled(false)

//        buttonPrevious.setOnClickListener { v: View? ->
//            val currentItem = viewPager.getCurrentItem()
//            if (currentItem > 0) {
//                viewPager.setCurrentItem(currentItem - 1, true)
//            }
//        }
//
//        buttonNext.setOnClickListener { v: View? ->
//            val currentItem = viewPager.getCurrentItem()
//            if (currentItem < animalsList.size - 1) {
//                viewPager.setCurrentItem(currentItem + 1, true)
//            }
//        }

    }
}