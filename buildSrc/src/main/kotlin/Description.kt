object Description {
    
    private const val versionNameBase = "1.0.0" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    private const val versionNameSuffix = "MA-625-remove-voir-plus"

    const val versionCode = 1
    const val groups = "dev-group"
    const val currentEnvironment = "qa"
    
    
    val versionName: String
        get() = if (versionNameSuffix.isBlank()) {
            versionNameBase
        } else {
            "${versionNameBase}-${versionNameSuffix}"
        }
}