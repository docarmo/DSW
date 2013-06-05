<%@ page import="lv.Cd" %>



<div class="fieldcontain ${hasErrors(bean: cdInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="cd.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${cdInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: cdInstance, field: 'preco', 'error')} required">
	<label for="preco">
		<g:message code="cd.preco.label" default="Preco" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="preco" value="${fieldValue(bean: cdInstance, field: 'preco')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: cdInstance, field: 'quantidade', 'error')} required">
	<label for="quantidade">
		<g:message code="cd.quantidade.label" default="Quantidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantidade" type="number" min="0" value="${cdInstance.quantidade}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: cdInstance, field: 'artista', 'error')} required">
	<label for="artista">
		<g:message code="cd.artista.label" default="Artista" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="artista" required="" value="${cdInstance?.artista}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: cdInstance, field: 'descricao', 'error')} ">
	<label for="descricao">
		<g:message code="cd.descricao.label" default="Descricao" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${cdInstance?.descricao?}" var="d">
    <li><g:link controller="descricao" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="descricao" action="create" params="['cd.id': cdInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'descricao.label', default: 'Descricao')])}</g:link>
</li>
</ul>

</div>

