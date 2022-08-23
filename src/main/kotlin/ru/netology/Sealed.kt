//package ru.netology
//
//sealed class Attachment(val type: String)
//
//data class VideoAttachment(val video: Video) : Attachment("video")
//
//data class AudioAttachment(val audio: Audio) : Attachment("audio")
//
//data class NoteAttachment(val note: Note) : Attachment("note")
//
//data class EventAttachment(val event: Event) : Attachment("event")
//
//data class PostedPhotoAttachment(val postedPhoto: PostedPhoto) : Attachment("postedPhoto")
//
//data class Audio(
//    val id: Int,
//    val ownerId: Int,
//    val artist: String,
//    val title: String,
//    val duration: Int,
//    val url: String,
//    val lyricsId: Int,
//    val albumId: Int,
//    val genreId: Int,
//    val date: Int,
//    val noSearch: Boolean,
//    val isHq: Boolean
//)
//
//data class Note(
//    val id: Int,
//    val ownerId: Int,
//    val title: String,
//    val text: String,
//    val date: Int,
//    val comments: Int,
//    val readComments: Int,
//    val viewUrl: String
//)
//
//data class Video(
//    val vId: Int,
//    val ownerId: Int,
//    val title: String,
//    val description: String,
//    val duration: Int,
//    val link: String,
//    val image: String,
//    val imageMedium: String,
//    val date: Int,
//    val player: String
//)
//
//data class PostedPhoto(
//    val id: Int,
//    val ownerId: Int,
//    val photo130: String = "130",
//    val photo604: String = "604"
//)
//data class Event(
//    val id: Int,
//    val time: Int,
//    val memberStatus: Int = 2,
//    val isFavorite: Boolean = false,
//    val address: String,
//    val text: String,
//    val buttonText: String,
//    val friends: Int
//)