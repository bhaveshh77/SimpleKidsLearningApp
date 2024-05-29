package com.myapp.simplekidslearningapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2


class AnimalFragment : Fragment() {


    private var animalDescription: String? = null
    private var animalImage = 0

    companion object {
        private const val ARG_ANIMAL_DESCRIPTION = "animal_description"
        private const val ARG_ANIMAL_IMAGE = "animal_image"

        @JvmStatic
        fun newInstance(animalDescription: String?, animalImage: Int): AnimalFragment {
            val fragment = AnimalFragment()
            val args = Bundle()
            args.putString(ARG_ANIMAL_DESCRIPTION, animalDescription)
            args.putInt(ARG_ANIMAL_IMAGE, animalImage)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            animalDescription = requireArguments().getString(ARG_ANIMAL_DESCRIPTION)
            animalImage = requireArguments().getInt(ARG_ANIMAL_IMAGE)
        }
        viewPager = activity?.findViewById(R.id.viewPager)!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_animal, container, false)
        val descriptionTextView = view.findViewById<TextView>(R.id.animalDescription)
        val imageView = view.findViewById<ImageView>(R.id.animalImage)

        descriptionTextView.setText(animalDescription)
        imageView.setImageResource(animalImage)

        val buttonPrevious = view.findViewById<ImageButton>(R.id.buttonPrevious)
        val buttonNext = view.findViewById<ImageButton>(R.id.buttonNext)

        buttonPrevious.setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem > 0) {
                viewPager.setCurrentItem(currentItem - 1, true)
            }
        }

        buttonNext.setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem < (viewPager.adapter?.itemCount ?: 0) - 1) {
                viewPager.setCurrentItem(currentItem + 1, true)
            }
        }

        return view
    }

}