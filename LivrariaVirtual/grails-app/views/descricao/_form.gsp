<%@ page import="lv.Descricao" %>



<div class="fieldcontain ${hasErrors(bean: descricaoInstance, field: 'texto', 'error')} required">
  <label for="texto">
    <g:message code="descricao.texto.label" default="Texto" />
    <span class="required-indicator">*</span>
  </label>
  <g:textArea name="texto" cols="40" rows="5" maxlength="500" required="" value="${descricaoInstance?.texto}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: descricaoInstance, field: 'imagem', 'error')} required">
  <label for="imagem">
    <g:message code="descricao.imagem.label" default="Imagem" />
    <span class="required-indicator">*</span>
  </label>
  <input type="file" id="imagem" name="imagem" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: descricaoInstance, field: 'audio', 'error')} ">
  <label for="audio">
    <g:message code="descricao.audio.label" default="Audio" />

  </label>
  <input type = "file" name="audio"/>
  
</div>

<div class="fieldcontain ${hasErrors(bean: descricaoInstance, field: 'video', 'error')} ">
  <label for="video">
    <g:message code="descricao.video.label" default="Video" />

  </label>
  <input type = "file" name="video"/>
</div>

<div class="fieldcontain ${hasErrors(bean: descricaoInstance, field: 'produto', 'error')} required">
  <label for="produto">
    <g:message code="descricao.produto.label" default="Produto" />
    <span class="required-indicator">*</span>
  </label>
  <g:select id="produto" name="produto.id" from="${lv.Produto.list()}" optionKey="id" required="" value="${descricaoInstance?.produto?.id}" class="many-to-one"/>
</div>

