package com.jackshi.androidx_kotlin

class MessageEvent {
    var type: Int
    var flag: Boolean = false
    var position = 0

    constructor(type: Int, flag: Boolean) {
        this.type = type
        this.flag = flag
    }

    constructor(type: Int, position: Int) {
        this.type = type
        this.position = position
    }
}