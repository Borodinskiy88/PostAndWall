package ru.netology
/*Что мы хотим получить:

Data класс Post (и другие классы, которые могут быть вложены в Post).
Объект WallService, который внутри себя хранит посты в массиве.
 */
fun main() {
    val post = Post(1, 1, 1, 0,"Hello!", " ",
        likes = Likes(120), comments = Comments(12)
    )

    println(post.likes)
    println(post.comments)
    println(post)

}
data class Post(
    val id: Int,
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
data class Likes (
    val count: Int,
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
        )

data class Comments (
    val count: Int,
    val canPost: Boolean = true,
    val groupCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
        )

object WallService {
    var posts = emptyArray<Post>()

    fun clear() {
        posts = emptyArray()
    }
}




