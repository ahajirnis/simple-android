package org.simple.clinic.login.applock

import org.junit.Test
import org.simple.clinic.security.BCryptPasswordHasher
import org.simple.clinic.security.ComparisonResult

class BCryptPasswordHasherTest {

  @Test
  fun `comparison test`() {
    val bcryptHasher = BCryptPasswordHasher()

    val password = "12341234"

    bcryptHasher.hash(password)
        .flatMap { bcryptHasher.compare(it, password) }
        .test()
        .assertValue { it == ComparisonResult.SAME }
  }
}
