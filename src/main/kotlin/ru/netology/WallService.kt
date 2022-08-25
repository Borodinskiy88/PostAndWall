package ru.netology

class PostNotFoundException(message : String) : RuntimeException(message)

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var id = 0


    fun add(post: Post): Post {
        posts += post.copy(id = id)
        id++
        return posts.last()
    }


    fun createComment(id: Int, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == id) {
                comments += comment
                return comments.last()
            }
        }
        return throw PostNotFoundException("Post not found")
    }

    fun lastComment(): Comment {
        return comments.last()
    }


    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
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
        id = 0

    }
}