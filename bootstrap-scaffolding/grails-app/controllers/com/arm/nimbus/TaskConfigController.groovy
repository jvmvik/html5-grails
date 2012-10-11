package com.arm.nimbus

import org.springframework.dao.DataIntegrityViolationException

class TaskConfigController {

    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

    def index() {
        redirect action: 'list', params: params
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [taskConfigInstanceList: TaskConfig.list(params), taskConfigInstanceTotal: TaskConfig.count()]
    }

    def create() {
		switch (request.method) {
		case 'GET':
        	[taskConfigInstance: new TaskConfig(params)]
			break
		case 'POST':
	        def taskConfigInstance = new TaskConfig(params)
	        if (!taskConfigInstance.save(flush: true)) {
	            render view: 'create', model: [taskConfigInstance: taskConfigInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'taskConfig.label', default: 'TaskConfig'), taskConfigInstance.id])
	        redirect action: 'show', id: taskConfigInstance.id
			break
		}
    }

    def show() {
        def taskConfigInstance = TaskConfig.get(params.id)
        if (!taskConfigInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'taskConfig.label', default: 'TaskConfig'), params.id])
            redirect action: 'list'
            return
        }

        [taskConfigInstance: taskConfigInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def taskConfigInstance = TaskConfig.get(params.id)
	        if (!taskConfigInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'taskConfig.label', default: 'TaskConfig'), params.id])
	            redirect action: 'list'
	            return
	        }

	        [taskConfigInstance: taskConfigInstance]
			break
		case 'POST':
	        def taskConfigInstance = TaskConfig.get(params.id)
	        if (!taskConfigInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'taskConfig.label', default: 'TaskConfig'), params.id])
	            redirect action: 'list'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (taskConfigInstance.version > version) {
	                taskConfigInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'taskConfig.label', default: 'TaskConfig')] as Object[],
	                          "Another user has updated this TaskConfig while you were editing")
	                render view: 'edit', model: [taskConfigInstance: taskConfigInstance]
	                return
	            }
	        }

	        taskConfigInstance.properties = params

	        if (!taskConfigInstance.save(flush: true)) {
	            render view: 'edit', model: [taskConfigInstance: taskConfigInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'taskConfig.label', default: 'TaskConfig'), taskConfigInstance.id])
	        redirect action: 'show', id: taskConfigInstance.id
			break
		}
    }

    def delete() {
        def taskConfigInstance = TaskConfig.get(params.id)
        if (!taskConfigInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'taskConfig.label', default: 'TaskConfig'), params.id])
            redirect action: 'list'
            return
        }

        try {
            taskConfigInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'taskConfig.label', default: 'TaskConfig'), params.id])
            redirect action: 'list'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'taskConfig.label', default: 'TaskConfig'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
