function validarNumero() {
	  numero = document.getElementById('numero-de-telefone').value;
	  if (numero === ''){
		  alert("Informe o número de telefone");
		  return false;
	  }
	  return true;
	}