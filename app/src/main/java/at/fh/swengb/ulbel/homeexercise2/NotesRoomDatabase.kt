package at.fh.swengb.ulbel.homeexercise2

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Note::class], version = 9)
abstract class NotesRoomDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {

        private var INSTANCE: NotesRoomDatabase? = null

        fun getDatabase(context: Context): NotesRoomDatabase{ //gets DB or builds it if it hasn't been built yet
            return INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        fun buildDatabase(context: Context): NotesRoomDatabase{
            return Room.databaseBuilder(context, NotesRoomDatabase::class.java, "notes-db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }

}