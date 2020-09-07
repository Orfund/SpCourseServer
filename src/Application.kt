package com.spcourse

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import kotlinx.css.*
import io.ktor.content.*
import io.ktor.http.content.*
import com.google.gson.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


class Student(val id:Int = 0){}
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val jsonBuilder = GsonBuilder()
    val gson = jsonBuilder.create()
    routing {
        get("/") {
            call.respondText(gson.toJson(Student()))
        }
        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("static")
        }
    }
}




