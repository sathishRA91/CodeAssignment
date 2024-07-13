package com.sathish.codeassignment.util

/**
 * Created by sathish on 12,July,2024
 */
sealed class ResultResource <out T>(val data:T?=null, val message:String?=null)
{
    class Success<T>(data: T?=null):ResultResource<T>(data)

    class ErrorMessage<T>(message: String?,data: T?=null):ResultResource<T>(data,message)

}
