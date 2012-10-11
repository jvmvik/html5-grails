package com.arm.nimbus

import groovy.json.JsonBuilder

class ApplicationController {

    def jobService

    def index()
	{
        [jobs: Job.findAll()]
	}

    def bench()
    {
      def t1 = System.currentTimeMillis()

      // Find all job
      def jobs = jobService.listAll()

      def t2 = System.currentTimeMillis()
      println "${t2 - t1} ms to retrieve ${jobs.size()} jobs"

      // Convert to JSON
      def array = []
      jobs.each { Job j ->
            array.add j.toJson()
      }

      def t3 = System.currentTimeMillis()
      println  "${(t3-t2)} ms to encode as json"

      render(text: array.toString())
      def t4 = System.currentTimeMillis()
      println "${t4-t3} ms to display"
    }
	
	def success()
	{
		render(contentType:"text/json") {
		        msg = "Welcome to this applicaiton"
		}
	}
}
