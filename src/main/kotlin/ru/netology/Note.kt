package ru.netology

data class Notes(
    var noteId: Int,
    val title: String,
    val text: String = "text",
    val privacy: Int = 0,
    val privacyView: String,
    val privacyComment: String,
    val ownerId: Int = 0,
    val noteIds: String,
    val userId: Int = 0,
    val offset: Int = 0,
    val countNote: Int = 0,
    val sort: Int = 0,
    val needWiki: Boolean = false,
    val commentNotes: MutableList<CommentNotes> = NoteService.getListCommentNotes()

)

data class CommentNotes(
    var noteId: Int,
    var commentId: Int = 0,
    val commentPrivacy: Int = 0,
    val replyTo: Int = 0,
    val message: String = "message",
    val guid: String,
    val countComment: Int = 0,
)