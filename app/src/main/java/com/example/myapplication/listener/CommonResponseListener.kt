package com.example.myapplication.listener

interface CommonResponseListener {
    fun onSuccessResponse(result: String, from: String, code: Int)
    fun onError(msg: String, fromUrl: String)
}