package com.example.android_example

import com.example.android_example.data.network.NetworkDataSource
import com.example.android_example.data.network.NetworkModule
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `check get popular movies`() {

        val module = NetworkModule()
        val moviesApi = module.provideNytAPI(module.provideRetrofit())
        val networkDataSource = NetworkDataSource(moviesApi)

        runBlocking {
            val results = networkDataSource.getMovies()?.results?.get(0)
            println(results)
            assertNotNull(results)
        }
    }
}