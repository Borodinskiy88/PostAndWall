package ru.netology

class PostNotFoundException(message: String) : RuntimeException(message)

fun main() {
    val post = WallService.add(
        post = Post(
            0, 5, 5, 50, 12, "No", "No", 5, 5,
            likes = Likes(35), commentsPost = CommentsPost(45), views = Views(), repost = Repost(),
            geo = Geo(place = Place()), postSource = PostSource(),
            attachment = arrayOf(PostedPhotoAttachment(PostedPhoto(12, 21)))
        )
    )

    val post2 = WallService.update(
        newPost = Post(
            0, 3, 3, 40, 23, "Maybe", "Yes", 0, 0,
            likes = Likes(23), commentsPost = CommentsPost(32), views = Views(), repost = Repost(),
            geo = Geo(place = Place()), postSource = PostSource()
        )
    )

    val createComment = WallService.createComment(
        0,
        comment = Comment(
            9, 0, 0, "", donut = Donut(false, ""),
            thread = ru.netology.Thread(1)
        )
    )

    val reportComment = WallService.addReportComments(
        9, reportComment = ReportComment(1, 1, 8)
    )


    val note1 = NoteService.add(
        note = Notes(
            0, "", "", 0, "", "",
            0, "", 0, 0, 0
        )
    )
    val note2 = NoteService.add(
        note = Notes(
            0, "", "", 0, "", "",
            0, "", 0, 0, 0
        )
    )

    val note3 = NoteService.update(
        newNote = Notes(
            0, "22", "22", 0, "", "",
            0, "", 0, 0, 0
        )
    )

    val comment = NoteService.createComment(1, CommentNotes(0, guid = "AHAHAH"))

    val comment2 = NoteService.createComment(0, CommentNotes(0, guid = "11"))

    val comment3 = NoteService.createComment(0, CommentNotes(0, guid = "Moscow"))


    val resComD = NoteService.deleteCommentNotes(0)

    val res = NoteService.restoreCommentNotes(0)

    val gCN = NoteService.getCommentNotes(1)

    val ucn = NoteService.updateCommentNote(
        newCommentNote = CommentNotes
            (0, 1, 1, "Text", "IHIHIHI")
    )
    NoteService.getNotes()

    println(NoteService.getCommentNotes(1))
}

