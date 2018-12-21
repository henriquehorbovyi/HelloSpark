package controller

import data.dao.UserDao
import spark.Request
import spark.Response
import util.JsonConverter

class UserController(userDao: UserDao){

    val fetchAllUsers  = { request: Request, response: Response ->
        JsonConverter().render(userDao.all())
    }
}