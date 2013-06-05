<%@ page import="agenda.Contato" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main">
  <g:set var="entityName" value="${message(code: 'contato.label', default: 'Contato')}" />
  <title><g:message code="default.show.label" args="[entityName]" /></title>
  <resource:tabView />
  <resource:accordion skin="default" />
</head>
<body>
  <a href="#show-contato" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
  <div class="nav" role="navigation">
    <ul>
      <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
      <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
      <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
  </div>
  <div id="show-contato" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
      <div class="message" role="status">${flash.message}</div>
    </g:if>

    <richui:tabView id="tabView">
      <richui:tabLabels>
        <richui:tabLabel selected="true" title="${message(code: 'contato.nome.label', default: 'Nome')}" />
        <richui:tabLabel title="${message(code: 'contato.endereco.label', default: 'Endereço')}" />
        <richui:tabLabel title="${message(code: 'contato.telefone.label', default: 'Telefone')}"/>
        <richui:tabLabel title="${message(code: 'contato.email.label', default: 'E-Mail')}" />
        <richui:tabLabel title="${message(code: 'contato.homepage.label', default: 'Telefone')}" />
        <richui:tabLabel title="${message(code: 'contato.datanasc.label', default: 'Telefone')}" />
      </richui:tabLabels>
      <richui:tabContents>
        <richui:tabContent>
${fieldValue(bean: contatoInstance, field: "nome")}
        </richui:tabContent>
        <richui:tabContent>
${fieldValue(bean: contatoInstance, field: "endereco")}
          <p>
${fieldValue(bean: contatoInstance, field: "complemento")}
          <p>
${fieldValue(bean: contatoInstance, field: "cidade")}
        </richui:tabContent>
        <richui:tabContent>
          <richui:accordion>
            <richui:accordionItem id="1" caption="${message(code: 'contato.fixo.label', default: 'Fixo')}"> ${fieldValue(bean: contatoInstance, field: "fixo")}
            </richui:accordionItem>
            <richui:accordionItem caption="${message(code: 'contato.celular.label', default: 'Celular')}">${fieldValue(bean: contatoInstance, field: "celular")}
            </richui:accordionItem>
          </richui:accordion>
        </richui:tabContent>
        <richui:tabContent>
          <richui:accordion>
            <richui:accordionItem id="1" caption="${message(code: 'contato.principal.label', default: 'Principal')}">${fieldValue(bean: contatoInstance, field: "principal")}
            </richui:accordionItem>
            <richui:accordionItem caption="${message(code: 'contato.alternativo.label', default: 'Alternativo')}">${fieldValue(bean: contatoInstance, field: "alternativo")}
            </richui:accordionItem>
          </richui:accordion>
        </richui:tabContent>
        <richui:tabContent>
${fieldValue(bean: contatoInstance, field: "homepage")}
        </richui:tabContent>
        <richui:tabContent>
          <g:formatDate format="dd-MM-yyyy" date="${contatoInstance?.dataNasc}"/>
        </richui:tabContent>
      </richui:tabContents>
    </richui:tabView>
    <g:form>
      <fieldset class="buttons">
        <g:hiddenField name="id" value="${contatoInstance?.id}" />
        <g:link class="edit" action="edit" id="${contatoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
        <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
      </fieldset>
    </g:form>
  </div>
</body>
</html>
