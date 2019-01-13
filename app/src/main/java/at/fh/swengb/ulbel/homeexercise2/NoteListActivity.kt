package at.fh.swengb.ulbel.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    //lateinit var db: NotesRoomDatabase

    private lateinit var myAdapter: NoteAdapter
    private lateinit var myDb: NotesRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val sharedPreferences = getSharedPreferences("at.fh.swengb.ulbel.homeexercise2", Context.MODE_PRIVATE)
        val savedName = sharedPreferences.getString("NAME", "")
        val savedAge = sharedPreferences.getInt("AGE", 0)

        val infotext = "Notes for $savedName, $savedAge"
        textViewInfo.text = infotext

        myDb = NotesRoomDatabase.getDatabase(this)
        myAdapter = NoteAdapter()

        noteRecyclerView.adapter = myAdapter
        noteRecyclerView.layoutManager = LinearLayoutManager(this)

        myAdapter.updateData(myDb.noteDao.findAll())

    }

    fun onAddNoteClick(v: View) {
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() { //refresh view/activity
        super.onResume()
        myAdapter.updateData(myDb.noteDao.findAll())
    }
}
