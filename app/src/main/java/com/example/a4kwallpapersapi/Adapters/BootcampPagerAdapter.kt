package com.example.a4kwallpapersapi.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.a4kwallpapersapi.AllFragment
import com.example.a4kwallpapersapi.AnimalsFragment
import com.example.a4kwallpapersapi.NewFragment

class BootcampPagerAdapter(var list: ArrayList<String>, fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(
        fragmentManager,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {

        when (position) {

            0 -> {
                return AllFragment()
            }

            1 -> {
                return NewFragment()
            }

            2 -> {
                return AnimalsFragment()
            }

        }

        return AllFragment()

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position]
    }

}