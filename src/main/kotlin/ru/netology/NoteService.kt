package ru.netology

//todo разобраться где хранить commentNotes, возможно из за этого все комменты добавляются ко всем заметкам
object NoteService : CrudService<Notes, CommentNotes> {
    private var notes = mutableListOf<Notes>()
    private var commentNotes = mutableListOf<CommentNotes>()
    private var commentDeleted = mutableListOf<CommentNotes>()
    private var noteId = 0
    private var commentId = 0

    fun getCommentNotes(): MutableList<CommentNotes> {
        return commentNotes
    }

    /*
    todo add !!!!!!!!!!
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

    todo ????????? get
    Возвращает список заметок, созданных пользователем

    getById
    Возвращает заметку по её id.

    todo??????getComments
    Возвращает список комментариев к заметке.

    todo Нужно это вообще? getFriendsNotes
    Возвращает список заметок друзей пользователя.

    restoreComment
    Восстанавливает удалённый комментарий.
     */

    //todo!!!!!!!!!!!!!
    override fun add(note: Notes): Notes {
        notes.add(note.copy(noteId = noteId))
        noteId++
        return notes.last()
    }

    //todo!!!!!!!!!!!!!!
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

    //todo проверить, работает или нет. Возможно работает
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

    //todo !!!!!!!!!!!! работает, убирать всё лишнее из параметров
    fun deleteNotes(noteId: Int): Boolean {
        for (note in notes) {
            if (note.noteId == noteId) {
                notes.remove(note)
                return true
            }
        }
        return false
    }

    //todo работает, пока оставлю так
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

    //todo посмотреть как циклом вывести построчно, посмотреть в лекции Элвиса
    fun getNotes(): Any {
        if (notes.size > 0) return notes else return "Notes list is empty"
    }

    //todo посмотреть как циклом вывести построчно, разобраться как вывести комменты конкретной заметки
//    fun getCommentNotes(index: Int, note: Notes): Any {
//        for (note in notes) {
//            if (note.commentNotes > 0 != null) return note.commentNotes
//        }
//        return "There are no comments"
//    }

    //todo работает, пока оставлю так
    fun getBiIdNotes(noteId: Int) : Notes {
        for (note in notes) {
            if (note.noteId == noteId) {
                return note
            }
        }
        return throw PostNotFoundException("Notes $noteId not found")
    }


    //todo работает, оставлю так
    /*
    можно также добавить к комментарию поле удален он или нет,
    тогда не придется перемещать объекты между двумя коллекциями.
     */
    fun restoreCommentNotes (commentId: Int): Boolean {
        for (commentDelete in commentDeleted) {
            if (commentId == commentDelete.commentId) {
                commentNotes.add(commentDelete)
                return true
            }
        }
        return false
    }



    override fun lastComment(): CommentNotes {
        return commentNotes.last()
    }

    fun clear() {
        notes.clear()
        commentNotes.clear()
        noteId = 0
    }


}

