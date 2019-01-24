package br.com.onboardingspring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BookAplication

fun main() {
    SpringApplication.run(BookAplication::class.java)
}

//class BookAplication{
////    companion object {
////        @JvmStatic
////        fun main(args: Array<String>){
////            SpringApplication.run(BookAplication::class.java)
////        }
////    }
//
//
//}