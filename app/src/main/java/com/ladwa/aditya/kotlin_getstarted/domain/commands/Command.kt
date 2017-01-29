package com.ladwa.aditya.kotlin_getstarted.domain.commands

/**
 * Created by Aditya on 20-Jan-17.
 */
public interface Command<T> {
    fun execute(): T
}