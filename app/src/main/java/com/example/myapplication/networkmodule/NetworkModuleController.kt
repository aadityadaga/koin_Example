package com.example.myapplication.networkmodule

import org.koin.dsl.module.module


val networkmodule = module {
    factory {
        var stagingUrl = ""
        try {
            stagingUrl = getProperty("staging_url")
        } catch (e: Exception) {
            e.printStackTrace()

        }
        apiclient(stagingUrl)!!

    }


}
val statemodule = module(override = true) {
    factory { StateRepository(get()) } bind StateRepository::class
}



