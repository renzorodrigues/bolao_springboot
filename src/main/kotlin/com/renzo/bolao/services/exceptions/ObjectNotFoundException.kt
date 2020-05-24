package com.renzo.bolao.services.exceptions

import java.lang.RuntimeException

class ObjectNotFoundException : RuntimeException {
    constructor(message: String) : super(message) {}
    constructor(message: String, cause: Throwable) : super(message, cause) {}
}