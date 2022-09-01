package ru.netology

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class NoteTest {

    @Before
    fun clearBeforeNoteTest() {
        NoteService.clear()
    }

    @Test
    fun addNoteTest() {
        val addPost = NoteService.add(
            note = Notes(0, "", privacyView = "", privacyComment = "", noteIds = ""))

        val addPost2 = NoteService.add(
            note = Notes(0, "", privacyView = "", privacyComment = "", noteIds = ""))

        val result = addPost2.noteId

        assertEquals(1, result)
    }

    @Test
    fun updateExistNoteIdNoteTest() {
        val service = NoteService

        service.add(note = Notes(0, "", privacyView = "", privacyComment = "", noteIds = ""))

        service.add(note = Notes(1, "1", privacyView = "1", privacyComment = "1", noteIds = "1"))

        val update = (Notes
            (0, "2", privacyView = "2", privacyComment = "2", noteIds = "2"))

        val result = service.update(update)

        assertEquals(true, result)
    }

    @Test
    fun updateNonExistNoteIdNoteTest() {
        val service = NoteService

        service.add(note = Notes(0, "", privacyView = "", privacyComment = "", noteIds = ""))

        service.add(note = Notes(1, "1", privacyView = "1", privacyComment = "1", noteIds = "1"))

        val update = (Notes
            (7, "7", privacyView = "7", privacyComment = "7", noteIds = "7"))

        val result = service.update(update)

        assertEquals(false, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentNoteExcept() {
        val comment = NoteService.createComment(0, commentNote = CommentNotes(guid = ""))
    }

    @Test
    fun createCommentNoteTest() {
        val service = NoteService

        val note = service.add(note = Notes
            (0, "", privacyView = "", privacyComment = "", noteIds = ""))

        val create = service.createComment(0, commentNote = CommentNotes(guid = ""))

        val result = create == NoteService.lastComment()

        assertEquals(true, result)
    }

    @Test
    fun updateExistCommentIdCommentNoteTest() {
        val service = NoteService

        val note = service.add(note = Notes
            (0, "", privacyView = "", privacyComment = "", noteIds = ""))

        val create = service.createComment(
            0, commentNote = CommentNotes(commentId = 0, guid = ""))

        val update = CommentNotes(0, guid = "1")

        val result = service.updateCommentNote(update)

        assertEquals(true, result)

    }

    @Test
    fun updateNonExistCommentIdCommentNoteTest() {
        val service = NoteService

        val note = service.add(note = Notes
            (0, "", privacyView = "", privacyComment = "", noteIds = ""))

        val create = service.createComment(
            0, commentNote = CommentNotes(commentId = 0, guid = ""))

        val update = CommentNotes(5, guid = "1")

        val result = service.updateCommentNote(update)

        assertEquals(false, result)
    }

    @Test
    fun deleteNotesTest() {
        val service = NoteService

        val note = service.add(note = Notes
            (0, "", privacyView = "", privacyComment = "", noteIds = ""))

        val result = service.deleteNotes(0)

       assertEquals(true, result)
    }

    @Test
    fun deleteNonExistNoteIdNotesTest() {
        val service = NoteService

        val note = service.add(note = Notes
            (0, "", privacyView = "", privacyComment = "", noteIds = ""))

        val result = service.deleteNotes(6)

        assertEquals(false, result)
    }

    @Test
    fun deleteCommentNotesTest() {
        val service = NoteService

        val note = service.add(note = Notes
            (0, "", privacyView = "", privacyComment = "", noteIds = ""))

        val create = service.createComment(
            0, commentNote = CommentNotes(commentId = 0, guid = ""))

        val result = service.deleteCommentNotes(0)

        assertEquals(true, result)

    }

    @Test
    fun deleteCommentNonExistCommentIdNotesTest() {
        val service = NoteService

        val note = service.add(note = Notes
            (0, "", privacyView = "", privacyComment = "", noteIds = ""))

        val create = service.createComment(
            0, commentNote = CommentNotes(commentId = 0, guid = ""))

        val result = service.deleteCommentNotes(7)

        assertEquals(false, result)

    }

    @Test
    fun getNotes() {
        val service = NoteService
        val note = service.add(note = Notes
            (0, "", privacyView = "", privacyComment = "", noteIds = ""))
        val result = service.getNotes()

        assertEquals(true, result)
    }
    @Test
    fun getNotesEmpty() {
        val result = NoteService.getNotes()

        assertEquals(false, result)
    }



}