
<%@ page import="lv.Livro" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'livro.label', default: 'Livro')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-livro" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-livro" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list livro">
			
				<g:if test="${livroInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="livro.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${livroInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${livroInstance?.preco}">
				<li class="fieldcontain">
					<span id="preco-label" class="property-label"><g:message code="livro.preco.label" default="Preco" /></span>
					
						<span class="property-value" aria-labelledby="preco-label"><g:fieldValue bean="${livroInstance}" field="preco"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${livroInstance?.quantidade}">
				<li class="fieldcontain">
					<span id="quantidade-label" class="property-label"><g:message code="livro.quantidade.label" default="Quantidade" /></span>
					
						<span class="property-value" aria-labelledby="quantidade-label"><g:fieldValue bean="${livroInstance}" field="quantidade"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${livroInstance?.autor}">
				<li class="fieldcontain">
					<span id="autor-label" class="property-label"><g:message code="livro.autor.label" default="Autor" /></span>
					
						<span class="property-value" aria-labelledby="autor-label"><g:fieldValue bean="${livroInstance}" field="autor"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${livroInstance?.descricao}">
				<li class="fieldcontain">
					<span id="descricao-label" class="property-label"><g:message code="livro.descricao.label" default="Descricao" /></span>
					
						<g:each in="${livroInstance.descricao}" var="d">
						<span class="property-value" aria-labelledby="descricao-label"><g:link controller="descricao" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${livroInstance?.id}" />
					<g:link class="edit" action="edit" id="${livroInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
