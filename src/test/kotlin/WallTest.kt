package ru.netology

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class WallTest {

    @Test
    fun addChangeID() {

        val addPost = WallService.add(
            post = Post(
                0, 0, 0, 0, "", "",
                likes = Likes(0), comments = Comments(0)))
        val addPost2 = WallService.add(
            post = Post(
                0, 1,1,1,"1", "1",
                likes = Likes(1), comments = Comments(1)
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

        service.add(post = Post(
            0, 0, 0, 0, "1", "", likes = Likes(0),
            comments = Comments(0)))
        service.add(post = Post(
            1, 22, 22, 22, "2", "", likes = Likes(22),
            comments = Comments(22)))
        service.add(post = Post(
            2, 33, 33, 33, "3", "", likes = Likes(33),
            comments = Comments(33)))

        val update = Post(
            1, 111, 111, 111, "111", "212", likes = Likes(234),
            comments = Comments(457))

        val result = service.update(update)

        assertEquals(true, result)

    }

    @Test
    fun updateNonExistId() {
        val service = WallService

        service.add(post = Post(
            0, 0, 0, 0, "1", "", likes = Likes(0),
            comments = Comments(0)))
        service.add(post = Post(
            1, 22, 22, 22, "2", "", likes = Likes(22),
            comments = Comments(22)))
        service.add(post = Post(
            2, 33, 33, 33, "3", "", likes = Likes(33),
            comments = Comments(33)))

        val update = Post(
            55, 0, 0, 0, "1", "", likes = Likes(0),
            comments = Comments(0))

        val result = service.update(update)

        assertEquals(false, result)

    }
}

