package com.example.vespatype

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vespa(
    val name: String,
    val description: String,
    val photo:  Int
) : Parcelable
