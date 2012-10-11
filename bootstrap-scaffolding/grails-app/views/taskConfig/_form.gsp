<%@ page import="com.arm.nimbus.TaskConfig" %>



<div class="fieldcontain ${hasErrors(bean: taskConfigInstance, field: 'module', 'error')} required">
	<label for="module">
		<g:message code="taskConfig.module.label" default="Module" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="module" required="" value="${taskConfigInstance?.module}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: taskConfigInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="taskConfig.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${taskConfigInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: taskConfigInstance, field: 'lsf', 'error')} required">
	<label for="lsf">
		<g:message code="taskConfig.lsf.label" default="Lsf" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lsf" required="" value="${taskConfigInstance?.lsf}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: taskConfigInstance, field: 'job', 'error')} required">
	<label for="job">
		<g:message code="taskConfig.job.label" default="Job" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="job" name="job.id" from="${com.arm.nimbus.Job.list()}" optionKey="id" required="" value="${taskConfigInstance?.job?.id}" class="many-to-one"/>
</div>

