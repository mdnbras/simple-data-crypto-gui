package utils

import java.nio.charset.StandardCharsets
import java.util.*

object StringUtils {
    fun base64encode(data: String): String {
        return Base64.getEncoder().encodeToString(data.toByteArray(StandardCharsets.UTF_8))
    }

    fun base64encode(data: ByteArray?): String {
        return Base64.getEncoder().encodeToString(data)
    }

    fun base64decode(dataEncoded: ByteArray?): ByteArray {
        return Base64.getDecoder().decode(dataEncoded)
    }

    fun base64decodeToByte(dataEncoded: String?): ByteArray {
        return Base64.getDecoder().decode(dataEncoded)
    }

    fun base64decode(dataEncoded: String): String {
        return Base64.getDecoder().decode(dataEncoded.toByteArray(StandardCharsets.UTF_8)).toString()
    }
}