package ge.neirondev.makeup

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform