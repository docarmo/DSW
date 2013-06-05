<%@ page import="agenda.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="usuario.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${usuarioInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="usuario.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${usuarioInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="usuario.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${usuarioInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="usuario.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${usuarioInstance?.accountExpired}" />
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="usuario.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${usuarioInstance?.accountLocked}" />
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'contatos', 'error')} ">
	<label for="contatos">
		<g:message code="usuario.contatos.label" default="Contatos" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${usuarioInstance?.contatos?}" var="c">
    <li><g:link controller="contato" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="contato" action="create" params="['usuario.id': usuarioInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'contato.label', default: 'Contato')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="usuario.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${usuarioInstance?.enabled}" />
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="usuario.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${usuarioInstance?.passwordExpired}" />
</div>

