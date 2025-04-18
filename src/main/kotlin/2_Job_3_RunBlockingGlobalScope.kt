package org.example

import kotlinx.coroutines.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {

        val job = GlobalScope.launch {
                delay(1000L)
                println("World!")
        }

        val job2 = GlobalScope.launch {
                delay(3000L)
                println("3 World!")
        }

        println("Hello!")
        job2.join()
        job.join()
        println("Hello! after job")
}