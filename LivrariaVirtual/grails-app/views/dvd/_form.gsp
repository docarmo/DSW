<%@ page import="lv.Dvd" %>



<div class="fieldcontain ${hasErrors(bean: dvdInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="dvd.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${dvdInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dvdInstance, field: 'preco', 'error')} required">
	<label for="preco">
		<g:message code="dvd.preco.label" default="Preco" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="preco" value="${fieldValue(bean: dvdInstance, field: 'preco')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: dvdInstance, field: 'quantidade', 'error')} required">
	<label for="quantidade">
		<g:message code="dvd.quantidade.label" default="Quantidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantidade" type="number" min="0" value="${dvdInstance.quantidade}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: dvdInstance, field: 'diretor', 'error')} required">
	<label for="diretor">
		<g:message code="dvd.diretor.label" default="Diretor" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="diretor" required="" value="${dvdInstance?.diretor}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dvdInstance, field: 'descricao', 'error')} ">
	<label for="descricao">
		<g:message code="dvd.descricao.label" default="Descricao" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${dvdInstance?.descricao?}" var="d">
    <li><g:link controller="descricao" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="descricao" action="create" params="['dvd.id': dvdInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'descricao.label', default: 'Descricao')])}</g:link>
</li>
</ul>

</div>

