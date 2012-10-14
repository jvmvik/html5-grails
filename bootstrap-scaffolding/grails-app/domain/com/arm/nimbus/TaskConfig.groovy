package com.arm.nimbus

import groovy.json.JsonBuilder

/**
 * Describe task configuration
 */
class TaskConfig 
{

	String name
	String lsf
	String module

    Product product

	def toJson()
    {
        def json = new JsonBuilder()
        json.taskConfig
        {
            name name
            lsf lsf
            module module
        }
        return json
    }

	static constraints =
    {
        module(blank:false)
        name(blank:false)
        lsf(blank:false)
        product(nullable:true)
    }
}
