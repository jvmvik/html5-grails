package com.arm.nimbus



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(JobService)
@Mock(Job)
class JobServiceTests {

    void testFindAll() {
        def x = 10
        (1..x).each {
            def j = new Job(jobID: "${it}", command: "ls", state: "running")
            assertNotNull j
            assertNotNull j.save(flush:true)
        }
        assertEquals x, Job.count()
        assertEquals x, Job.findAll().size()
        def jobs = JobService.findAll()
        assertEquals x, jobs.size()
    }
}
