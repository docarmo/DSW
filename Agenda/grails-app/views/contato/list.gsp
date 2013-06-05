
<%@ page import="agenda.Contato" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
  <g:set var="entityName" value="${message(code: 'contato.label', default: 'Contato')}" />
  <title><g:message code="default.list.label" args="[entityName]" /></title>
  <resource:autoComplete skin="default" />
</head>
<body>
  <a href="#list-contato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
  <div class="nav" role="navigation">
    <ul>
      <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
      <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
  </div>
  <div id="list-contato" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
      <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table><thead>
      <th> <g:message code="contato.search.label"/> </th>
      <th>
      <richui:autoComplete
        name="search"
        action="${createLinkTo('dir': 'contato/searchAJAX')}"
        onItemSelect="document.location.href =
        '${createLinkTo(dir: 'contato/show')}/' + id;"/>
      </th>
      </thead> </table>
    <table>
      <thead>
        <tr>

      <g:sortableColumn property="nome" title="${message(code: 'contato.nome.label', default: 'Nome')}" />

      <g:sortableColumn property="endereco" title="${message(code: 'contato.endereco.label', default: 'Endereco')}" />

      <g:sortableColumn property="complemento" title="${message(code: 'contato.complemento.label', default: 'Complemento')}" />

      <th><g:message code="contato.cidade.label" default="Cidade" /></th>

      <g:sortableColumn property="fixo" title="${message(code: 'contato.fixo.label', default: 'Fixo')}" />

      <g:sortableColumn property="celular" title="${message(code: 'contato.celular.label', default: 'Celular')}" />

      </tr>
      </thead>
      <tbody>
      <g:each in="${contatoInstanceList}" status="i" var="contatoInstance">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

          <td><g:link action="show" id="${contatoInstance.id}">${fieldValue(bean: contatoInstance, field: "nome")}</g:link></td>

        <td>${fieldValue(bean: contatoInstance, field: "endereco")}</td>

        <td>${fieldValue(bean: contatoInstance, field: "complemento")}</td>

        <td>${fieldValue(bean: contatoInstance, field: "cidade")}</td>

        <td>${fieldValue(bean: contatoInstance, field: "fixo")}</td>

        <td>${fieldValue(bean: contatoInstance, field: "celular")}</td>

        </tr>
      </g:each>
      </tbody>
    </table>
    <div class="pagination">
      <g:paginate total="${contatoInstanceTotal}" />
    </div>
  </div>
</body>
</html>
