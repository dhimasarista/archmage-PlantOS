package id.archmage

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform