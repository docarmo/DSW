<%@ page import="lv.Livro" %>



<div class="fieldcontain ${hasErrors(bean: livroInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="livro.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${livroInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: livroInstance, field: 'preco', 'error')} required">
	<label for="preco">
		<g:message code="livro.preco.label" default="Preco" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="preco" value="${fieldValue(bean: livroInstance, field: 'preco')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: livroInstance, field: 'quantidade', 'error')} required">
	<label for="quantidade">
		<g:message code="livro.quantidade.label" default="Quantidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantidade" type="number" min="0" value="${livroInstance.quantidade}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: livroInstance, field: 'autor', 'error')} required">
	<label for="autor">
		<g:message code="livro.autor.label" default="Autor" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="autor" required="" value="${livroInstance?.autor}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: livroInstance, field: 'descricao', 'error')} ">
	<label for="descricao">
		<g:message code="livro.descricao.label" default="Descricao" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${livroInstance?.descricao?}" var="d">
    <li><g:link controller="descricao" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="descricao" action="create" params="['livro.id': livroInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'descricao.label', default: 'Descricao')])}</g:link>
</li>
</ul>

</div>

