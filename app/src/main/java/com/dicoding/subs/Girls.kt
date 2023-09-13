package com.dicoding.subs

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Girls(
    val name: String,
    val description:String,
    val photo: Int
) : Parcelable