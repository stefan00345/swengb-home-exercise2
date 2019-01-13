package at.fh.swengb.ulbel.homeexercise2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter() : RecyclerView.Adapter<NoteViewHolder>() {

    var dataList = mutableListOf<Note>()

    fun updateData(list: List<Note>)
    {   dataList = list.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, position: Int) {
        val item = dataList[position]
        viewHolder.bindNote(item)
    }

}

class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindNote(note:Note) {

        itemView.item_note_title.text = note.title
        itemView.item_note_content.text = note.content
    }
}