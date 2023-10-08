package com.nc.roomdatabase.repositry

import androidx.lifecycle.LiveData
import com.nc.roomdatabase.doa.NotesDoa
import com.nc.roomdatabase.entity.NoteEntity

class NoteRepository(private val notesDoa: NotesDoa) {
    val allNotes: LiveData<List<NoteEntity>> = notesDoa.getAllNotes();
    suspend fun insert(noteEntity: NoteEntity) {
        notesDoa.insert(noteEntity);
    }

    suspend fun delete(id: Int) {
        notesDoa.delete(id);
    }

    fun getNote(id: Int): LiveData<NoteEntity> {
        return notesDoa.geNotes(id);
    }

    suspend fun update(noteEntity: NoteEntity): NoteEntity {
        return notesDoa.updateNotes(noteEntity);
    }

    suspend fun deleteAll() {
        notesDoa.deleteAll();
    }

}