package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    runBlocking {
        delay(1000L)
        println("World!")
    }
    runBlocking {
        delay(1000L)
        println("1 World!")
    }

    runBlocking {
        delay(1000L)
        println("2 World!")
    }

    runBlocking {
        delay(1000L)
        println("3 World!")
    }

    println("Hello!")
}