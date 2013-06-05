<%@ page import="agenda.Contato" %>



<div class="fieldcontain ${hasErrors(bean: contatoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="contato.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${contatoInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contatoInstance, field: 'endereco', 'error')} ">
	<label for="endereco">
		<g:message code="contato.endereco.label" default="Endereco" />
		
	</label>
	<g:textField name="endereco" value="${contatoInstance?.endereco}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contatoInstance, field: 'complemento', 'error')} ">
	<label for="complemento">
		<g:message code="contato.complemento.label" default="Complemento" />
		
	</label>
	<g:textField name="complemento" value="${contatoInstance?.complemento}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contatoInstance, field: 'cidade', 'error')} required">
	<label for="cidade">
		<g:message code="contato.cidade.label" default="Cidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cidade" name="cidade.id" from="${agenda.Cidade.list()}" optionKey="id" required="" value="${contatoInstance?.cidade?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contatoInstance, field: 'fixo', 'error')} ">
	<label for="fixo">
		<g:message code="contato.fixo.label" default="Fixo" />
		
	</label>
	<g:textField name="fixo" pattern="${contatoInstance.constraints.fixo.matches}" value="${contatoInstance?.fixo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contatoInstance, field: 'celular', 'error')} ">
	<label for="celular">
		<g:message code="contato.celular.label" default="Celular" />
		
	</label>
	<g:textField name="celular" pattern="${contatoInstance.constraints.celular.matches}" value="${contatoInstance?.celular}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contatoInstance, field: 'principal', 'error')} required">
	<label for="principal">
		<g:message code="contato.principal.label" default="Principal" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="principal" required="" value="${contatoInstance?.principal}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contatoInstance, field: 'alternativo', 'error')} ">
	<label for="alternativo">
		<g:message code="contato.alternativo.label" default="Alternativo" />
		
	</label>
	<g:field type="email" name="alternativo" value="${contatoInstance?.alternativo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contatoInstance, field: 'homepage', 'error')} ">
	<label for="homepage">
		<g:message code="contato.homepage.label" default="Homepage" />
		
	</label>
	<g:field type="url" name="homepage" value="${contatoInstance?.homepage}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: contatoInstance, field: 'dataNasc', 'error')} required">
	<label for="dataNasc">
		<g:message code="contato.dataNasc.label" default="Data Nasc" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataNasc" precision="day"  value="${contatoInstance?.dataNasc}"  />
</div>

