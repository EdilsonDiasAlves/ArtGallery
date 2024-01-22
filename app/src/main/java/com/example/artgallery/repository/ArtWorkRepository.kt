package com.example.artgallery.repository

import android.content.Context
import com.example.artgallery.R
import com.example.artgallery.model.ArtWork

class ArtWorkRepository(context: Context) {
    val artWorks: List<ArtWork> = listOf(
        ArtWork(
            title = context.getString(R.string.image1_title),
            description = context.getString(R.string.image1_description),
            author = context.getString(R.string.image1_author),
            year = context.getString(R.string.image1_year),
            imageResId = R.drawable.image1
        ),
        ArtWork(
            title = context.getString(R.string.image2_title),
            description = context.getString(R.string.image2_description),
            author = context.getString(R.string.image2_author),
            year = context.getString(R.string.image2_year),
            imageResId = R.drawable.image2
        ),
        ArtWork(
            title = context.getString(R.string.image3_title),
            description = context.getString(R.string.image3_description),
            author = context.getString(R.string.image3_author),
            year = context.getString(R.string.image3_year),
            imageResId = R.drawable.image3
        ),
        ArtWork(
            title = context.getString(R.string.image4_title),
            description = context.getString(R.string.image4_description),
            author = context.getString(R.string.image4_author),
            year = context.getString(R.string.image4_year),
            imageResId = R.drawable.image4
        ),
        ArtWork(
            title = context.getString(R.string.image5_title),
            description = context.getString(R.string.image5_description),
            author = context.getString(R.string.image5_author),
            year = context.getString(R.string.image5_year),
            imageResId = R.drawable.image5
        ),
        ArtWork(
            title = context.getString(R.string.image6_title),
            description = context.getString(R.string.image6_description),
            author = context.getString(R.string.image6_author),
            year = context.getString(R.string.image6_year),
            imageResId = R.drawable.image6
        ),
        ArtWork(
            title = context.getString(R.string.image7_title),
            description = context.getString(R.string.image7_description),
            author = context.getString(R.string.image7_author),
            year = context.getString(R.string.image7_year),
            imageResId = R.drawable.image7
        )
    )
}