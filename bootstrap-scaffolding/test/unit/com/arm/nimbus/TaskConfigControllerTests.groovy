package com.arm.nimbus



import org.junit.*
import grails.test.mixin.*

@TestFor(TaskConfigController)
@Mock(TaskConfig)
class TaskConfigControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/taskConfig/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.taskConfigInstanceList.size() == 0
        assert model.taskConfigInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.taskConfigInstance != null
    }

    void testSave() {
        controller.save()

        assert model.taskConfigInstance != null
        assert view == '/taskConfig/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/taskConfig/show/1'
        assert controller.flash.message != null
        assert TaskConfig.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/taskConfig/list'

        populateValidParams(params)
        def taskConfig = new TaskConfig(params)

        assert taskConfig.save() != null

        params.id = taskConfig.id

        def model = controller.show()

        assert model.taskConfigInstance == taskConfig
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/taskConfig/list'

        populateValidParams(params)
        def taskConfig = new TaskConfig(params)

        assert taskConfig.save() != null

        params.id = taskConfig.id

        def model = controller.edit()

        assert model.taskConfigInstance == taskConfig
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/taskConfig/list'

        response.reset()

        populateValidParams(params)
        def taskConfig = new TaskConfig(params)

        assert taskConfig.save() != null

        // test invalid parameters in update
        params.id = taskConfig.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/taskConfig/edit"
        assert model.taskConfigInstance != null

        taskConfig.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/taskConfig/show/$taskConfig.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        taskConfig.clearErrors()

        populateValidParams(params)
        params.id = taskConfig.id
        params.version = -1
        controller.update()

        assert view == "/taskConfig/edit"
        assert model.taskConfigInstance != null
        assert model.taskConfigInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/taskConfig/list'

        response.reset()

        populateValidParams(params)
        def taskConfig = new TaskConfig(params)

        assert taskConfig.save() != null
        assert TaskConfig.count() == 1

        params.id = taskConfig.id

        controller.delete()

        assert TaskConfig.count() == 0
        assert TaskConfig.get(taskConfig.id) == null
        assert response.redirectedUrl == '/taskConfig/list'
    }
}
