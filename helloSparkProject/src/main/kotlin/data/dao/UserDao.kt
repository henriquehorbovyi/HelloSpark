package data.dao

import data.entity.User
import java.util.concurrent.atomic.AtomicInteger

class UserDao {

    private val users = hashMapOf(
            1 to User(1, "Carlos Henrique", "carlos@gmail.com"),
            2 to User(2, "Iryna Ivanivna", "ira@gmail.com"),
            3 to User(3, "Carlos Bernardo", "Carlos Bernardo")
    )
    private var lastId: AtomicInteger = AtomicInteger(users.count())

    fun save(name: String, email: String){
        val id = lastId.incrementAndGet()
        val user = User(id, name, email)
        users[id] = user
    }
    fun all() = users

    fun findById(id: Int): User?{
        return users[id] as User?
    }

    fun findByEmail(email: String): User?{
        return users.values.find { it.email == email}
    }

    fun update(id: Int, name: String, email: String) {
        users[id] = User(id, name, email)
    }

    fun delete(id: Int) {
        users.remove(id)
    }
}