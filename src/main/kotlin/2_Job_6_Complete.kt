package org.example

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val job1 = Job()
    launch(job1) {
        repeat(3) {
            delay(500)
            println("Rep: $it")
        }
    }

    launch {
        delay(200)
        println("complete job will be called")
        job1.complete()
        println("complete job is already called")
    }

    job1.join()
    launch(job1) {
        println("will not execute, as job is already completed!")
    }

    //
    fun main(args: Array<String>){}
}
/*
* Once the job is complete(or cancelled), it can't be used for any purpose.
* Once coroutine receive the complete order(line 20), it just wait for completion of all this child to complete, its all pending job or task and
* refrain from taking any further order(line no 25)
* */