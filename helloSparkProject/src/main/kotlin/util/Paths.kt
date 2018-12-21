package util

class Paths{
    companion object{
        const val LIST_USERS = "/users"
        const val FIND_BY_ID = "/:id"
        const val CREATE_USER = "$LIST_USERS/create"
        const val DELETE_USER = "/delete/:id"
    }
}