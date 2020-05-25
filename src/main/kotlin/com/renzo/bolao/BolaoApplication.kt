package com.renzo.bolao

import com.renzo.bolao.domains.Group
import com.renzo.bolao.domains.Member
import com.renzo.bolao.repositories.GroupRepository
import com.renzo.bolao.repositories.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BolaoApplication @Autowired constructor(
		private val repoMember: MemberRepository,
		private val repoGroup: GroupRepository
): CommandLineRunner {
	override fun run(vararg args: String?) {

		val member1: Member = Member(null, "Renzo", "renzo@mail.com")
		val member2: Member = Member(null, "Julianna", "ju@mail.com")
		val member3: Member = Member(null, "Pedro", "pedro@mail.com")

		val group1: Group = Group(null, "Grupo do bolão", 10, member1)
		val group2: Group = Group(null, "Grupo dos sortudos", 5, member1)

		group1.members = listOf<Member>(member1, member2, member3)
		group2.members = listOf<Member>(member1, member3)

		repoMember.saveAll(listOf(member1, member2, member3))
		repoGroup.saveAll(listOf(group1, group2))

	}
}

fun main(args: Array<String>) {
	runApplication<BolaoApplication>(*args)
}
