package derchain.aymeric.iimdemo.model

import java.io.Serializable

data class Comment(
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
) : Serializable