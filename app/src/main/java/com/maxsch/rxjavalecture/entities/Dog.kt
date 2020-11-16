package com.maxsch.rxjavalecture.entities

data class Dog(override val name: String, override val age: String) : Animal {

    override fun voice(): String = "I'm $name, and I'm $age years old"
}