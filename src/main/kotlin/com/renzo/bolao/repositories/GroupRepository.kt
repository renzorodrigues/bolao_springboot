package com.renzo.bolao.repositories

import com.renzo.bolao.domains.Group
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GroupRepository : JpaRepository<Group, Int>