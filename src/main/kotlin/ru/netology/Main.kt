package ru.netology

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
    println(createComment)
    println(reportComment)
   


}
