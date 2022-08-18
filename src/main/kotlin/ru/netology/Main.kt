package ru.netology

fun main() {
    val post = Post(
        0, 1, 1, 10, "Hello!", "Yes",
        likes = Likes(120), comments = Comments(12)
    )

    val post2 = WallService.add(
        post = Post(
            0, 2, 2, 30, "Bye", "No",
            false, likes = Likes(500, true), comments = Comments(45)
        )
    )

    println(post)
    println(post2)
    println(WallService.update(post))
    println(WallService.add(post))

}

data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val copyright: String,
    val friendsOnly: Boolean = true,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isFavorite: Boolean = false,
    val likes: Likes,
    val comments: Comments
)
data class Likes(
    val count: Int,
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class Comments(
    val count: Int,
    val canPost: Boolean = true,
    val groupCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)

object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0


    fun add(post: Post): Post {
        id++
        posts += post.copy(id = id)
        return posts.first()
    }

    fun update(post: Post): Boolean {
        for ((index, newPost) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(
                    id = id,
                    ownerId = post.ownerId,
                    fromId = newPost.fromId,
                    date = post.date,
                    text = newPost.text,
                    copyright = newPost.copyright,
                    friendsOnly = newPost.friendsOnly,
                    canPin = newPost.canPin,
                    canDelete = newPost.canDelete,
                    canEdit = newPost.canEdit,
                    isFavorite = newPost.isFavorite,
                    likes = newPost.likes,
                    comments = newPost.comments
                )

            } else {
                return false
            }
        }
        return true
    }

    fun clear() {
        posts = emptyArray()
    }
}






