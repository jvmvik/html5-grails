package com.arm.nimbus

class Product {

    String name
    String projectCode
    String foundry
    String technology

    Date createdDate
    Date updatedDate

    static hasMany = [jobs: Job]

    static constraints =
    {
       name(blank:false)
       projectCode(blank:false)
       foundry(blank:false)
       technology(blank:false)
    }

    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }
}
