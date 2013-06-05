
<%@ page import="lv.Produto" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
  <g:set var="entityName" value="${message(code: 'produto.label', 
                          default: 'Produto')}" />
  <title>
    <g:message code="produto.list" />
  </title>
</head>
<body>
  <a href="#list-produto" class="skip" tabindex="-1">
    <g:message code="default.link.skip.label" default="Skip to content&hellip;"/>
  </a>
  <div class="nav" role="navigation">
    <ul>
      <li><a class="home" href="${createLink(uri: '/')}">
          <g:message code="default.home.label"/>
        </a></li>
      <li><g:link class="create" controller="cd" action="create">
        <g:message code="cd.new"/>
      </g:link></li>
      <li><g:link class="create" controller="dvd" action="create">
        <g:message code="dvd.new" />
      </g:link></li>
      <li><g:link class="create" controller="cd" action="create">
        <g:message code="livro.new" />
      </g:link></li>
    </ul>
  </div>
  <div id="list-produto" class="content scaffold-list" role="main">
    <h1><g:message code="produto.list"/> </h1>
    <g:if test="${flash.message}">
      <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
      <thead>
        <tr>

      <g:sortableColumn 
        property="nome" 
        title="${message(code: 'produto.nome.label', default: 'Nome')}" />
      <g:sortableColumn 
        property="preco" 
        title="${message(code: 'produto.preco.label', default: 'Preco')}" />
      <g:sortableColumn 
        property="quantidade" 
        title="${message(code: 'produto.quantidade.label', default: 'Quantidade')}" />
      </tr>
      </thead>
      <tbody>
      <g:each in="${produtoInstanceList}" status="i" var="produtoInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
          <td><g:link action="show" 
                      controller="${produtoInstance.getClass().getSimpleName().toLowerCase()}" 
                      id="${produtoInstance.id}">
              ${fieldValue(bean: produtoInstance, field: "nome")}
          </g:link></td>
        <td>${fieldValue(bean: produtoInstance, field: "preco")}</td>
        <td>${fieldValue(bean: produtoInstance, field: "quantidade")}</td>
        </tr>
      </g:each>
      </tbody>
    </table>
    <div class="pagination">
      <g:paginate total="${produtoInstanceTotal}" />
    </div>
  </div>
</body>
</html>