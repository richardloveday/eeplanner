package com.eeplanner.dao.note;

import com.eeplanner.datastructures.Note;
import com.eeplanner.datastructures.Contact;

import java.util.List;

public interface NoteDao {
    public List<Note> storeNotes(Contact contact);
    public Note storeNote(Note note);
	public List<Note> getNotesListByContactID(int id);
    public boolean removeNote(int id);
}
