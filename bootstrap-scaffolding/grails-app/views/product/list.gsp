
<%@ page import="com.arm.nimbus.Product" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
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
						
							<g:sortableColumn property="name" title="${message(code: 'product.name.label', default: 'Name')}" />
						
							<g:sortableColumn property="projectCode" title="${message(code: 'product.projectCode.label', default: 'Project Code')}" />
						
							<g:sortableColumn property="foundry" title="${message(code: 'product.foundry.label', default: 'Foundry')}" />
						
							<g:sortableColumn property="technology" title="${message(code: 'product.technology.label', default: 'Technology')}" />
						
							<g:sortableColumn property="createdDate" title="${message(code: 'product.createdDate.label', default: 'Created Date')}" />
						
							<g:sortableColumn property="updatedDate" title="${message(code: 'product.updatedDate.label', default: 'Updated Date')}" />
						
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${productInstanceList}" var="productInstance">
						<tr>
						
							<td>${fieldValue(bean: productInstance, field: "name")}</td>
						
							<td>${fieldValue(bean: productInstance, field: "projectCode")}</td>
						
							<td>${fieldValue(bean: productInstance, field: "foundry")}</td>
						
							<td>${fieldValue(bean: productInstance, field: "technology")}</td>
						
							<td><g:formatDate date="${productInstance.createdDate}" /></td>
						
							<td><g:formatDate date="${productInstance.updatedDate}" /></td>
						
							<td class="link">
								<g:link action="show" id="${productInstance.id}" class="btn btn-small">Show &raquo;</g:link>
							</td>
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<bootstrap:paginate total="${productInstanceTotal}" />
				</div>
			</div>

		</div>
	</body>
</html>
