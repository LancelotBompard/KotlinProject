package bompard.lancelot.iimdemo.model

import java.io.Serializable

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val website: String,
    val address: Address,
    val company: Company
) : Serializable