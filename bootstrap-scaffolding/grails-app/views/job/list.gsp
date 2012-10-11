
<%@ page import="com.arm.nimbus.Job" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'job.label', default: 'Job')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row-fluid">
			
			<div class="span3">
				<div class="well">
					<ul class="nav nav-list">
						<li class="nav-header">${entityName}</li>
						<li class="active">
							<g:link class="list" action="list">
								<i class="icon-list icon-white"></i>
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
					<h1><g:message code="default.list.label" args="[entityName]" /></h1>
				</div>

				<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>
				
				<table class="table table-striped">
					<thead>
						<tr>
						
							<g:sortableColumn property="command" title="${message(code: 'job.command.label', default: 'Command')}" />
						
							<g:sortableColumn property="jobID" title="${message(code: 'job.jobID.label', default: 'Job ID')}" />
						
							<g:sortableColumn property="state" title="${message(code: 'job.state.label', default: 'State')}" />
						
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${jobInstanceList}" var="jobInstance">
						<tr>
						
							<td>${fieldValue(bean: jobInstance, field: "command")}</td>
						
							<td>${fieldValue(bean: jobInstance, field: "jobID")}</td>
						
							<td>${fieldValue(bean: jobInstance, field: "state")}</td>
						
							<td class="link">
								<g:link action="show" id="${jobInstance.id}" class="btn btn-small">Show &raquo;</g:link>
							</td>
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<bootstrap:paginate total="${jobInstanceTotal}" />
				</div>
			</div>

		</div>
	</body>
</html>
