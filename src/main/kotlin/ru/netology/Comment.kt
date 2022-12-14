package ru.netology

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut,
    val replyToUser: Int? = 0,
    val replyToComment: Int? = 0,
    val attachment: Array<Attachment> = emptyArray(),
    val parentsStack: Array<Int> = emptyArray(),
    val thread: Thread


)

data class Donut(
    val isDon: Boolean = false,
    val placeholder: String?
)

data class Thread(
    val id: Int,
    val items: Array<String> = emptyArray(),
    val canPost: Boolean = true,
    val showReplyButton: Boolean = true,
    val groupsCanPost: Boolean = false

)

data class ReportComment(
    val ownerId: Int,
    val commentId: Int,
    val reason: Int
)