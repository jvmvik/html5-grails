
<%@ page import="com.arm.nimbus.TaskConfig" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'taskConfig.label', default: 'TaskConfig')}" />
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
						
							<g:sortableColumn property="module" title="${message(code: 'taskConfig.module.label', default: 'Module')}" />
						
							<g:sortableColumn property="name" title="${message(code: 'taskConfig.name.label', default: 'Name')}" />
						
							<g:sortableColumn property="lsf" title="${message(code: 'taskConfig.lsf.label', default: 'Lsf')}" />
						
							<th class="header"><g:message code="taskConfig.job.label" default="Job" /></th>
						
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${taskConfigInstanceList}" var="taskConfigInstance">
						<tr>
						
							<td>${fieldValue(bean: taskConfigInstance, field: "module")}</td>
						
							<td>${fieldValue(bean: taskConfigInstance, field: "name")}</td>
						
							<td>${fieldValue(bean: taskConfigInstance, field: "lsf")}</td>
						
							<td>${fieldValue(bean: taskConfigInstance, field: "job")}</td>
						
							<td class="link">
								<g:link action="show" id="${taskConfigInstance.id}" class="btn btn-small">Show &raquo;</g:link>
							</td>
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<bootstrap:paginate total="${taskConfigInstanceTotal}" />
				</div>
			</div>

		</div>
	</body>
</html>
