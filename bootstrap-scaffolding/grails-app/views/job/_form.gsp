<%@ page import="com.arm.nimbus.Job" %>



<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'command', 'error')} ">
	<label for="command">
		<g:message code="job.command.label" default="Command" />
		
	</label>
	<g:textField name="command" value="${jobInstance?.command}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'jobID', 'error')} ">
	<label for="jobID">
		<g:message code="job.jobID.label" default="Job ID" />
		
	</label>
	<g:textField name="jobID" value="${jobInstance?.jobID}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: jobInstance, field: 'state', 'error')} ">
	<label for="state">
		<g:message code="job.state.label" default="State" />
		
	</label>
	<g:textField name="state" value="${jobInstance?.state}"/>
</div>

