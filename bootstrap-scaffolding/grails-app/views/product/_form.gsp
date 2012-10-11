<%@ page import="com.arm.nimbus.Product" %>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="product.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${productInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'projectCode', 'error')} required">
	<label for="projectCode">
		<g:message code="product.projectCode.label" default="Project Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="projectCode" required="" value="${productInstance?.projectCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'foundry', 'error')} required">
	<label for="foundry">
		<g:message code="product.foundry.label" default="Foundry" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="foundry" required="" value="${productInstance?.foundry}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'technology', 'error')} required">
	<label for="technology">
		<g:message code="product.technology.label" default="Technology" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="technology" required="" value="${productInstance?.technology}"/>
</div>

