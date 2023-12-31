package com.bignerdranch.sandbox

enum class StudentStatus {
    NotEnrolled,
    Active,
    Graduated
}

class Student(var status: StudentStatus)

fun main(){
    val student = Student(StudentStatus.NotEnrolled)

}