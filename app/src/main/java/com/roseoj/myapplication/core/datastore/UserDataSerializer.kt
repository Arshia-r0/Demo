package com.roseoj.myapplication.core.datastore

import android.util.Log
import androidx.datastore.core.Serializer
import com.roseoj.myapplication.core.model.data.UserData
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream


object UserDataSerializer: Serializer<UserData> {

    override val defaultValue: UserData =
        UserData()

    override suspend fun readFrom(input: InputStream): UserData {
        return try {
            Json.decodeFromString(
                deserializer = UserData.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: Exception) {
            defaultValue.also {
                Log.e("readUserData", e.localizedMessage ?: "error")
            }
        }
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun writeTo(t: UserData, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = UserData.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }

}
