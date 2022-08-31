package ru.netology

interface CrudService<A, B> {

    fun add(elem: A): A

    fun update(elem: A): Boolean

    fun createComment(id: Int, elem: B): B

    fun lastComment(): B
}