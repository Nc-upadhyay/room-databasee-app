package com.nc.roomdatabase.doa

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nc.roomdatabase.entity.NoteEntity

@Dao
interface NotesDoa {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: NoteEntity);

    @Delete
    suspend fun delete(id: Int);

    @Query("select * from notes ORDER By note_id ASC")
    fun getAllNotes(): LiveData<List<NoteEntity>>

    @Query("select * from notes where note_id=:id")
    fun geNotes(id: Int): LiveData<NoteEntity>

    @Query("delete from notes")
    suspend fun deleteAll();

    @Update
    suspend fun updateNotes(note: NoteEntity): NoteEntity
}