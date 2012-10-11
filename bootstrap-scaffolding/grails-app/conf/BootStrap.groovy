import com.arm.nimbus.Job

class BootStrap {

    def init = { servletContext ->

        def t1 = System.currentTimeMillis()
        def x = 10
        (0..x).each{
            def j = new Job(jobID: "${it}", command: "ls", state: "running")
            if(!j || !j.save()){
                log.error ">> error detected !!!"
            }
        }



        log.info (System.currentTimeMillis() - t1) + " ms to create ${x} jobs"
    }

    def destroy = {
    }
}
