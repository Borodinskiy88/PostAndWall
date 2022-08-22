package ru.netology

fun main() {
    val post = WallService.add(post = Post(0, 5, 5, 50, "Hello", "No",
    likes = Likes(35), comments = Comments(45)))

    val post2 = WallService.update(
        newPost = Post(0, 3, 3, 40, "Hi", "Maybe",
        likes = Likes(23), comments = Comments(32)
        )
    )

    println(post2)


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
        posts += post.copy(id = id)
        id++
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post ) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy(
                    ownerId = post.ownerId,
                    date = post.date
                )
                return true
            }
        }
        return false
    }
    fun clear() {
        posts = emptyArray()
    }
}






