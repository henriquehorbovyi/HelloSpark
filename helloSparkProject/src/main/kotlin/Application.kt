import controller.UserController
import data.dao.UserDao
import spark.Spark.*
import spark.kotlin.get
import util.JsonConverter
import util.Paths


fun main(args: Array<String>) {
    port(8080)

    val userDao = UserDao()
    val userController = UserController(userDao)

    path(Paths.LIST_USERS){
        get("", userController.fetchAllUsers)
        get(Paths.FIND_BY_ID){
            val user = userDao.findById(request.params("id").toInt())
            JsonConverter().render(user)
        }

        post(Paths.CREATE_USER){ request, response ->
            val userName = request.queryParams("name")
            val userEmail = request.queryParams("email")
            userDao.save(userName, userEmail)
            response.status(200)
            JsonConverter().render("user created!")
        }

        delete(Paths.DELETE_USER) { request, _ ->
            userDao.delete(request.params("id").toInt())
            "user deleted!"
        }
    }
}

