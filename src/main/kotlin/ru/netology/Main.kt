package ru.netology

/*
В качестве примера возьмём всё тот же VKontakte: https://vk.com/dev/objects/post.
Если страница недоступна, воспользуйтесь копией из каталога assets).

На что нужно обратить внимание:

В Kotlin используется camelCase для полей.
Некоторые поля помечены как integer [0, 1], хотя по логике,
должны быть Boolean (у вас должны быть Boolean).
Добавьте из перечисленных в документации около 10 полей простых типов (Int, String, Boolean).
Поля типа object должны быть описаны отдельными классами.
Добавьте хотя бы одно такое поле (например, comments или likes).
Для полей вы можете добавлять значения по умолчанию, аналогично как параметрам функций.
При таком подходе вам не нужно будет указывать значения всех аргументов при создании объектов класса.
Что мы хотим получить:

Data класс Post (и другие классы, которые могут быть вложены в Post).
Объект WallService, который внутри себя хранит посты в массиве.
 */
fun main() {
    val post = Post(1, 1, 1, 0,"Hello!", " ")
    println(post.text)
    println(post)
}
data class Post (
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
    var likes: Int = 0
//    val comments: String
        )

object WallService {
    var posts = emptyArray<Post>()

    fun clear() {
        posts = emptyArray()
    }
//    fun add (post: Post) : Post {
//        posts += post
//        return posts.last()
//    }
}

object Comments {
    val comments: String
        get() {
            TODO()
        }
    val commentCount: Int
        get() {
            TODO()
        }

}

object Likes {
    val likes: Int
        get() {
            TODO()
        }

}
