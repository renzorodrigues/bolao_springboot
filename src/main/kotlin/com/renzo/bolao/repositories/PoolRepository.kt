package com.renzo.bolao.repositories

import com.renzo.bolao.domains.Pool
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PoolRepository : JpaRepository<Pool, Int>