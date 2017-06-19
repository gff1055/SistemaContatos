<%-- ARQUIVO (.tag) ONDE CONTEM AS DEFINICOES DO USUARIO. --%>

<%-- <%@attribute%> = PERMITE QUE A TAG RECEBA PARAMETROS --%>
<%-- name = REPRESENTA O NOME DO PARAMETRO --%>
<%-- required = DEFINE SE O PARAMETRO É OBRIGATORIO OU NAO --%>
<%@ attribute name="id" required="true"%>

<%-- CRIANDO UM INPUT A SER ASSOCIADO COM datepicker --%>
<input id="${id}" name="${id}" />

<script>

    <%-- MOSTRANDO UM CALENDARIO(ASSOCIADO AO INPUT) EM JAVASCRIPT PARA SELECAO --%>
    $("#${id}").datepicker({dateFormat: 'dd/mm/yyyy'});

</script>

