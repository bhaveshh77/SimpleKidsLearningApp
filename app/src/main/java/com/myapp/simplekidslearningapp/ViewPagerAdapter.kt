package com.myapp.simplekidslearningapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.myapp.simplekidslearningapp.model.Animals


class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val animalsList: List<Animals>
) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        val animal: Animals = animalsList[position]
        return AnimalFragment.newInstance(
            animal.animalDescription,
            animal.animalImage
        )
    }

    override fun getItemCount(): Int {
        return animalsList.size
    }
}