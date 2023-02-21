package crypto

import utils.StringUtils
import java.nio.charset.StandardCharsets
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 *
 * @author Marcelo Daniel
 */
object Crypto {
    private const val KEY = "CHAVE_AQUI"
    fun encrypt(texto: String): String {
        var cipherText = ""
        try {
            val secretKeySpec = SecretKeySpec(KEY.toByteArray(StandardCharsets.UTF_8), "Blowfish")
            val cipher = Cipher.getInstance("Blowfish")
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec)
            cipherText = StringUtils.base64encode(cipher.doFinal(texto.toByteArray(StandardCharsets.UTF_8)))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return cipherText
    }

    fun decrypt(texto: String?): String {
        var dectyptedText: ByteArray? = null
        try {
            val secretKeySpec = SecretKeySpec(KEY.toByteArray(StandardCharsets.UTF_8), "Blowfish")
            val cipher = Cipher.getInstance("Blowfish")
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)
            dectyptedText = cipher.doFinal(StringUtils.base64decodeToByte(texto))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return String(dectyptedText!!).trim { it <= ' ' }
    }
}