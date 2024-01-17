package edu.uw.basickotlin

// write a "whenFn" that takes an arg of type "Any" and returns a String

fun whenFn(arg: Any): String {
    when(arg) {
        is String -> {
            when(arg) {
                "Hello" -> return "world"
                else -> {
                    return "Say what?"
                }
            }
        }
        is Int -> {
            when(arg){
                0 -> return "zero"
                1 -> return "one"
                in 2..10 -> return "low number"
                else -> {
                    return "a number"
                }
            }
        }
        else -> {
            return "I don't understand"
        }
    }
}

// write an "add" function that takes two Ints, returns an Int, and adds the values

fun add(lhs: Int, rhs: Int): Int {
    return lhs + rhs
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values

fun sub(lhs: Int, rhs: Int): Int {
    return lhs - rhs
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments

fun mathOp(lhs: Int, rhs: Int, op: (Int, Int) -> Int): Int {
    return op(lhs, rhs)
}

// write a class "Person" with first name, last name and age

class Person(var firstName: String, var lastName: String, var age: Int) {
   val debugString = "[Person firstName:$firstName lastName:$lastName age:$age]"
}

// write a class "Money"

class Money(val amount: Int, val currency: String) {
    init {
        if (amount < 0) {
            throw IllegalArgumentException("Amount cannot be negative")
        }
        if (currency !in listOf("USD", "GBP", "CAN", "EUR")) {
            throw IllegalArgumentException("Unrecognized currency")
        }
    }
    fun convert(convertTo: String): Money {
        var newAmount = this.amount
        when (currency) {
            "GBP" -> newAmount = newAmount * 2
            "EUR" -> newAmount = (newAmount * 2) / 3
            "CAN" -> newAmount = (newAmount * 4) / 5
        }
        when (convertTo) {
            "GBP" -> newAmount = newAmount / 2
            "EUR" -> newAmount = newAmount * 3 / 2
            "CAN" -> newAmount = newAmount * 5 / 4
        }
        return Money(newAmount, convertTo)
    }

    operator fun plus(other: Money): Money {
        if (other.currency != this.currency) {
            var converted = other.convert(this.currency).amount
            return Money(this.amount + converted, this.currency)
        } else {
            return Money(this.amount + other.amount, this.currency)
        }
    }
}
