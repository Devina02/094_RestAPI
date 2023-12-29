package com.example.pam9.repository

import com.example.pam9.model.Kontak
import com.example.pam9.service_api.KontakService
import java.io.IOException

interface KontakRepository {
    /** Fetches list of kontak from kontakApi */
    suspend fun getKontak(): List<Kontak>

    suspend fun insertKontak(kontak: Kontak)

    suspend fun updatekontak(id: Int, kontak: Kontak)

    suspend fun deletekontak(id: Int)

    suspend fun getkontakById(id: Int): Kontak


}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository{
    /** Fetches list of kontak from kontakApi*/
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()

    override suspend fun insertKontak(kontak: Kontak) {
        kontakApiService.insertKontak(kontak)
    }

    override suspend fun updatekontak(id: Int, kontak: Kontak) {
        kontakApiService.updateKontak(id, kontak)
    }

    override suspend fun deletekontak(id: Int) {
        try {
            val response = kontakApiService.deletekontak(id)
            if (!response.isSuccessful){
                throw IOException("Faildes to delete kontak. HTTP status code:" + "${response.code()}")
            }
            else{
                response.message()
                println(response.message())
            }
        }
        catch (e:Exception){
            throw e
        }
    }
    override suspend fun getkontakById(id: Int): Kontak {
        return kontakApiService.getKontakById(id)
    }
}