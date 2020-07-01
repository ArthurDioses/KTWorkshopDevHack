package com.example.ktworshopdevhack.worshop_kt_dev_hack

import kotlin.math.absoluteValue
import kotlin.math.roundToInt


val question = Array(3) {
    ""
}
val answer = Array(3) {
    ""
}
val correctAnswer = Array(3) {
    0
}

fun initQuestions() {
    question[0] = "Tu nombre?"
    question[1] = "Tu apellido paterno?"
    question[2] = "Tu apellido materno?"
}

fun initAnswer() {
    answer[0] = "1. Arthur | 2.Nada | 3.Naka"
    answer[1] = "1. Arthur | 2.Dioses | 3.Naka"
    answer[2] = "1. Arthur | 2.Nada | 3.Reto"
}

fun initCorrectAnswers() {
    correctAnswer[0] = 1
    correctAnswer[1] = 2
    correctAnswer[2] = 3
}

fun printQuestionAndAnswer(question: String, answer: String): Int {
    println(question)
    println(answer)
    return readLine()?.toInt() ?: 0
}

fun createQuestions( userName: String): ArrayList<Int> {
    val userAnswers = ArrayList<Int>()
    for ((index, question) in question.withIndex()) {
        userAnswers.add(printQuestionAndAnswer(question, answer[index]))
    }
    return userAnswers
}

fun requestName(): String {

    println("Por favor digita tu nombre")
    return readLine() ?: ""
}

fun getCorrectAnswerCount(userAnswer: List<Int>) =

    userAnswer.filterIndexed { index, answer ->
        answer == correctAnswer[index]
    }.count()

fun getInCorrectAnswerCount(userAnswer: List<Int>) =
    (getCorrectAnswerCount(userAnswer) - userAnswer.size).absoluteValue

fun calculateScore(userCorrectAnswers: Int, totalQuestions: Int) =
    (userCorrectAnswers.toDouble().div(totalQuestions.toDouble() * 100)).roundToInt()

fun main() {
    initCorrectAnswers()
    initAnswer()
    initQuestions()
    val userName = requestName()
    println("Bienvenido $userName por favor responde el siguiente test")

    val userAnswer = createQuestions(userName)
    val userCorrectAnswers = getCorrectAnswerCount(userAnswer)
    val userIncorrectAnswers = getInCorrectAnswerCount(userAnswer)
    val userScore = calculateScore(userCorrectAnswers, userAnswer.size)

    println("Correctos=>$userCorrectAnswers")
    println("Inrrectos=>$userIncorrectAnswers")
    println("Total=>$userScore")
}