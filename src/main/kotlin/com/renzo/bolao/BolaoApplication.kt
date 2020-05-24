package com.renzo.bolao

import com.renzo.bolao.domains.Group
import com.renzo.bolao.domains.User
import com.renzo.bolao.repositories.GroupRepository
import com.renzo.bolao.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BolaoApplication @Autowired constructor(
		private val repoUser: UserRepository,
		private val repoGroup: GroupRepository
): CommandLineRunner {
	override fun run(vararg args: String?) {

		val group1: Group = Group(null, "Grupo do bolão")
		val group2: Group = Group(null, "Grupo dos sortudos")

		val user1: User = User(null, "Renzo", "renzo@mail.com")
		val user2: User = User(null, "Julianna", "ju@mail.com")
		val user3: User = User(null, "Pedro", "pedro@mail.com")

		group1.users = listOf<User>(user1, user2, user3)
		group2.users = listOf<User>(user1, user3)

		repoUser.saveAll(listOf(user1, user2, user3))
		repoGroup.saveAll(listOf(group1, group2))

	}
}

fun main(args: Array<String>) {
	runApplication<BolaoApplication>(*args)
}
