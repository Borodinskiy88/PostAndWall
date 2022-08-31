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
        9, reportComment = ReportComment(1, 1, 8))


    println(post2)
    println(post)
//    println(createComment)
//    println(reportComment)

//    val note = NoteService.add(
//        note = Notes(0, "", "", 0, "", "",
//    0, "", 0, 0, 0)
//    )

    val note1 = NoteService.add(
        note = Notes(0, "", "", 0, "", "",
            0, "", 0, 0, 0
        ))
    val note2 = NoteService.add(
        note = Notes(1, "", "", 0, "", "",
            0, "", 0, 0, 0
        ))

//    val note3 = NoteService.update(newNote = Notes(1, "22", "22", 0, "", "",
//        0, "", 0, 0, 0
//    ))

    val comment = NoteService.createComment(1, CommentNotes(guid = "HAHAHAH"))
    println(comment)
//
//    val comment2 = NoteService.createComment(0, CommentNotes(guid = "11"))
//    val delete = NoteService.deleteNotes(1)
    println(NoteService.getNotes())

    val resComD = NoteService.deleteCommentNotes(0)
    println(resComD)

    val res = NoteService.restoreCommentNotes(0)
     println(res)

//    println(note1)
//    println(note2)
//    println(delete)
////    println(note3)
// //   println(note2)
//    println(NoteService.getNotes())
////    println(NoteService.getCommentNotes())
//    println(delete)
//
//    println("!!!!!!!!!")
//    println(NoteService.getBiIdNotes(0))


}

