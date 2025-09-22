package com.example.ComposeUiProject.HomeApp.feature.home

import com.example.ComposeUiProject.HomeApp.core.model.PropertyHome


fun sampleProperties(): List<PropertyHome> = listOf(
    PropertyHome(
        type = "Apartment",
        title = "Royal Apartment",
        address = "LosAngles LA",
        pickPath = "pic_1",
        price = 1500,
        bed = 2,
        bath = 3,
        size = 350,
        isGarage = true,
        score = 4.5,
        description = "This 2 bed /1 bath home boasts an enormous, open-living plan..."
    ),
    PropertyHome(
        type = "House",
        title = "House with Great View",
        address = "Newyork NY",
        pickPath = "pic_2",
        price = 800,
        bed = 1,
        bath = 2,
        size = 500,
        isGarage = false,
        score = 4.9,
        description = "This 2 bed /1 bath home boasts an enormous, open-living plan..."
    ),
    PropertyHome(
        type = "Villa",
        title = "Royal Villa",
        address = "LosAngles La",
        pickPath = "pic_3",
        price = 999,
        bed = 2,
        bath = 1,
        size = 400,
        isGarage = true,
        score = 4.7,
        description = "This 2 bed /1 bath home boasts an enormous, open-living plan..."
    ),
    PropertyHome(
        type = "House",
        title = "beauty house",
        address = "Newyork NY",
        pickPath = "pic_4",
        price = 1750,
        bed = 3,
        bath = 2,
        size = 1100,
        isGarage = true,
        score = 4.3,
        description = "This 2 bed /1 bath home boasts an enormous, open-living plan..."
    )
)
