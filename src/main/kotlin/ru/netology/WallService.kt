package ru.netology

class PostNotFoundException(message: String) : RuntimeException(message)

object WallService : CrudService<Post, Comment> {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reportComments = emptyArray<ReportComment>()
    private var id = 0


    override fun add(post: Post): Post {
        posts += post.copy(id = id)
        id++
        return posts.last()
    }


    override fun createComment(id: Int, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == id) {
                comments += comment
                return comments.last()
            }
        }
        return throw PostNotFoundException("Post $id not found")
    }

    override fun lastComment(): Comment {
        return comments.last()
    }


    override fun update(newPost: Post): Boolean {
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

    fun addReportComments(id: Int, reportComment: ReportComment): Boolean {
        for (comment in comments) {
            if ((comment.id == id) && (reportComment.reason in 0..6 || reportComment.reason == 8)) {
                reportComments += reportComment
                return true
            } else if (reportComment.reason > 8 || reportComment.reason < 0 || reportComment.reason == 7) {
                return throw PostNotFoundException("Incorrect reason for the complaint")
            }
        }
        return throw PostNotFoundException("The complaint cannot be accepted. Comment $id not found")
    }

    fun clear() {
        posts = emptyArray()
        id = 0

    }
}