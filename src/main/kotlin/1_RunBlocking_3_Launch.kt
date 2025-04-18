package org.example

import kotlinx.coroutines.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() = runBlocking {

        launch {
                delay(1000L)
                println("World!")
        }

        launch {
                delay(1000L)
                println("1 World!")
        }

        launch {
                delay(3000L)
                println("2 World!")
        }

        launch {
                delay(1000L)
                println("3 World!")
        }

        println("Hello!")
}