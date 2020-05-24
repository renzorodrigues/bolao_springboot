package com.renzo.bolao.repositories

import com.renzo.bolao.domains.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int>