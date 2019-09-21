package com.example.demo.cucumber.subresources.testObjects

class UserTO(user: MutableMap<String, String>){
    var id: String? = null
    var username: String = ""
    var firstname: String = ""
    var lastname: String = ""
    var description: String? = null

    init {
        if(user.containsKey("id")){
            id = user["id"] as String
        }
        if(user.containsKey("username")){
            username = user["username"] as String
        }
        if(user.containsKey("firstname")){
            firstname = user["firstname"] as String
        }
        if(user.containsKey("lastname")){
            lastname = user["lastname"] as String
        }
        if(user.containsKey("description")){
            description = user["description"] as String
        }
    }

    override fun toString(): String {
        return String.format(
            "username: %s, \n" +
            "firstname: %s \n" +
            "lastname: %s \n" +
            "description: %s \n",
            username, firstname, lastname, description
        )
    }
}
