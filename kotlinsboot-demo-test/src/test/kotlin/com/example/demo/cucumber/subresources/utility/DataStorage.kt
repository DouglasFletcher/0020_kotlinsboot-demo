package com.example.demo.cucumber.subresources.utility

object DataStorage {

    private var storage: MutableMap<String, Any> = mutableMapOf<String, Any>()

    init {
        print("instantiating data storage")
    }

    fun saveTestData(name: String, obj: Any): Unit {
        val key = name.toUpperCase()
        if (storage.containsKey(key)){
            storage.replace(key, obj)
        } else {
            storage.put(key, obj);
        }
    }

    fun getTestData(name: String): Object {
        val key = name.toUpperCase()
        return storage.get(key) as Object
    }

    fun emptyTestData(): Unit {
        storage.clear()
    }

}