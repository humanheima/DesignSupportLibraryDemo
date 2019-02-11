package com.example.designsupportlibrarydemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_spring.*

class SpringFragment : Fragment() {

    private var list: ArrayList<String> = arrayListOf("Snackbar", "TextInputLayout", "CollapsingToolbarLayout")

    private lateinit var rootView: View

    private lateinit var adapter: BaseAdapter<String>


    companion object {

        @JvmStatic
        fun newInstance() = SpringFragment()
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_spring, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvSpring.layoutManager = LinearLayoutManager(activity)


        adapter = object : BaseAdapter<String>(activity, list) {


            override fun getHolderType(position: Int, t: String?): Int {
                return R.layout.item_rv_main
            }

            override fun bindViewHolder(holder: BaseViewHolder?, t: String?, position: Int) {
                holder?.setTextViewText(R.id.tvClick, t)
                holder?.setOnItemClickListener(R.id.tvClick) { _, pos ->
                    clickByPosition(pos)
                }
            }
        }
        rvSpring.adapter = adapter
    }

    private fun clickByPosition(pos: Int) {
        when (pos) {
            0 -> SnackbarActivity.launch(activity!!)
            1 -> TextInputLayoutActivity.launch(activity!!)
            2 -> CollapsingToolbarLayoutActivity.launch(activity!!)
        }
    }


}
