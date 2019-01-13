package at.fh.swengb.ulbel.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(v: View) {

        val name = editText_name.text.toString()                    //get name from editText
        val age = editText_age.text.toString().toIntOrNull() ?: 0   //get and convert age from edit Text

        val sharedPreferences = getSharedPreferences("at.fh.swengb.ulbel.homeexercise2", Context.MODE_PRIVATE) //save to shared preferences:
        sharedPreferences.edit().putString("NAME", name).apply()
        sharedPreferences.edit().putInt("AGE", age).apply()

        val intent = Intent(this, NoteListActivity::class.java) //start NoteListActivity
        startActivity(intent)
    }
}
