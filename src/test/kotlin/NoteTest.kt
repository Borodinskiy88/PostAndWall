package ru.netology

import org.junit.Before

class NoteTest {

    @Before
    fun clearBeforeNoteTest() {
        NoteService.clear()
    }
}