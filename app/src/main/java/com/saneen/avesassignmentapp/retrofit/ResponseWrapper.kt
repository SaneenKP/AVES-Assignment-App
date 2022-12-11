package com.saneen.avesassignmentapp.retrofit

import com.saneen.avesassignmentapp.utils.Constants

/**
 * A simple wrapper class to hold the state of response obtained from api calls.
 */
data class ResponseWrapper<out T>(val status : Constants.Status, val data : T?, val message : String?){

    companion object{
        fun <T> success(data: T): ResponseWrapper<T> = ResponseWrapper(status = Constants.Status.SUCCESS , data = data , message = null)
        fun <T> error(message: String): ResponseWrapper<T> = ResponseWrapper(status = Constants.Status.ERROR , data = null , message = message)
        fun <T> loading(): ResponseWrapper<T> = ResponseWrapper(status = Constants.Status.LOADING , data = null , message = null)
    }



}