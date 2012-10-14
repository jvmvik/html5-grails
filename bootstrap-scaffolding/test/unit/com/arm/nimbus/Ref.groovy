package com.arm.nimbus

/**
 * Provide domain object for testing
 */
class Ref
{
    static job =  new Job(jobID: "2136", command: "ls", state: "running")

    static taskConfig = new TaskConfig(name:"CB", lsf: "command", module: "cellbuider/4.3.0")

    static product = new Product(name:"product1", projectCode:"21297", foundry:"TSMC", technology:"CLN40G", createdDate:new Date())


}
