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

//todo комменты создаются ко всем заметкам. Надо, чтоб создавались к конкретной,
// разобраться какой вариант лучше

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
//    override fun createComment(noteId: Int, commentNote: CommentNotes): CommentNotes {
//        for ((index, note) in notes.withIndex()) {
//            if (note.noteId == noteId) {
//                notes[index].commentNotes += commentNote
//                commentId++
//                return commentNotes.last()
//            }
//        }
//        return throw PostNotFoundException("Note $noteId not found")
//    }

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
        for (note in notes) {
            println("$note")
        }
    }


    //todo посмотреть как циклом вывести построчно, разобраться как вывести комменты конкретной заметки
    //вводим id заметки, ищем в коллекции нотес,
    // если ай ди заметки совпадает с ай ди ноутс, выводим все комментарии для этого ноутс
    fun getCommentNotes(noteId: Int): MutableList<CommentNotes> {
        for ((index, note) in notes.withIndex()) {
            if (note.noteId == noteId) {
                return notes[index].commentNotes
            }
        }
        return mutableListOf()
//        return throw PostNotFoundException("Notes $noteId not found")
    }

    fun getBiIdNotes(noteId: Int): Notes {
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



