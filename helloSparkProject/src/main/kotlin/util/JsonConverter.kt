package util

import com.google.gson.Gson
import spark.ResponseTransformer

class JsonConverter : ResponseTransformer {
    private val gson = Gson()
    override fun render(obj: Any?): String {
        return gson.toJson(obj)
    }
}