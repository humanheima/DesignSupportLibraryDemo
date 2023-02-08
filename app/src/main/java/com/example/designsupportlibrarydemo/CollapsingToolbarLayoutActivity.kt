package com.example.designsupportlibrarydemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_collapsing_toolbar_layout.*

class CollapsingToolbarLayoutActivity : AppCompatActivity() {

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, CollapsingToolbarLayoutActivity::class.java)
            context.startActivity(intent)
        }
    }

    private var list: ArrayList<String> = arrayListOf("Snackbar", "TextInputLayout", "Snackbar",
            "TextInputLayout", "Snackbar", "TextInputLayout", "Snackbar", "TextInputLayout",
            "Snackbar", "TextInputLayout", "Snackbar", "TextInputLayout", "Snackbar", "TextInputLayout")

    private lateinit var adapter: BaseAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar_layout)
        setSupportActionBar(toolbar)
        collapsingToolbar.title = "哆啦A梦"
        rv.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

        adapter = object : BaseAdapter<String>(this, list) {


            override fun getHolderType(position: Int, t: String?): Int {
                return R.layout.item_rv_main
            }

            override fun bindViewHolder(holder: BaseViewHolder?, t: String?, position: Int) {
                holder?.setTextViewText(R.id.tvClick, t)
            }
        }
        rv.adapter = adapter

    }
}
