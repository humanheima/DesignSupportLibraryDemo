package com.example.designsupportlibrarydemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * @date: 2019/2/1
 * @author: dumingwei
 * @description:
 */
class FragmentAdapter(fragmentManager: androidx.fragment.app.FragmentManager) : androidx.fragment.app.FragmentStatePagerAdapter(fragmentManager) {

    lateinit var mFragments: ArrayList<androidx.fragment.app.Fragment>
    lateinit var mTitles: ArrayList<String>

    constructor(
        fragmentManager: androidx.fragment.app.FragmentManager, fragments: ArrayList<androidx.fragment.app.Fragment>,
        titles: ArrayList<String>
    ) : this(
        fragmentManager
    ) {
        mFragments = fragments
        mTitles=titles
    }

    override fun getItem(p: Int): androidx.fragment.app.Fragment {
        return mFragments[p]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitles[position]
    }

}