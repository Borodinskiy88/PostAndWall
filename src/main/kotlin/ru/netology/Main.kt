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

    val reportComment = WallService.addReportComments(9, reportComment = ReportComment(1, 1, 8))



    println(post2)
    println(post)
    println(createComment)
    println(reportComment)


}

data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int?,
    val date: Int,
    val text: String,
    val copyright: String?,
    val replyOwnerId: Int?,
    val replyPostId: Int?,
    val friendsOnly: Boolean = false,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isFavorite: Boolean = false,
    val likes: Likes,
    val repost: Repost,
    val commentsPost: CommentsPost,
    val views: Views,
    val postType: String = "post",
    val geo: Geo?,
    val signerId: Int = 0,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val postponedId: Int = 0,
    val postSource: PostSource,
    val attachment: Array<Attachment> = emptyArray()
)


data class Likes(
    val count: Int,
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class CommentsPost(
    val count: Int,
    val canPost: Boolean = true,
    val groupCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

data class Repost(
    val count: Int = 0,
    val userReposted: Boolean = false,
)

data class Views(
    val count: Int? = 0
)

data class Geo(
    val type: String? = "city",
    val coordinates: String? = "0.0",
    val place: Place
)

data class Place(
    val placeView: String? = "Non"
)

data class PostSource(
    val type: String = "vk",
    val platform: String = "android",
    val data: String = "likes",
    val url: String? = "www"
)
