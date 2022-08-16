package ru.netology

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

class Wall {
}