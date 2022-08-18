package ru.netology

import junit.framework.TestCase.assertEquals
import org.junit.Test

/*

на add - всего один, который проверяет, что после добавления поста id стал отличным от 0.
на update - целых два:
изменяем пост с существующим id, возвращается true;
изменяем пост с несуществующим id, возвращается false.
Почему мы не проверяем, что add действительно добавил, а update действительно что-то меняет?

Нам пока совсем немного не хватает знаний,
чтобы достроить нашу систему до действительно тестируемой — их мы получим на следующей лекции.
Пока же сделаем так.
 */
 /*

По факту речь идёт о том, что нам придётся либо дописать специальные вспомогательные методы,
либо научиться работать с nullable значениями.


Проблемы синглтонов
С синглтонами есть одна большая проблема -
они создаются один раз при старте приложения и в единственном экземпляре.


Тестировать такое не всегда удобно: вы либо должны сделать метод,
который «вычищает» синглтон, т.е. сбрасывает массив записей,
либо переделать object на обычный класс.


Если вы сделаете обычный класс, тогда в каждом тесте вы можете поступить следующим образом.
Пример для update:

class WallServiceTest {
    @Test
    fun updateExisting() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(Post(/* заполняете поля */))
        service.add(Post(/* заполняете поля */))
        service.add(Post(/* заполняете поля */))
        // создаём информацию об обновлении
        val update = Post(/* заполняете поля */)

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }
}
Если вы хотите оставить WallService в виде object, то можно добавить в него метод очистки clear:

object WallService {
    private var posts = emptyArray<Post>()

    fun clear() {
        posts = emptyArray()
    }
}
А затем указать JUnit с помощью аннотации @Before, что метод необходимо вызывать перед каждым тестом:

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExisting() {
        ...
    }
}

 */
class WallTest {

    @Test
    fun changeID() {
        val post = Post(0, 0, 0, 0, "", "",
            likes = Likes(0), comments = Comments(0))
        val postID = post.id

        val addPost = WallService.add(post = Post(0, 0, 0, 0, "", "",
        likes = Likes(0), comments = Comments(0)
        ))
        val addPostId = addPost.id

        val result = (postID == addPostId)

        assertEquals(true, result)






    }




}