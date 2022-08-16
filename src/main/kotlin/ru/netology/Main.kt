package ru.netology

/*
Наконец мы добрались до ООП и можем уже не только решать вычислительные задачи,
но и моделировать целые системы.

На лекции мы разобрали упрощённый пример того, как может выглядеть пост,
давайте же посмотрим на то, как он выглядит на самом деле.
Возьмите себе за правило анализировать системы, с которыми вы работаете в реальной жизни,
и продумывать, как бы сделали вы.

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
class Main {
}