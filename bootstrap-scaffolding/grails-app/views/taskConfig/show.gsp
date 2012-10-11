
<%@ page import="com.arm.nimbus.TaskConfig" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'taskConfig.label', default: 'TaskConfig')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row-fluid">
			
			<div class="span3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">${entityName}</li>
						<li>
							<g:link class="list" action="list">
								<i class="icon-list"></i>
								<g:message code="default.list.label" args="[entityName]" />
							</g:link>
						</li>
						<li>
							<g:link class="create" action="create">
								<i class="icon-plus"></i>
								<g:message code="default.create.label" args="[entityName]" />
							</g:link>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="span9">

				<div class="page-header">
					<h1><g:message code="default.show.label" args="[entityName]" /></h1>
				</div>

				<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>

				<dl>
				
					<g:if test="${taskConfigInstance?.module}">
						<dt><g:message code="taskConfig.module.label" default="Module" /></dt>
						
							<dd><g:fieldValue bean="${taskConfigInstance}" field="module"/></dd>
						
					</g:if>
				
					<g:if test="${taskConfigInstance?.name}">
						<dt><g:message code="taskConfig.name.label" default="Name" /></dt>
						
							<dd><g:fieldValue bean="${taskConfigInstance}" field="name"/></dd>
						
					</g:if>
				
					<g:if test="${taskConfigInstance?.lsf}">
						<dt><g:message code="taskConfig.lsf.label" default="Lsf" /></dt>
						
							<dd><g:fieldValue bean="${taskConfigInstance}" field="lsf"/></dd>
						
					</g:if>
				
					<g:if test="${taskConfigInstance?.job}">
						<dt><g:message code="taskConfig.job.label" default="Job" /></dt>
						
							<dd><g:link controller="job" action="show" id="${taskConfigInstance?.job?.id}">${taskConfigInstance?.job?.encodeAsHTML()}</g:link></dd>
						
					</g:if>
				
				</dl>

				<g:form>
					<g:hiddenField name="id" value="${taskConfigInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn" action="edit" id="${taskConfigInstance?.id}">
							<i class="icon-pencil"></i>
							<g:message code="default.button.edit.label" default="Edit" />
						</g:link>
						<button class="btn btn-danger" type="submit" name="_action_delete">
							<i class="icon-trash icon-white"></i>
							<g:message code="default.button.delete.label" default="Delete" />
						</button>
					</div>
				</g:form>

			</div>

		</div>
	</body>
</html>
