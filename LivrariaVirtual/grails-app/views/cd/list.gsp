
<%@ page import="lv.Cd" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cd.label', default: 'Cd')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-cd" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-cd" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'cd.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="preco" title="${message(code: 'cd.preco.label', default: 'Preco')}" />
					
						<g:sortableColumn property="quantidade" title="${message(code: 'cd.quantidade.label', default: 'Quantidade')}" />
					
						<g:sortableColumn property="artista" title="${message(code: 'cd.artista.label', default: 'Artista')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${cdInstanceList}" status="i" var="cdInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${cdInstance.id}">${fieldValue(bean: cdInstance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: cdInstance, field: "preco")}</td>
					
						<td>${fieldValue(bean: cdInstance, field: "quantidade")}</td>
					
						<td>${fieldValue(bean: cdInstance, field: "artista")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${cdInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
