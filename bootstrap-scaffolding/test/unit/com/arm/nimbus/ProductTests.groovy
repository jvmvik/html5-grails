package com.arm.nimbus

import grails.test.mixin.*
import org.junit.*
import groovy.json.JsonSlurper

/**
 * Product domain object
 */
@TestFor(Product)
@Mock([Product,Job])
class ProductTests {

    def parser = new JsonSlurper()
    def product

    @Before
    void setUp()
    {
        def job = Ref.job
        product = Ref.product
        product.addToJob(job)
    }

    @Test
    void save()
    {
       println product.toJson().toString()
       assertNotNull product.save()
    }

    @Test
    void toJson()
    {
        assertNotNull product.toJson().toString()
        def json = parser.parseText(product.toJson().toString())
        assertEquals product.name, json.product.name
    }
}
