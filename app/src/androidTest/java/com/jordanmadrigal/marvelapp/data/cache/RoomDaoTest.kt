package com.jordanmadrigal.marvelapp.data.cache

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.jordanmadrigal.marvelapp.data.model.Comic
import com.jordanmadrigal.marvelapp.data.model.Thumbnail
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class RoomDaoTest {

    private lateinit var database: ComicDatabase
    private lateinit var dao: ComicDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ComicDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.getComicDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun insertAndReadComic() = runBlocking{

        val testTitle = "Test title"

        dao.insertComic(Comic(1234, "Test title", "Test description", Thumbnail("Test","jpg")))

        val comic = dao.getComic(1234).take(1).toList()

        Truth.assertThat(testTitle).isEqualTo(comic[0].comicTitle)
    }
}