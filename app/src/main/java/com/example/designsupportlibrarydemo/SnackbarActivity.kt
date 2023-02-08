package com.example.designsupportlibrarydemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_snackbar.*

class SnackbarActivity : AppCompatActivity() {

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, SnackbarActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)
        btnShowSncakbar.setOnClickListener { v: View? -> showSnackbar() }
    }

    private fun showSnackbar() {
        Snackbar.make(clRoot, "title", Snackbar.LENGTH_LONG)
                .setAction("click") { v: View? ->
                    Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show()
                }.setDuration(Snackbar.LENGTH_LONG).show()
    }
}
