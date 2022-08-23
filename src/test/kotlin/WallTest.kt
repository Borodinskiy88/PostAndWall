package ru.netology

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class WallTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addChangeID() {

        val addPost = WallService.add(
            post = Post(
                0, 0, 0, 0, 0, "", " ", 0, 0,
                likes = Likes(0), comments = Comments(0),
                views = Views(0), repost = Repost(0), geo = Geo(place = Place()),
                postSource = PostSource()
            )
        )
        val addPost2 = WallService.add(
            post = Post(
                0, 1, 1, 1, 1, "1", "No", 1, 1,
                likes = Likes(1), comments = Comments(1), views = Views(1), repost = Repost(1),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )

        val result = addPost2.id


        assertEquals(1, result)

    }

}

class WallServiceTest() {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExistId() {

        val service = WallService

        service.add(
            post = Post(
                0, 0, 0, 0, 0, "", " ", 1, 1,
                likes = Likes(0), comments = Comments(0), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )
        service.add(
            post = Post(
                1, 22, 22, 22, 22, "", " ", 22, 22,
                likes = Likes(22), comments = Comments(22), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )
        service.add(
            post = Post(
                2, 33, 33, 33, 33, "", "", 33, 33,
                likes = Likes(33), comments = Comments(33), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )

        val update = Post(
            1, 111, 111, 111, 111, "212", "", 111, 111,
            likes = Likes(234), comments = Comments(457), views = Views(), repost = Repost(),
            geo = Geo(place = Place()), postSource = PostSource()
        )

        val result = service.update(update)

        assertEquals(true, result)

    }

    @Test
    fun updateNonExistId() {
        val service = WallService

        service.add(
            post = Post(
                0, 0, 0, 0, 1, "", "", 0, 0,
                likes = Likes(0), comments = Comments(0), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )
        service.add(
            post = Post(
                1, 22, 22, 22, 22, "", "", 0, 0,
                likes = Likes(22), comments = Comments(22), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )
        service.add(
            post = Post(
                2, 33, 33, 33, 33, "", "", 0, 0,
                likes = Likes(33), comments = Comments(33), views = Views(), repost = Repost(),
                geo = Geo(place = Place()), postSource = PostSource()
            )
        )

        val update = Post(
            55, 0, 0, 0, 0, "", "", 0, 0,
            likes = Likes(0), comments = Comments(0), views = Views(), repost = Repost(),
            geo = Geo(place = Place()), postSource = PostSource()
        )

        val result = service.update(update)

        assertEquals(false, result)

    }
}

