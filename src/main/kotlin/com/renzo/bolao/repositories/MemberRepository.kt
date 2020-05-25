package com.renzo.bolao.repositories

import com.renzo.bolao.domains.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Int>