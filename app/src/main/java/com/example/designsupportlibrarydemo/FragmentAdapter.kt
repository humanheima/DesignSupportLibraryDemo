package com.example.designsupportlibrarydemo

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * @date: 2019/2/1
 * @author: dumingwei
 * @description:
 */
class FragmentAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    lateinit var mFragments: ArrayList<Fragment>
    lateinit var mTitles: ArrayList<String>

    constructor(
        fragmentManager: FragmentManager, fragments: ArrayList<Fragment>,
        titles: ArrayList<String>
    ) : this(
        fragmentManager
    ) {
        mFragments = fragments
        mTitles=titles
    }

    override fun getItem(p: Int): Fragment {
        return mFragments[p]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitles[position]
    }

}