
<%@ page import="lv.Descricao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'descricao.label', default: 'Descricao')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-descricao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-descricao" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="texto" title="${message(code: 'descricao.texto.label', default: 'Texto')}" />
					
						<g:sortableColumn property="imagem" title="${message(code: 'descricao.imagem.label', default: 'Imagem')}" />
					
						<g:sortableColumn property="audio" title="${message(code: 'descricao.audio.label', default: 'Audio')}" />
					
						<g:sortableColumn property="video" title="${message(code: 'descricao.video.label', default: 'Video')}" />
					
						<th><g:message code="descricao.produto.label" default="Produto" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${descricaoInstanceList}" status="i" var="descricaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${descricaoInstance.id}">${fieldValue(bean: descricaoInstance, field: "texto")}</g:link></td>
					
						<td>${fieldValue(bean: descricaoInstance, field: "imagem")}</td>
					
						<td>${fieldValue(bean: descricaoInstance, field: "audio")}</td>
					
						<td>${fieldValue(bean: descricaoInstance, field: "video")}</td>
					
						<td>${fieldValue(bean: descricaoInstance, field: "produto")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${descricaoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
