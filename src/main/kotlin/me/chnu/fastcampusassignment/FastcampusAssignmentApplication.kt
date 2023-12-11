package me.chnu.fastcampusassignment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class FastcampusAssignmentApplication

fun main(args: Array<String>) {
    runApplication<FastcampusAssignmentApplication>(*args)
}