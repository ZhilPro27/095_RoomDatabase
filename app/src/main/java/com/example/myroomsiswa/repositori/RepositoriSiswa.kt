package com.example.myroomsiswa.repositori

import com.example.myroomsiswa.room.Siswa
import com.example.myroomsiswa.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream() : Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
    // Edit 1: tambah 3 fungsi berikut
    fun getSiswaStream(id: Int): Flow<Siswa>
    suspend fun deleteSiswa(siswa: Siswa)
    suspend fun updateSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
): RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao
        .getAllSiswa()

    override suspend fun insertSiswa(siswa: Siswa) = siswaDao
        .insert(siswa)
    // Edit 2: tambah 3 override berikut
    override fun getSiswaStream(id: Int): Flow<Siswa> = siswaDao.getSiswa(id)
    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)
}