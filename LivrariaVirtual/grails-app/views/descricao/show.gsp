
<%@ page import="lv.Descricao" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
  <g:set var="entityName" value="${message(code: 'descricao.label', default: 'Descricao')}" />
  <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
  <a href="#show-descricao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
  <div class="nav" role="navigation">
    <ul>
      <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
      <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
      <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
  </div>
  <div id="show-descricao" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
      <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list descricao">

      <g:if test="${descricaoInstance?.texto}">
        <li class="fieldcontain">
          <span id="texto-label" class="property-label"><g:message code="descricao.texto.label" default="Texto" /></span>

          <span class="property-value" aria-labelledby="texto-label"><g:fieldValue bean="${descricaoInstance}" field="texto"/></span>

        </li>
      </g:if>

      <g:if test="${descricaoInstance?.imagem}">
        <li class="fieldcontain">
          <span id="imagem-label" class="property-label"><g:message code="descricao.imagem.label" default="Imagem" /></span>

          <span class="property-value" aria-labelledby="imagem-label">
            <img src="${createLinkTo(dir:'produto/'+ descricaoInstance.produto.id, file:''+descricaoInstance.imagem)}"
                 alt="${descricaoInstance.imagem}"
                 title="${descricaoInstance.imagem}" 
                 width="120px" height="120px"/>
          </span>

        </li>
      </g:if>

      <g:if test="${descricaoInstance?.audio}">
        <li class="fieldcontain">
          <span id="audio-label" class="property-label"><g:message code="descricao.audio.label" default="Audio" /></span>

          <span class="property-value" aria-labelledby="audio-label">
            <audio controls>
              <source src="${createLinkTo(dir:'produto/'+ descricaoInstance.produto.id, file:''+descricaoInstance.audio)}" 
                      type="audio/ogg">
            </audio>
          </span>

        </li>
      </g:if>

      <g:if test="${descricaoInstance?.video}">
        <li class="fieldcontain">
          <span id="video-label" class="property-label"><g:message code="descricao.video.label" default="Video" /></span>

          <span class="property-value" aria-labelledby="video-label">
            <video width="320" height="240" controls>
              <source src="${createLinkTo(dir:'produto/'+ descricaoInstance.produto.id, file:''+descricaoInstance.video)}" 
                      type="video/ogg">
            </video>
          </span>

        </li>
      </g:if>

      <g:if test="${descricaoInstance?.produto}">
        <li class="fieldcontain">
          <span id="produto-label" class="property-label"><g:message code="descricao.produto.label" default="Produto" /></span>

          <span class="property-value" aria-labelledby="produto-label">
            <g:link controller="${descricaoInstance?.produto?.getClass().getSimpleName().toLowerCase()}" 
                    action="show" id="${descricaoInstance?.produto?.id}">${descricaoInstance?.produto?.encodeAsHTML()}</g:link>
          </span>

        </li>
      </g:if>

    </ol>
    <g:form>
      <fieldset class="buttons">
        <g:hiddenField name="id" value="${descricaoInstance?.id}" />
        <g:link class="edit" action="edit" id="${descricaoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
        <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
      </fieldset>
    </g:form>
  </div>
</body>
</html>
