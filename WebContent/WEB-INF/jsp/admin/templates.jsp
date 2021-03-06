<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Templates</title>
<style type="text/css" media="screen">
    #editor { 
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
    }
</style>
<link rel="stylesheet" href="<c:url value='/resource/css/bootstrap.min.css'/>">
</head>
<body>
<div id="editor" style="width: 800px;height: 500px;position: relative;">

	
</div>
<script type="text/javascript" src="<c:url value="/resource/js/jquery-1.8.2.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resource/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resource/js/ace/src-noconflict/ace.js"/>"></script>
<script type="text/javascript">
    var editor = ace.edit("editor");  
    editor.setTheme("ace/theme/monokai");
    editor.getSession().setMode("ace/mode/html");
    ace.config.loadModule('ace/ext/language_tools', function() {
        editor.setOptions({
            enableBasicAutocompletion: true,
            enableSnippets: true
        })
    }); 
    function salvaArquivo(){
    	editor.selectAll();
    	$("#arquivo").attr("value",editor.getCopyText());
    	$("#frmSalvar").submit();
    }
</script>
<div>
	<form action="<c:url value="/admin/savetemplate" />" method="post" id="frmSalvar">
	<input type="hidden" id="arquivo" name="arquivo"/>
	<br><input type="button" class="btn" value="Salvar" onclick="salvaArquivo();">
	</form>
</div>
</body>
</html>