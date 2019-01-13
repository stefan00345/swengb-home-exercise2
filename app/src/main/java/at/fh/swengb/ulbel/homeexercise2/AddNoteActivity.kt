package at.fh.swengb.ulbel.homeexercise2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    private lateinit var myAdapter: NoteAdapter
    private lateinit var myDb: NotesRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        myDb = NotesRoomDatabase.getDatabase(this)
        myAdapter = NoteAdapter()
    }

    fun addNoteClick(v: View) {

        val note = Note(editText_title.text.toString(), editText_content.text.toString())   //create new note with properties of edit texts
        myDb.noteDao.insert(note)                                                           // insert note to DB
        myAdapter.updateData(myDb.noteDao.findAll())                                        //update Adapter

        finish()                                                                            // finish activity

    }


}
