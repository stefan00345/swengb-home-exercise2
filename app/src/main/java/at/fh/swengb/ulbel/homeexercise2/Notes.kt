package at.fh.swengb.ulbel.homeexercise2

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "notes")
class Note(@PrimaryKey val title: String, val content: String) { //class for a note

}