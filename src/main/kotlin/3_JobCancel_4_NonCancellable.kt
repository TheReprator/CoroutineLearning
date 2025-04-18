package org.example

import kotlinx.coroutines.*

suspend fun main() = coroutineScope {
    type1()
    type2()
}

private suspend fun type1()= coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(2000)
            println("coroutine finished")
        } finally {
            println("finally")
            withContext(NonCancellable) {
                delay(1000L)
                println("cleanup now")
            }
            println("finally 1")
        }
    }

    delay(1000L)
    job.cancelAndJoin()
    println("Cancel done")
}
/*
* NonCancellable(line 18): It is basically a job that cannot be cancelled and is
* active in state. We can call whatever suspending function(19),  we want inside it
* */

private suspend fun type2() = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            delay(2000)
            println("coroutine finished")
        } finally {
            println("finally")
            withContext(NonCancellable) {
                delay(1000L)
                println("cleanup now")
                /*launch {
                    delay(2000L)
                    println("job cancel vikram")
                }*/
                try {
                    coroutineContext[Job]?.cancelAndJoin()
                } catch (e: Exception) {
                    println("job cancelled catch")
                    throw e
                }
            }
            println("finally 1")
        }
    }

    delay(1000L)
    job.cancelAndJoin()
    println("Cancel done")
}

/*
* Once we have suspension(line 48) inside launch builders(line 47) or cancel job(line 52) inside NonCancellable,
* then line no 58 will not be printed in that case
* */