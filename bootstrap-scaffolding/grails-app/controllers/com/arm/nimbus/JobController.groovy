package com.arm.nimbus

import org.springframework.dao.DataIntegrityViolationException

class JobController {

    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

    def index() {
        redirect action: 'list', params: params
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [jobInstanceList: Job.list(params), jobInstanceTotal: Job.count()]
    }

    def create() {
		switch (request.method) {
		case 'GET':
        	[jobInstance: new Job(params)]
			break
		case 'POST':
	        def jobInstance = new Job(params)
	        if (!jobInstance.save(flush: true)) {
	            render view: 'create', model: [jobInstance: jobInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'job.label', default: 'Job'), jobInstance.id])
	        redirect action: 'show', id: jobInstance.id
			break
		}
    }

    def show() {
        def jobInstance = Job.get(params.id)
        if (!jobInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), params.id])
            redirect action: 'list'
            return
        }

        [jobInstance: jobInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def jobInstance = Job.get(params.id)
	        if (!jobInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), params.id])
	            redirect action: 'list'
	            return
	        }

	        [jobInstance: jobInstance]
			break
		case 'POST':
	        def jobInstance = Job.get(params.id)
	        if (!jobInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), params.id])
	            redirect action: 'list'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (jobInstance.version > version) {
	                jobInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'job.label', default: 'Job')] as Object[],
	                          "Another user has updated this Job while you were editing")
	                render view: 'edit', model: [jobInstance: jobInstance]
	                return
	            }
	        }

	        jobInstance.properties = params

	        if (!jobInstance.save(flush: true)) {
	            render view: 'edit', model: [jobInstance: jobInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'job.label', default: 'Job'), jobInstance.id])
	        redirect action: 'show', id: jobInstance.id
			break
		}
    }

    def delete() {
        def jobInstance = Job.get(params.id)
        if (!jobInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'job.label', default: 'Job'), params.id])
            redirect action: 'list'
            return
        }

        try {
            jobInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'job.label', default: 'Job'), params.id])
            redirect action: 'list'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'job.label', default: 'Job'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
