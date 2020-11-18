package com.example.navigation.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RandomData(
    var data: String = "Some random data"
) : Parcelable