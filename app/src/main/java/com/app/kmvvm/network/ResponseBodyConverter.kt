package com.app.kmvvm.network

import com.app.kmvvm.exception.HttpServerException
import com.framework.mvvm.network.converter.BaseResponseBodyConverter
import com.framework.mvvm.network.data.IResponseData
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlin.reflect.KClass

class ResponseBodyConverter :
        BaseResponseBodyConverter() {
    override var json: Json = Json {
        ignoreUnknownKeys = true
    }

    override fun getResultClass(): KClass<out IResponseData<JsonElement>> {
        return Result::class
    }

    override fun handlerErrorCode(errorCode: String, msg: String): Exception {
        return HttpServerException(errorCode,msg)
    }
}