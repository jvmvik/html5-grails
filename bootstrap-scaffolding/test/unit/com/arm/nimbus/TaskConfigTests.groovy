package com.arm.nimbus

import grails.test.mixin.*
import org.junit.*
import groovy.json.JsonSlurper

/**
 *
 */
@TestFor(TaskConfig)
@Mock([Product,TaskConfig])
class TaskConfigTests {

    def parser = new JsonSlurper()
    def taskConfig

    @Before
    void setUp()
    {
        taskConfig = Ref.taskConfig
        taskConfig.save()
        println taskConfig.errors
    }

    @Test
    void save()
    {
        assertNotNull taskConfig.save()

    }

    @Test
    void relationship()
    {
        def product = Ref.product
        product.addToTaskConfig(taskConfig)
        taskConfig.save()

        assertNotNull taskConfig.product
    }

    @Test
    void toJson()
    {
        assertNotNull taskConfig.toJson().toString()

        def json = parser.parseText(taskConfig.toJson().toString())

        assertEquals taskConfig.name, json.taskConfig.name
    }

}
