package com.example.idosplashscreen

import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

class Http {

    fun get(){

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
/*
    fun post(query:String):String{
        val serverURL = "http://10.0.2.2:3000/usuario/login"
        val url = URL(serverURL)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.connectTimeout = 300000
        connection.connectTimeout = 300000
        connection.doOutput = true

        val postData: ByteArray = query.toByteArray(StandardCharsets.UTF_8)

        connection.setRequestProperty("charset", "utf-8")
        connection.setRequestProperty("Content-lenght", postData.size.toString())
        //connection.setRequestProperty("Content-Type", "application/json")

        try {
            val outputStream: DataOutputStream = DataOutputStream(connection.outputStream)
            outputStream.write(postData)
            outputStream.flush()
        } catch (exception: Exception) {

        }
        val response = StringBuffer()
        //if (connection.responseCode != HttpURLConnection.HTTP_OK && connection.responseCode != HttpURLConnection.HTTP_CREATED) {
            try {

                // Create an input stream to read the response
                BufferedReader(InputStreamReader(connection.inputStream)).use {

                    var inputLine = it.readLine()

                    // Add each line to the response container
                    while (inputLine != null) {
                        response.append(inputLine)
                        inputLine = it.readLine()
                    }
                    it.close()
                    println("resposta: "+response)
                }

            } catch (exception: Exception) {
                print("erro ${exception}")
            }
        //}
        return response.toString()
    }*/

}