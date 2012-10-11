package com.arm.nimbus

/***
 * Database operation for Job
 */
class JobService {

    def listAll()
    {
      return Job.findAll()
    }
}
