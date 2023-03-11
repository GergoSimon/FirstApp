package com.example.firstapp

data class User(val name: Name, val email: String, val picture: Picture, val cell: String, val location: Location)

data class Name(val first: String, val last: String)

data class Picture(val large: String)

data class Location(val street: Street, val city: String, val state: String, val country: String)

data class Street(val number: String, val name: String)