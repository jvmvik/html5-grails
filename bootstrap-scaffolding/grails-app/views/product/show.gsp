
<%@ page import="com.arm.nimbus.Product" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
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
				
					<g:if test="${productInstance?.name}">
						<dt><g:message code="product.name.label" default="Name" /></dt>
						
							<dd><g:fieldValue bean="${productInstance}" field="name"/></dd>
						
					</g:if>
				
					<g:if test="${productInstance?.projectCode}">
						<dt><g:message code="product.projectCode.label" default="Project Code" /></dt>
						
							<dd><g:fieldValue bean="${productInstance}" field="projectCode"/></dd>
						
					</g:if>
				
					<g:if test="${productInstance?.foundry}">
						<dt><g:message code="product.foundry.label" default="Foundry" /></dt>
						
							<dd><g:fieldValue bean="${productInstance}" field="foundry"/></dd>
						
					</g:if>
				
					<g:if test="${productInstance?.technology}">
						<dt><g:message code="product.technology.label" default="Technology" /></dt>
						
							<dd><g:fieldValue bean="${productInstance}" field="technology"/></dd>
						
					</g:if>
				
					<g:if test="${productInstance?.createdDate}">
						<dt><g:message code="product.createdDate.label" default="Created Date" /></dt>
						
							<dd><g:formatDate date="${productInstance?.createdDate}" /></dd>
						
					</g:if>
				
					<g:if test="${productInstance?.updatedDate}">
						<dt><g:message code="product.updatedDate.label" default="Updated Date" /></dt>
						
							<dd><g:formatDate date="${productInstance?.updatedDate}" /></dd>
						
					</g:if>
				
				</dl>

				<g:form>
					<g:hiddenField name="id" value="${productInstance?.id}" />
					<div class="form-actions">
						<g:link class="btn" action="edit" id="${productInstance?.id}">
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
