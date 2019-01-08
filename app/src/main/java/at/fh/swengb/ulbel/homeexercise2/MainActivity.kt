package at.fh.swengb.ulbel.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick() {

        val name = editText_name.text.toString()
        var age = editText_age.text.toString().toIntOrNull()

        // TODO fehlende dateien auf git adden

     val sharedPreferences = getSharedPreferences("at.fh.swengb.ulbel.homeexercise2", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("NAME", name).apply()
        sharedPreferences.edit().putInt("AGE", age).apply()

        //val intent = Intent(this, NoteListActivity::class.java)
        //startActivity(intent)
    }
}
