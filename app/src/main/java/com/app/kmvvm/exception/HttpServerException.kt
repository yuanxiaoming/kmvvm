package com.app.kmvvm.exception

class HttpServerException(val code: String, message: String) : Exception(message) {
}