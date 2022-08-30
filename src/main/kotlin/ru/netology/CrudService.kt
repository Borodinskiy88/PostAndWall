package ru.netology

//class Item (val id: Int)

interface CrudService<A, B> {   //A - Post/Notes, B - Comment

    fun add(elem: A) : A

    fun update(elem: A) : Boolean

    fun createComment(id: Int, elem: B) : B

    fun lastComment() : B
}