package com.example.demo.cucumber.subresources.utility

import java.util.HashMap
import java.util.Map
import java.lang.Object

object DataStorage {

    var storage: Map<String, String>

    init {
        print("instantiating data storage")
    }

    fun saveTestData(name: String, obj: Object): Unit {
        val key = name.toUpperCase()
        if (storage.containsKey(key)){
            storage.replace(key, obj)
        } else {
            storage.put(key, o);
        }
    }

    fun getTestObject(String name): Object {
        String key = name.toUpperCase();
        if (storage.containsKey(key)) {
            return storage.get(key);
        }
        return null;
    }

    fun emptyTestData(): Unit {
        storage.clear()
    }

}