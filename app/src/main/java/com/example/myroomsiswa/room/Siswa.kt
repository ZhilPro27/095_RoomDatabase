package com.example.myroomsiswa.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tblSiswa")
data class Siswa(
    @PrimaryKey(true)
    val id : Int = 0,
    val nama : String,
    val alamat : String,
    val telepon : String
)
