package ru.netology

fun main() {
    val post = Post(
        1, 1, 1, 10, "Hello!", " ",
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

/*
Теперь нужно разобраться с функциональностью сервиса,
отвечающего за стены пользователей: https://vk.com/dev/wall (копия).

Нас будут интересовать следующие методы:

Создание записи.
Обновление записи.

Создание записи
Итак, поехали, метод для создания записи должен выглядеть вот так:

    fun add(post: Post): Post {
        TODO()
    }
Как он должен работать:

Он должен добавлять запись в массив,
но при этом назначать посту уникальный среди всех постов идентификатор.
Возвращать пост с уже выставленным идентификатором.
Подсказка
Возможно, вам стоит завести private переменную для хранения следующего уникального id.
Пока у нас in-memory система — всё хранится в оперативной памяти,
и всё работает на одной машине, этого будет достаточно.

Обновление записи
Метод для создания записи должен выглядеть вот так:

    fun update(post: Post): Boolean {
        TODO()
    }
Как он должен работать:

Он должен находить среди всех постов запись с тем же id,
что и у post и обновлять все свойства, кроме id владельца и даты создания.
Если пост с таким id не найден, то ничего не происходит и возвращается false,
в противном случае - возвращается true.
 */
object WallService {
    private var posts = emptyArray<Post>()
    private var id = 0


    fun add(post: Post): Post {
        posts += post.copy(id = id)
        id ++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(ownerId = post.ownerId, date = post.date)
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






