package ru.netology

object NoteService : CrudService<Notes, CommentNotes> {
    private var notes = mutableListOf<Notes>()
    private var commentNotes = mutableListOf<CommentNotes>()
    private var noteId = 0

    /*
    todo add
    Создает новую заметку у текущего пользователя.

    todo createComment
    Добавляет новый комментарий к заметке.

    todo delete ????????????????? Работает
    Удаляет заметку текущего пользователя.
    Удалять заметку по индексу.

    deleteComment
    Удаляет комментарий к заметке.

    todo edit
    Редактирует заметку текущего пользователя.

    todo editComment
    Редактирует указанный комментарий у заметки.

    todo get ?????????
    Возвращает список заметок, созданных пользователем.

    getById
    Возвращает заметку по её id.

    getComments
    Возвращает список комментариев к заметке.

    getFriendsNotes
    Возвращает список заметок друзей пользователя.

    restoreComment
    Восстанавливает удалённый комментарий.
     */

    override fun add(note: Notes): Notes {
        notes += note.copy(noteId = note.noteId)
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

    override fun createComment(noteId: Int, commentNote: CommentNotes): CommentNotes {
        for (note in notes) {
            if (note.noteId == noteId) {
                commentNotes += commentNote
                return commentNotes.last()
            }
        }
        return throw PostNotFoundException("Note $noteId not found")
    }

    fun deleteNotes(noteId: Int, note: Notes): Boolean {
        for (note in notes) {
            if (note.noteId == noteId) {
                notes.remove(note)
                return true
            }
        }
        return false
    }

    fun getNotes(): Any {
        if (notes.size > 0) return notes else return "Notes list is empty"
    }

    fun getComments(note: Notes): Any {
        if (note.commentNotes != null) return note.commentNotes else return "There are no comments"
    }


    override fun lastComment(): CommentNotes {
        return commentNotes.last()
    }

    fun clear() {
        notes = emptyArray<Notes>().toMutableList()
        noteId = 0
    }

}

