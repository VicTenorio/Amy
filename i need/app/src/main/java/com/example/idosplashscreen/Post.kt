package com.example.idosplashscreen

import android.os.AsyncTask
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class Post : AsyncTask<String, String, String>() {
    override fun doInBackground(vararg parts: String): String? {
        val requestURL = parts.first()
        val queryString = parts.last()

        // Set up request
        val connection = URL(requestURL).openConnection() as HttpURLConnection
        // Default is GET so you must override this for post
        connection.requestMethod = "POST"
        // To send a post body, output must be true
        connection.doOutput = true

        // Create the stream
        val outputStream = connection.outputStream as OutputStream
        // Create a writer container to pass the output over the stream
        val outputWriter = OutputStreamWriter(outputStream)
        // Add the string to the writer container
        outputWriter.write(queryString)
        // Send the data
        outputWriter.flush()

        // Create an input stream to read the response
        val inputStream = BufferedReader(InputStreamReader(connection.inputStream)).use {
            // Container for input stream data
            val response = StringBuffer()
            var inputLine = it.readLine()
            // Add each line to the response container
            while (inputLine != null) {
                response.append(inputLine)
                inputLine = it.readLine()
            }
            it.close()
            //println(">>>> Response: ${response}")

            return response.toString()
        }

        //return inputStream.toString()

        connection.disconnect()
    }

    protected fun onProgressUpdate(vararg progress: Int) {
    }

    override fun onPostExecute(result: String?) {

    }


}