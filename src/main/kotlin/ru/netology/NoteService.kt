package ru.netology

object NoteService : CrudService<Notes, CommentNotes> {
    private var notes = mutableListOf<Notes>()
    private var commentNotes = mutableListOf<CommentNotes>()
    private var commentDeleted = mutableListOf<CommentNotes>()
    private var noteId = 0
    private var commentId = 0

    fun getCommentNotes(): MutableList<CommentNotes> {
        return commentNotes
    }

    override fun add(note: Notes): Notes {
        notes.add(note.copy(noteId = noteId))
        noteId++
        return notes.last()
    }

    override fun update(newNote: Notes): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == newNote.noteId) {
                notes[index] = newNote.copy(
                    ownerId = note.ownerId,
                )
                return true
            }
        }
        return false
    }

    override fun createComment(noteId: Int, commentNote: CommentNotes): CommentNotes {
        for (note in notes) {
            if (note.noteId == noteId) {
                note.commentNotes += commentNote
                commentId++
                return commentNotes.last()
            }
        }
        return throw PostNotFoundException("Note $noteId not found")
    }

    fun updateCommentNote(newCommentNote: CommentNotes): Boolean {
        for ((index, commentNote) in commentNotes.withIndex()) {
            if (commentNote.commentId == newCommentNote.commentId) {
                commentNotes[index] = newCommentNote.copy(
                    commentId = commentNote.commentId
                )
                return true
            }
        }
        return false
    }

    fun deleteNotes(noteId: Int): Boolean {
        for (note in notes) {
            if (note.noteId == noteId) {
                notes.remove(note)
                return true
            }
        }
        return false
    }

    fun deleteCommentNotes(commentId: Int): Boolean {
        for (commentNote in commentNotes) {
            if (commentNote.commentId == commentId) {
                commentNotes.remove(commentNote)
                commentDeleted.add(commentNote)
                return true
            }
        }
        return false
    }

    fun getNotes(vararg note: Notes) {
        if (notes.isEmpty()) {
            return throw PostNotFoundException("Note not found")
        } else notes.forEach { println(it) }
    }

    fun getCommentNotes(noteId: Int): MutableList<CommentNotes> {
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == noteId) {
                return notes[index].commentNotes
            }
        }
        return throw PostNotFoundException("Notes or comments not found")
    }

    fun getByIdNotes(noteId: Int): Notes {
        for (note in notes) {
            if (note.noteId == noteId) {
                return note
            }
        }
        return throw PostNotFoundException("Notes $noteId not found")
    }

    fun restoreCommentNotes(commentId: Int): Boolean {
        for (commentDelete in commentDeleted) {
            if (commentId == commentDelete.commentId) {
                commentNotes.add(commentDelete)
                return true
            }
        }
        return false
    }

    fun clear() {
        notes.clear()
        commentNotes.clear()
        noteId = 0
    }

    override fun lastComment(): CommentNotes {
        return commentNotes.last()
    }

}



