package com.jordanmadrigal.marvelapp.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jordanmadrigal.marvelapp.data.Comic
import kotlinx.coroutines.flow.Flow

@Dao
interface ComicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComic(comic: Comic): Long

    @Query("SELECT * FROM comic_table where comic_id = :comicId")
    fun getComic(comicId: String): Flow<Comic>
}