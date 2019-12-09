package com.example.idosplashscreen.Model

import java.io.*
import java.net.HttpURLConnection
import java.net.URL

class Http {

    fun get(vararg parts: String):String{
        var requestURL = parts.first()
        val mURL = URL(requestURL)

        with(mURL.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "GET"

            println("URL : $url")
            println("Response Code : $responseCode")

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()

                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                it.close()
                //println("Response : $response")

                return response.toString()
            }
        }

    }

    fun post(vararg parts: String):String?{
        //var requestURL ="http://10.0.2.2:3000/usuario/login"
        var requestURL = parts.first()
        var queryString = parts.last()

        // Set up request
        var connection = URL(requestURL).openConnection() as HttpURLConnection

        print("url:${requestURL}\n query:${queryString}\n ")

        // Default is GET so you must override this for post
        connection.requestMethod = "POST"
        // To send a post body, output must be true
        connection.doOutput = true

        //print("query>>>>>"+queryString)

        connection.setRequestProperty("charset", "utf-8")
        //connection.setRequestProperty("Content-lenght", postData.size.toString())
        connection.setRequestProperty("Content-Type", "application/json")


        // Create the stream
        //var outputStream = connection.outputStream as OutputStream
        // Create a writer container to pass the output over the stream
        var outputStream:OutputStream = connection.outputStream

        var outputWriter = OutputStreamWriter(outputStream)
        // Add the string to the writer container
        outputWriter.write(queryString)
        // Send the data
        outputWriter.flush()

        // Container for input stream data
        var response = StringBuffer()

        // Create an input stream to read the response
        BufferedReader(InputStreamReader(connection.inputStream)).use {

            var inputLine = it.readLine()

            // Add each line to the response container
            while (inputLine != null) {
                response.append(inputLine)
                inputLine = it.readLine()
            }
            it.close()
        }

        return response.toString()
    }
}