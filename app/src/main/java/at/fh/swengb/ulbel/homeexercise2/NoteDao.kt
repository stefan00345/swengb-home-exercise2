package at.fh.swengb.ulbel.homeexercise2

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

@Dao
interface noteDao {
    @Insert
    fun insert(note: Note)
    @Update
    fun update(note: Note)

    /*
    @Query("DELETE FROM note")
    fun deleteAllStudents()*/

    @Query("SELECT * FROM notes ORDER BY title")
    fun findAll(): List<Note>
}