package ru.netology

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class WallTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentTestExcept() {
        val newComment = WallService.createComment(
            0,
            comment = Comment(
                0, 0, 0, "", donut = Donut(false, ""),
                thread = Thread(1)
            )
        )
    }

    @Test()
    fun createCommentTest() {
        val service = WallService

        val post1 = service.add(
            post = Post(
                0, 0, 0, 0, 0, "", "", 0, 0,
                likes = Likes(1), commentsPost = CommentsPost(0),
                views = Views(0), repost = Repost(0), geo = Geo(place = Place()), postSource = PostSource()
            )
        )

        val post2 = service.add(
            post = Post(
                1, 0, 0, 0, 0, "", "", 0, 0,
                likes = Likes(1), commentsPost = CommentsPost(0),
                views = Views(0), repost = Repost(0), geo = Geo(place = Place()), postSource = PostSource()
            )
        )

        var create = service.createComment(
            0,
            comment = Comment(
                1, 0, 1, "",
                donut = Donut(false, ""),
                0, 0, thread = Thread(12)
            )
        )

        val result = create == WallService.lastComment()

        assertEquals(true, result)

    }

    @Test
    fun addChangeIDTest() {

        val addPost = WallService.add(
            post = Post(
                0, 0, 0, 0, 0, "", " ", 0, 0,
                likes = Likes(0), commentsPost = CommentsPost(0),
                views = Views(0), repost = Repost(0), geo = Geo(place = Place()),
                postSource = PostSource()
            )
        )
        val addPost2 = WallService.add(
            post = Post(
                0, 1, 1, 1, 1, "1", "No", 1, 1,
                likes = Likes(1), commentsPost = CommentsPost(1), views = Views(1), repost = Repost(1),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )

        val result = addPost2.id

        assertEquals(1, result)

    }

    @Test
    fun updateExistIdTest() {

        val service = WallService

        service.add(
            post = Post(
                0, 0, 0, 0, 0, "", " ", 1, 1,
                likes = Likes(0), commentsPost = CommentsPost(0), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )
        service.add(
            post = Post(
                1, 22, 22, 22, 22, "", " ", 22, 22,
                likes = Likes(22), commentsPost = CommentsPost(22), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )
        service.add(
            post = Post(
                2, 33, 33, 33, 33, "", "", 33, 33,
                likes = Likes(33), commentsPost = CommentsPost(33), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )

        val update = Post(
            1, 111, 111, 111, 111, "212", "", 111, 111,
            likes = Likes(234), commentsPost = CommentsPost(457), views = Views(), repost = Repost(),
            geo = Geo(place = Place()), postSource = PostSource()
        )

        val result = service.update(update)

        assertEquals(true, result)

    }

    @Test
    fun updateNonExistIdTest() {
        val service = WallService

        service.add(
            post = Post(
                0, 0, 0, 0, 1, "", "", 0, 0,
                likes = Likes(0), commentsPost = CommentsPost(0), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )
        service.add(
            post = Post(
                1, 22, 22, 22, 22, "", "", 0, 0,
                likes = Likes(22), commentsPost = CommentsPost(22), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )
        service.add(
            post = Post(
                2, 33, 33, 33, 33, "", "", 0, 0,
                likes = Likes(33), commentsPost = CommentsPost(33), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )

        val update = Post(
            55, 0, 0, 0, 0, "", "", 0, 0,
            likes = Likes(0), commentsPost = CommentsPost(0), views = Views(), repost = Repost(),
            geo = Geo(place = Place()), postSource = PostSource()
        )

        val result = service.update(update)

        assertEquals(false, result)

    }

    @Test(expected = PostNotFoundException::class)
    fun addReportCommentExceptionTest() {
        val commentException = WallService.addReportComments(
            55,
            reportComment = ReportComment(1, 1, 1)
        )
    }

    @Test()
    fun addReportCommentTest() {

        val post = WallService.add(
            post = Post(
                0, 5, 5, 50, 12, "No", "No", 5, 5,
                likes = Likes(35), commentsPost = CommentsPost(45), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource(),
                attachment = arrayOf(PostedPhotoAttachment(PostedPhoto(12, 21)))
            )
        )

        val createComment = WallService.createComment(
            0,
            comment = Comment(
                9, 0, 0, "", donut = Donut(false, ""),
                thread = ru.netology.Thread(1)
            )
        )

        val result = WallService.addReportComments(
            9,
            reportComment = ReportComment(1, 1, 8)
        )

        assertEquals(true, result)

    }
}

