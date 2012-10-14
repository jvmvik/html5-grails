package com.arm.nimbus

import groovy.json.JsonBuilder

class Product {

    String name
    String projectCode
    String foundry
    String technology

    Date createdDate
    Date updatedDate

    static hasMany = [job: Job, taskConfig: TaskConfig]

    static constraints =
    {
       name(blank:false)
       projectCode(blank:false)
       foundry(blank:false)
       technology(blank:false)
       updatedDate(nullable: true)
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

    def toJson()
    {
        def jobids = []
        job.each
        {
           jobids.add(it.id)
        }

        def json = new JsonBuilder()
        json.product {
            name name
            foundry foundry
            technology technology
            createdDate createdDate
            updatedDate updatedDate
            jobs jobids
        }
        return json
    }
}
