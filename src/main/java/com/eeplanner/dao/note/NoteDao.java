package com.eeplanner.dao.note;

import com.eeplanner.datastructures.Note;
import com.eeplanner.datastructures.Contact;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Dec-2009
 * Time: 16:18:14
 * To change this template use File | Settings | File Templates.
 */
public interface NoteDao {
    public List<Note> storeNotes(Contact contact);
    public Note storeNote(Note note);
	public List<Note> getNotesListByContactID(int id);
    public boolean removeNote(int id);
}
