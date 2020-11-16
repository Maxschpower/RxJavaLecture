package com.maxsch.rxjavalecture.entities

interface Animal {
    val name: String
    val age: String

    fun voice(): String
}