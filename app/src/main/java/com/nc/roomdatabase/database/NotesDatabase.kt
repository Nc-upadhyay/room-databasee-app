package com.nc.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nc.roomdatabase.doa.NotesDoa
import com.nc.roomdatabase.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
public abstract class NotesDatabase : RoomDatabase() {
    abstract fun getNotesDoa(): NotesDoa

    companion object {
        @Volatile
        private var INSTANCE: NotesDatabase? = null

        fun getDatabase(context: Context): NotesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "notes_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}