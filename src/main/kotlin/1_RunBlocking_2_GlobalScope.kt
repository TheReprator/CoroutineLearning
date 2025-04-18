package org.example

import kotlinx.coroutines.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {

        GlobalScope.launch {
                delay(1000L)
                println("World!")
        }

        GlobalScope.launch {
                delay(1000L)
                println("1 World!")
        }

        GlobalScope.launch {
                delay(1000L)
                println("2 World!")
        }

        GlobalScope.launch {
                delay(1000L)
                println("3 World!")
        }

        println("Hello!")
        delay(2000L)
}