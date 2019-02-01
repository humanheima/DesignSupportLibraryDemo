package com.example.designsupportlibrarydemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var list: ArrayList<String> = arrayListOf("Snackbar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMain.layoutManager = LinearLayoutManager(this)


        rvMain.adapter = object : BaseAdapter<String>(this, list) {


            override fun getHolderType(position: Int, t: String?): Int {
                return R.layout.item_rv_main
            }

            override fun bindViewHolder(holder: BaseViewHolder?, t: String?, position: Int) {

            }
        }
    }
}
