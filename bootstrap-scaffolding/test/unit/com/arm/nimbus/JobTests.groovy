package com.arm.nimbus

import grails.test.mixin.*
import org.junit.*
import groovy.json.JsonSlurper

/**
 */
@TestFor(Job)
@Mock(Job)
class JobTests {

    def parser = new JsonSlurper()
    def jobValid

    @Before
    void setUp()
    {
        jobValid = new Job(jobID: "2136", command: "ls", state: "running")
    }

    @Test
    void save()
    {
        assertNotNull jobValid.save()
    }

    @Test
    void toJson()
    {
        println jobValid.toJson().toString()
        def json = parser.parseText(jobValid.toJson().toString())
        assertEquals jobValid.jobID, json.job.jobID
    }
}
