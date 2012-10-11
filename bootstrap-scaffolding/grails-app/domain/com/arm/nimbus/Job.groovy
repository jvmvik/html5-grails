package com.arm.nimbus

import groovy.json.JsonBuilder

/*
 * Represent a running job on the cluster.
 */	
class Job
{

	String jobID
	String command
	String state

    static hasMany = [taskConfig: TaskConfig]

    def toJson()
    {
        def json = new JsonBuilder()
        json.job {
            jobID jobID
            command command
            state state
        }
        return json
    }

	static constraints =
    {
        jobID(blank:false)
        command(blank:false)
        state(blank:false)
    }
}
