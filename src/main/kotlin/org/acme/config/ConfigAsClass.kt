package org.acme.config

import io.quarkus.arc.config.ConfigProperties

@ConfigProperties(prefix = "custom")
class ConfigAsClass {


    lateinit var data: String
    var sum: Int = 0

}
