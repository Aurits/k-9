package com.fsck.k9

data class AppConfig(
    val componentsToDisable: List<Class<*>>,
) {
    companion object {
        var password: String = ""
    }
}


