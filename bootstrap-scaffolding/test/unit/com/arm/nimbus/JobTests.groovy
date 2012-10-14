package com.arm.nimbus

import grails.test.mixin.*
import org.junit.*
import groovy.json.JsonSlurper

/**
 */
@TestFor(Job)
@Mock([Job, TaskConfig, Product])
class JobTests {

    def parser = new JsonSlurper()
    def job

    @Before
    void setUp()
    {
        job = Ref.job
        job.save()

        def product = Ref.product
        product.addToJob(job)
    }

    @Test
    void save()
    {
        assertNotNull job.save()

        // Check relationship
        assertNotNull job.product
    }

    @Test
    void toJson()
    {
        println job.toJson().toString()
        def json = parser.parseText(job.toJson().toString())
        assertEquals job.jobID, json.job.jobID
    }
}
